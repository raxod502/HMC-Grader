from __future__ import division, print_function

import doctest
import os
import re
import sys
import traceback

from app.helpers.command import Command


# The name of the plugin as it is displayed on the web interface.
PLUGIN_NAME = "HMMM"


class CouldNotRunHmmmTestsError(Exception):
    """Exception raised when none of the HMMM tests could be run (for
    instance, if the test file could not be found).

    This exception is not raised when an error occurs while running a
    single test. In that case the error is reported in the failedTests
    map returned by the runTests function.
    """
    pass


def parse_test_case_(string):
    """Helper function for parse_test_case that returns either the parsed
    test case or a string (meaning that an error occurred).
    """
    # Transform the test case from a string into a Python data
    # structure (which should be a tuple).
    try:
        # You can only use the "..." literal in Python 3. In Python 2,
        # that notation is only valid in slices and we have to use the
        # explicit name. Note that this will replace inside strings
        # and comments as well, but comments are removed and there
        # shouldn't be any strings (meaning that a potentially
        # confusing output in that case is probably not too bad).
        test_io = eval(string.replace("...", "Ellipsis"))
    except Exception as e:
        return ("malformed test case {}: {}: {}"
                .format(repr(string), exception_name(e), str(e)))
    # Ensure that the data structure has exactly the shape we want.
    if not isinstance(test_io, tuple):
        return ("test case {} is not a tuple"
                .format(test_io))
    if len(test_io) != 2:
        return ("test case {} has {} elements instead of 2"
                .format(test_io, len(test_io), 2))
    if not isinstance(test_io[0], list):
        return ("input sequence {} for test case {} is not a list"
                .format(test_io[0], test_io))
    if not isinstance(test_io[1], list):
        return ("expected output sequence {} for test case {} is not a list"
                .format(test_io[1], test_io))
    inputs, outputs = test_io
    for input_ in inputs:
        if not isinstance(input_, (tuple, int)):
            return ("input {} in test case {} is not a tuple or int"
                    .format(input_, test_io))
        if isinstance(input_, tuple):
            if len(input_) != 2:
                return ("input {} in test case {} has {} elements"
                        " instead of 2"
                        .format(input_, test_io, len(input_)))
            if not isinstance(input_[0], int):
                return ("input value {} in test case {} is not an int"
                        .format(input_[0], test_io))
            if not isinstance(input_[1], int):
                return ("input repeat length {} in test case {} is not"
                        " an int"
                        .format(input_[1], test_io))
    for index, output in enumerate(outputs):
        if not isinstance(output, (tuple, int)) and output is not Ellipsis:
            return ("expected output {} in test case {} is not a tuple, int,"
                    " Ellipsis, or None"
                    .format(output, test_io))
        if isinstance(output, tuple):
            if len(output) != 2:
                return ("expected output {} in test case {} has {}"
                        " elements instead of 2"
                        .format(output, test_io, len(output)))
            if not isinstance(output[0], int) and output[0] is not Ellipsis:
                return ("expected output value {} in test case {} is not"
                        " an int or Ellipsis"
                        .format(output[0], test_io))
            if not isinstance(output[1], int) and output[1] is not Ellipsis:
                return ("expected output repeat length {} in test case"
                        " {} is not an int or Ellipsis"
                        .format(output[1], test_io))
            if output[1] is Ellipsis:
                if output[0] is not Ellipsis:
                    return ("expected output repeat length in test case {}"
                            " is Ellipsis but corresponding expected output"
                            " value {} is not"
                            .format(test_io, output[0]))
                if index != len(outputs) - 1:
                    return ("expected output sequence {} in test case {}"
                            " contains (..., ...) special form in non-terminal"
                            " position"
                            .format(outputs, test_io))
    # Normalize format of the data structure by expanding the tuples
    # that specify repeat lengths and removing the (..., ...) special
    # form.
    test_io_is_exhaustive = True
    new_inputs = []
    for input_ in inputs:
        if isinstance(input_, tuple):
            new_inputs.extend(input_[0] * input_[1])
        else:
            new_inputs.append(input_)
    new_outputs = []
    for output in outputs:
        if output == (Ellipsis, Ellipsis):
            test_io_is_exhaustive = False
        elif isinstance(output, tuple):
            new_outputs.extend(output[0] * output[1])
        else:
            new_outputs.append(output)
    new_test_io = new_inputs, new_outputs
    return new_test_io, test_io_is_exhaustive


def parse_test_case(string):
    """Given a string, representing one line from a HMMM test file,
    returns a Python data structure representing the test case defined
    by the string.

    The string is evaluated to yield a Python data structure.
    Therefore, anything accepted by Python's "eval" function is OK,
    including expressions with leading or trailing whitespace, and
    comments. Any occurrences of "..." are replaced with "Ellipsis",
    so you can use the "..." literal even though this is Python 2. The
    outermost surrounding parentheses may be omitted, since:

    >>> eval("1, 2")
    (1, 2)

    The resulting data structure should be a tuple of two elements:
    the input sequence and the output sequence. Both of these should
    be (possibly empty) lists.

    An integer in the input sequence means that the program being
    tested is expected to invoke the "read" command, and that the
    provided integer should be passed to it upon invocation of "read".
    A tuple (x, y) of two integers in the input sequence means that
    the integer x should be provided y times (that is, the program is
    expected to invoke "read" at y times, and x is to be provided to
    it each of those times. For example, the following input sequences
    are equivalent:

    [5, 3, (1, 3), 7]
    [5, 3, 1, 1, 1, 7]

    An integer in the output sequence means that the program is
    expected to output that integer. An Ellipsis ("...") means that
    the program is expected to output something, but no particular
    integer is required. A tuple (x, y) or (..., y) has the same
    meaning as in the input sequence: y is a repeat count. For
    example, here is how you can test a program that is supposed to
    count down from the number the user specifies, stopping at zero:

    [100], [100, 99, 98, 97, 96, 95, (..., 90), 4, 3, 2, 1, 0]

    The program will pass the test if it consumes all of the input
    sequence and produces all of the output sequence. It will fail the
    test if it does not consume all of the input sequence, or it
    invokes "read" after the input sequence is exhausted, or it does
    not produce all of the output sequence, or if it produces output
    after the output sequence has been exhausted.

    The special form (..., ...) is also allowed, but only as the last
    element of the output sequence. If it is provided, then the
    program is allowed to produce any amount of output after it
    produces everything in the output sequence (in this case, the
    program passes the test immediately once it produces all the
    expected output). (Note that this means the program is *not*
    required to consume all of the input, although it will still fail
    the test if it fails any of the other conditions delineated in the
    previous paragraph. Determining whether a non-terminating program
    will eventually consume all of the provided input is equivalent to
    the halting problem.) This allows the testing of programs that do
    not terminate. For instance, here is how you can test a program
    that is supposed to count upwards from the number the user
    specifies:

    [5], [5, 6, 7, 8, 9, 10, (..., ...)]

    Returns a tuple of two elements. The first is a tuple of a similar
    form to the one contained in the string passed to this function,
    except that it does not contain any elements with repeat counts
    (i.e. all members of the input and output sequences are integers
    or Ellipses, not tuples), and in addition the (..., ...) special
    form is removed, if present. The second element is a boolean value
    specifying whether the test case is exhaustive (i.e. the program
    is not allowed to produce more input after the output sequence is
    exhausted, or in other words the (..., ...) special form was not
    present).

    If the string is malformed, raises a CouldNotRunHmmmTestsError.
    """
    string = string.strip()
    if re.match(r"\s*#", string):
        return None
    result = parse_test_case_(string)
    if isinstance(result, str):
        raise CouldNotRunHmmmTestsError(result)
    return result


def format_test_case(test_case):
    """Formats a test case (as returned by the parse_test_case function)
    in a human-readable manner.

    Currently not very much information is available from the returned
    string, but that could be changed in the future (which is why this
    function exists).
    """
    return ", ".join(str(input_) for input_ in test_case[0][0])


def get_hmmm_program(command_prefix, test_file, time_limit):
    """Attempts to find the HMMM program that should be tested by the
    test_file, according to a number of heuristics.

    Returns the text of the program, or throws a
    CouldNotRunHmmmTestsError if an appropriate program could not be
    found.
    """
    # To start, we determine the directory and filename of the test
    # file, and get the list of files in that directory.
    test_directory, test_filename = os.path.split(test_file)
    # If the test_file is specified as just a filename, then its
    # directory is the current directory.
    if not test_directory:
        test_directory = "."
    # Get the names of all the files in the same directory as the test
    # file.
    filenames = os.listdir(test_directory)
    # First we look for .hmmm files.
    hmmm_filenames = []
    for file_ in filenames:
        if file_.endswith(".hmmm"):
            hmmm_filenames.append(file_)
    # If there's only one .hmmm file, we have found our candidate.
    if len(hmmm_filenames) == 1:
        with open(hmmm_filenames[0]) as f:
            return f.read()
    # Except in the special case of there only being one .hmmm file,
    # we're going to need to know the name of the HMMM program to be
    # tested. The only way to determine this is to strip the extension
    # from the test file (presuming, of course, that it has one!).
    try:
        extension_index = test_filename.rindex(".")
    except ValueError:
        error = ("Test file '{}' does not have an extension"
                 .format(test_filename))
        raise CouldNotRunHmmmTestsError(error)
    program_name = test_filename[:extension_index]
    # Presuming that there are any .hmmm files, we'll try to guess the
    # file by swapping out the extension on the test file.
    if hmmm_filenames:
        hmmm_filename = program_name + ".hmmm"
        if hmmm_filename in hmmm_filenames:
            with open(hmmm_filename) as f:
                return f.read()
        else:
            error = ("Test file '{}' does not match any of the available"
                     " .hmmm files, which are: {}"
                     .format(test_filename,
                             ", ".join("'{}'".format(file_)
                                       for file_ in hmmm_filenames)))
            raise CouldNotRunHmmmTestsError(error)
    # If there aren't any .hmmm files, we'll check any available .py
    # files next.
    py_filenames = []
    for filename in filenames:
        file_ = os.path.join(test_directory, filename)
        if not filename.endswith(".py"):
            continue
        # To filter out irrelevant .py files (possibly autograder
        # code), we check to make sure the ones we find define a
        # "Hmmm" function, which seems to be the template used in CS5
        # classes (whereas CS42 classes just create .hmmm files, thus
        # obviating the problem of distinguishing between different
        # types of .py files).
        with open(file_) as f:
            # Split the string literal so that the check doesn't match
            # this file (hmmmgrader.py)!
            if "def " "Hmmm" not in f.read():
                continue
        py_filenames.append(filename)
    if not py_filenames:
        error = ("no .hmmm or .py files with HMMM programs available")
        raise CouldNotRunHmmmTestsError(error)
    # We define a function to run using "python3 -c" that will print a
    # dictionary containing all the multiline strings defined in a
    # module.
    extraction_command = r"""\
import {0}
programs = {{}} # needed to escape the braces from str.format
for name in dir({0}):
    # Ignore items that are in all modules (including the __builtins__
    # module).
    if name not in dir(__builtins__):
        item = eval("{0}." + name)
        # Only accept multiline strings.
        if isinstance(item, str) and "\n" in item:
            programs[name] = item
print(repr(programs))\
"""
    # The time limit is split equally among each of the subprocess
    # calls, to ensure that we don't accidentally take longer than
    # allowed in total.
    timeout = time_limit and time_limit / len(py_filenames)
    # Now we extract all possible HMMM programs from all the valid .py
    # files that we found, and place them into a single dictionary
    # (allowing for multiple programs by the same name, and retaining
    # the information about which programs were found in which files).
    programs = {}
    # All the information about errors while opening files goes into
    # another dictionary, for possible error reporting.
    error_data = {}
    for file_ in py_filenames:
        # Trim the .py extension.
        module_name = file_[:-3]
        command = Command(command_prefix +
                          ["python3",
                           "-c",
                           extraction_command.format(module_name)])
        result = command.run(compatibility=False,
                             cwd=test_directory,
                             timeout=timeout)
        return_code, stdout, stderr, timeout = result
        if return_code == 0:
            new_programs = eval(stdout)
            for name, program in new_programs.items():
                if name not in programs:
                    programs[name] = []
                programs[name].append((file_, program))
        else:
            error_data[file_] = result
    # Now we look at the collected programs and see if we can uniquely
    # identify one that matches the desired program. Collecting lists
    # of all the names of programs and all the files that were
    # investigated allows for more useful error reporting.
    all_names = set()
    all_files = set()
    for name, candidates in programs.items():
        all_names.add(name)
        for candidate in candidates:
            all_files.add(candidates[0])
    # If only one program is defined, then we'll choose it regardless
    # of whether its name matches the test file.
    if len(all_names) == 1:
        program_name = next(iter(all_names))
    if program_name in programs:
        # Keep in mind that a program by the same name might be
        # defined in multiple .py files, so we need to check for that.
        candidates = programs[program_name]
        if len(candidates) == 1:
            return candidates[0][1]
        error = ("program '{}' was defined in multiple files ({})"
                 .format(program_name,
                         ", ".join("'{}'".format(pair[0])
                                   for pair in candidates)))
        raise CouldNotRunHmmmTestsError(error)
    # If we have more than one program defined, and none of them
    # matches the test file name (which defines the initial value of
    # program_name), then we have an error. We report it with as much
    # diagnostic information as possible.
    error = ("test file '{}' does not match any of the available HMMM programs"
             .format(test_filename))
    if all_names:
        error += (" (programs {} defined in files {})"
                  .format(", ".join("'{}'".format(name)
                                    for name in all_names),
                          ", ".join("'{}'".format(file_)
                                    for file_ in all_files)))
    if len(all_files) < len(py_filenames):
        error += (" (could not open files {})"
                  .format(", ".join("'{}'".format(file_)
                                    for file_ in (set(py_filenames) -
                                                  all_files))))
    if error_data:
        error += ("; errors (returncode, stdout, stderr, timeout)"
                  " while opening files: {}"
                  .format(repr(error_data)))
    raise CouldNotRunHmmmTestsError(error)


# API functions


def testFileParser(filename):
    """Parses the provided test file, returning a list of test names.

    See the user manual for more information about this API function.
    """
    with open(filename) as f:
        lines = f.read().splitlines()
        test_names = set()  # discard duplicate test cases
        for line in lines:
            test_case = parse_test_case(line)
            if test_case:
                test_names.add(format_test_case(test_case))
        return list(test_names)


def run_tests(command_prefix, test_file, time_limit):
    """Wrapper for "runTests" that adheres to PEP8 variable naming
    conventions.
    """
    try:
        with open(test_file) as f:
            # Split the time limit 1-1-2 among finding the HMMM
            # program, assembling it, and running the test cases.
            get_hmmm_timeout = time_limit and time_limit / 4
            assembly_timeout = time_limit and time_limit / 4
            total_test_timeout = time_limit and time_limit / 2
            # Get the text of the HMMM program (if a unique match can
            # be found).
            program = get_hmmm_program(command_prefix,
                                       test_file,
                                       get_hmmm_timeout)
            # Get the paths to the assembler and simulator. We have to
            # shell out here because they are written in Python 3!
            script_directory = os.path.split(__file__)[0]
            hmmmAssembler = os.path.join(script_directory, "hmmmAssembler.py")
            hmmmSimulator = os.path.join(script_directory, "hmmmSimulator.py")
            # Get the path to the test file folder.
            test_directory, test_filename = os.path.split(test_file)
            # If the test file is specified only as a filename, then
            # the test_directory is the current directory.
            if not test_directory:
                test_directory = "."
            # Run the assembler.
            command = Command(command_prefix +
                              ["python3",
                               hmmmAssembler,
                               "--program-text",
                               program])
            result = command.run(compatibility=False,
                                 cwd=test_directory,
                                 timeout=assembly_timeout)
            return_code, stdout, stderr, timeout = result
            if return_code != 0:
                error = ("Assembly completed unsuccessfully{}"
                         .format(" (timed out)" if timeout else ""))
                info = []
                if stdout.strip():
                    info.append("Output:\n{}".format(stdout.strip()))
                if stderr.strip():
                    info.append("Error:\n{}".format(stderr.strip()))
                if info:
                    error += "\n"
                    error += "\n".join(info)
                raise CouldNotRunHmmmTestsError(error)
            # Parse the test cases from the test file.
            test_cases = {}  # discard duplicate test cases
            for line in f:
                test_case = parse_test_case(line)
                if test_case:
                    test_cases[format_test_case(test_case)] = test_case
            # Run the test cases using the simulator, collecting
            # stdout and stderr.
            failed_tests = {}
            all_stdout = ""
            all_stderr = ""
            timeout = total_test_timeout / len(test_cases)
            for name, test_case in test_cases.items():
                command = Command(command_prefix +
                                  ["python3",
                                   hmmmSimulator,
                                   "--test-case",
                                   repr(test_case)])
                result = command.run(compatibility=False,
                                     cwd=test_directory,
                                     timeout=timeout)
                return_code, stdout, stderr, timed_out = result
                all_stdout += stdout
                all_stderr += stderr
                # Messages designed to be read by hmmmgrader.py are
                # delimited by double brackets [[ like this ]].
                outputs = re.findall(r"\[\[ (.+?) \]\]", stdout)
                if "test case passed" in outputs:
                    continue
                found_failure = False
                for output in outputs:
                    match = re.match(r"test case failed: (.+)", output)
                    if match:
                        error = match.group(1)
                        # Capitalize the error message.
                        error = error[:1].upper() + error[1:]
                        failed_tests[name] = {"hint": error}
                        found_failure = True
                        break
                if found_failure:
                    continue
                error = ("simulation completed unsuccessfully{}"
                         .format(" (timed out)" if timed_out else ""))
                info = []
                if stdout.strip():
                    info.append("Output:\n{}".format(stdout.strip()))
                if stderr.strip():
                    info.append("Error:\n{}".format(stderr.strip()))
                if info:
                    error += "\n"
                    error += "\n".join(info)
                failed_tests[name] = {"hint": error}
            summary = {"died": False,
                       "timeout": False,
                       "totalTests": len(test_cases),
                       "failedTests": len(failed_tests),
                       "rawOut": all_stdout,
                       "rawErr": all_stderr}
            return summary, failed_tests
    except Exception as e:
        if isinstance(e, CouldNotRunHmmmTestsError):
            # If the error is a CouldNotRunHmmmTestsError, then this
            # code generated the error message and included all
            # necessary information. So we can just return the
            # message.
            error = e.message
        else:
            # Otherwise, there was an unexpected error, and we'll
            # provide the whole stack trace for debugging purposes.
            # This is obviously very bad from a security perspective,
            # but worrying about it would be like making sure to turn
            # out the lights when the building is on fire, given the
            # security of the rest of this website.
            error = traceback.format_exc()
        summary = {"died": True,
                   "timeout": False,
                   "totalTests": 0,
                   "failedTests": 0,
                   "rawOut": "",
                   "rawErr": error}
        failedTests = {}
        return summary, failedTests


def runTests(cmdPrefix, testFile, timeLimit):
    """Runs the tests defined in testFile, returning a tuple of
    dictionaries.

    See the user manual for more information about this API function.
    """
    return run_tests(cmdPrefix, testFile, timeLimit)


if __name__ == "__main__":
    if len(sys.argv) >= 2:
        for filename in sys.argv[1:]:
            print(run_tests([], filename, 10))
    else:
        doctest.testmod()
