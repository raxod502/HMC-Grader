#!/usr/bin/env python3

import sys, string, re
import importlib
from binary import *
from functools import reduce

memory = [0]*256        # 256 words of memory.  Instructions are represented
                        # ..in string form; data is integer
register = [0]*16       # 16 integer registers
pc = 0                  # program counter initialized to 0
debug = 0               # debug mode?
ask = 1                 # for fast debug mode
lpc = 0                 # where the program counter was 1 instruction ago
codesize = 0            # can't execute past this or read/write before this
next = 1                # display next instruction?
register_display = 0    # display the registers graphically?
memory_display = 0      # display the memory contents graphically?

## Automated running of test cases

test_case = None
test_case_is_exhaustive = None
input_index = 0
output_index = 0

## Exception classes

class HMMMTestFailure(Exception):
    """Exception thrown when a HMMM program fails a test case passed using
    the --test-case command-line parameter.
    """
    pass


class HMMMTestSuccess(Exception):
    """Exception thrown when it has been determined that a HMMM program
    has passed a test case and execution may be aborted immediately."""
    pass

# translation dictionaries

#
# opcodes encodes the preferred opcode translations.  Each entry is a
# triple: match, mask, translation.  If the binary word matches
# "match" under the mask, the translated opcode is given by that
# entry.  Blanks are ignored in the match and mask fields.  The table
# is order-dependent; the first match is used.  Note that at present
# the masks are either 0x0 or 0xF in each hex digit, although the code
# doesn't enforce that restriction.
#
# This table is shared directly between the assembler and simulator.
# The assembler doesn't use all the fields.
#
opcodes = (
        ("0000 0000 0000 0000", "1111 1111 1111 1111", "halt"),
        ("0000 0000 0000 0001", "1111 0000 1111 1111", "read"),
        ("0000 0000 0000 0010", "1111 0000 1111 1111", "write"),
        ("0000 0000 0000 0011", "1111 0000 1111 1111", "jumpi"),
        ("0001 0000 0000 0000", "1111 0000 0000 0000", "loadn"),
        ("0010 0000 0000 0000", "1111 0000 0000 0000", "load"),
        ("0011 0000 0000 0000", "1111 0000 0000 0000", "store"),
        ("0100 0000 0000 0000", "1111 0000 0000 1111", "loadi"),
        ("0100 0000 0000 0001", "1111 0000 0000 1111", "storei"),
        ("0101 0000 0000 0000", "1111 0000 0000 0000", "addn"),
        ("0110 0000 0000 0000", "1111 1111 1111 1111", "nop"),
        ("0110 0000 0000 0000", "1111 0000 0000 1111", "mov"),
        ("0110 0000 0000 0000", "1111 0000 0000 0000", "add"),
        ("0111 0000 0000 0000", "1111 0000 1111 0000", "neg"),
        ("0111 0000 0000 0000", "1111 0000 0000 0000", "sub"),
        ("1000 0000 0000 0000", "1111 0000 0000 0000", "mul"),
        ("1001 0000 0000 0000", "1111 0000 0000 0000", "div"),
        ("1010 0000 0000 0000", "1111 0000 0000 0000", "mod"),
        ("1011 0000 0000 0000", "1111 1111 0000 0000", "jump"),
        ("1011 0000 0000 0000", "1111 0000 0000 0000", "call"),
        ("1100 0000 0000 0000", "1111 0000 0000 0000", "jeqz"),
        ("1101 0000 0000 0000", "1111 0000 0000 0000", "jnez"),
        ("1110 0000 0000 0000", "1111 0000 0000 0000", "jgtz"),
        ("1111 0000 0000 0000", "1111 0000 0000 0000", "jltz"),
        ("0000 0000 0000 0000", "0000 0000 0000 0000", "data"),
        )

#
# arguments encodes the required arguments for each operation.  "r"
# means a register; "s" means a signed 8-bit number in decimal; "u"
# means an unsigned 8-bit number in decimal, and "n" means a signed or
# unsigned 16-bit number in hex (0x notation) or decimal.  Actually,
# all numbers are accepted in all bases.
#
# In addition, "z" means insert four bits of zeros without swallowing
# an argument; however, this works only at the beginning of an
# argument specifier.
#
# This table is taken directly from hmmmAssembler.py.
#
arguments = {"halt": "",
        "read": "r",
        "write": "r",
        "jumpi": "r",
        "loadn": "rs",
        "load": "ru",
        "store": "ru",
        "loadi": "rr",
        "storei": "rr",
        "addn": "rs",
        "add": "rrr",
        "mov": "rr",
        "nop": "",
        "sub": "rrr",
        "neg": "rzr",
        "mul": "rrr",
        "div": "rrr",
        "mod": "rrr",
        "jump": "zu",
        "call": "ru",
        "jeqz": "ru",
        "jgtz": "ru",
        "jltz": "ru",
        "jnez": "ru",
        "data": "n"}

def valid_integer(x):
    if type(x) == int:
        return -32768 <= x <= 32767
    else:
        return False

def disassemble(line):
    """Disassemble a binary line, returning a @h-element tuple.
The first tuple element is a string giving the assembly code, the second is
the mnemonic opcode alone, and the third is a list of arguments, if any,
in binary encoding."""
    if type(line) != type(''):
        return ('***UNTRANSLATABLE INSTRUCTION!***', '***UNTRANSLATABLE***', \
          [])
    hex = BinaryToNum(reduce(lambda x, y: x + y, line.strip().split(' ')))
    for tuple in opcodes:
        proto = BinaryToNum(reduce(lambda x, y: x + y, tuple[0].split(' ')))
        mask = BinaryToNum(reduce(lambda x, y: x + y, tuple[1].split(' ')))
        if hex & mask == proto:
            # We have found the proper instruction.  Decode the arguments.
            opcode = tuple[2]
            translation = opcode
            hex <<= 4
            args = []
            separator = ' '
            for arg in arguments[opcode]:
                # r s u n z
                if arg == 'r':
                    val = (hex & 0xf000) >> 12
                    translation += separator + 'r' + str(val)
                    separator = ', '
                    hex <<= 4
                    args += [val]
                elif arg == 'z':
                    hex <<= 4
                elif arg == 's'  or  arg == 'u':
                    val = (hex & 0xff00) >> 8
                    if arg == 's'  and  (val & 0x80) != 0:
                        val -= 256
                    translation += separator + str(val)
                    separator = ', '
                    hex <<= 8
                    args += [val]
                elif arg == 'u':
                    val = (hex & 0xff00) >> 8
                    translation += separator + str(val)
                    separator = ', '
                    hex <<= 8
                    args += [val]
                elif arg == 'n':
                    # In the absence of other information, always unsigned
                    val = hex & 0xffff
                    translation += separator + str(val)
                    separator = ', '
                    hex <<= 16
                    args += [val]
            return (translation, opcode, args)
    return ('***UNTRANSLATABLE INSTRUCTION!***', '***UNTRANSLATABLE***', [])

def simulationError(message):
    """Issue an error message and halt program execution."""
    print("\n\n" + message)
    print("Halting program execution.")
    sys.exit(1)

def run() :
    global pc,  memory, loop_check, lpc, codesize
    while pc != -1:         # fetch/execute cycle
        if pc not in list(range(codesize)) :
            simulationError("Memory Out of Bounds Error.\n"
              + "Program attempted to execute memory location " + str(pc))
        ir = memory[pc]         # Fetch and store into instruction register
        lpc = pc
        pc = pc+1           # increment pc
        try :
            execute(ir)         # execute instruction
        except KeyboardInterrupt :
            print("\n\nInterrupted by user, halting program execution...\n")
            sys.exit(1)
        except EOFError :
            print("\n\nEnd of input, halting program execution...\n")
            sys.exit(1)

def checkOverflow(register, ir, lpc):

    if not valid_integer(register):
        parts = ir.split()
        (translation, opcode, args) = disassemble(memory[lpc])
        print("\n  Program Counter:", lpc)
        print("  Instruction:", opcode, "  Arguments:", ", ".join(parts[1:]))
        print("  Translation:", translation, end=' ')
        simulationError("Integer Overflow Error: Result was larger than 16 bits.\n")

def execute(ir) :
    global memory, register, pc, debug, ask, lpc, input_index, output_index

    if ir == "" or valid_integer(ir):
        simulationError("Bad instruction at memory location " + lpc)

    parts = ir.split()      # parse instruction

    # This is the debug mode menu
    if debug :
        if ask :
            loop = 1
            while loop :
                command = input("\nDebugging Mode Command (h for help): ")
                if command == "c" or command == "continue" :
                    ask = 0
                    loop = 0
                elif command == "d" or command == "dump" :
                    print("Memory Contents:")
                    for i in range(codesize) :
                        print(str(i).ljust(3) + ":" + str(memory[i][:-1]).ljust(23))
                    c_len = (len(memory) - codesize) // 6
                    if (len(memory) - codesize) % 6 != 0 :
                        c_len += 1
                    for i in range(c_len) :
                        try :
                            print(str(i+codesize).ljust(3) + ": " + str(memory[i+codesize]).ljust(7), end=' ')
                            print(str(i+codesize+c_len).ljust(3) + ": " + str(memory[i+codesize+c_len]).ljust(7), end=' ')
                            print(str(i+codesize+2*c_len).ljust(3) + ": " + str(memory[i+codesize+2*c_len]).ljust(7), end=' ')
                            print(str(i+codesize+3*c_len).ljust(3) + ": " + str(memory[i+codesize+3*c_len]).ljust(7), end=' ')
                            print(str(i+codesize+4*c_len).ljust(3) + ": " + str(memory[i+codesize+4*c_len]).ljust(7), end=' ')
                            print(str(i+codesize+5*c_len).ljust(3) + ": " + str(memory[i+codesize+5*c_len]).ljust(7), end=' ')
                        except IndexError:
                            pass
                        print("")
                elif command == "h" or command == "help" :
                    print("\nDebugging Mode Commands:")
                    print("  'c' or 'continue' : run through the rest of the program (in debugging mode)")
                    print("  'd' or 'dump' : print the non-empty portions of memory")
                    print("  'h' or 'help' : display this message")
                    print("  'p' or 'print' : print the contents of the registers")
                    print("  'q' or 'quit' : halt the program and exit")
                    print("  'r' or 'run' : run through the rest of the program (exit debugging mode)")
                    print("  default : execute the next instruction")
                elif command == "p" or command == "print" :
                    print("Registers:")
                    for i in range(len(register)) :
                        print(str(i).ljust(2), ":", register[i])
                    print("")
                elif command == "q" or command == "quit" :
                    print("Aborting Program...")
                    sys.exit(1)
                elif command == "r" or command == "run" :
                    print("Continuing program...")
                    debug = 0
                    loop = 0
                else:
                    loop = 0
        # end of "if ask"

    (translation, opcode, args) = disassemble(memory[lpc])

    if debug :  # this is necessary because of the 'run' command
        print("\n  Program Counter:", lpc)
        print("  Instruction:", opcode, "  Arguments:", ", ".join(parts[1:]))
        print("  Translation:", translation)
        if next :
            print("  Next Target:", pc)
            print("  Next Instruction:", disassemble(memory[pc])[0], "\n")

    # Register 0 is always forced to zero
    register[0] = 0

    if opcode == "halt":
        pc = -1                 # This terminates the run loop
        if debug :
            print("halt\n")

    elif opcode == "read":
        try:
            sys.stdin.flush()
            sys.stdout.flush()
            sys.stderr.flush()
        except:
            # If those can't be flushed, no problem... .
            # I think those lines help in IDLE, but
            # break the code at the terminal, so perhaps
            # this try/except approach will make it work
            # in both situations!
            pass

        if test_case:
            try:
                # Get the next input.
                inputs = test_case[0]
                UserInput = inputs[input_index]
                input_index += 1
            except IndexError:
                error = "program called 'read' after input was exhausted"
                raise HMMMTestFailure(error)
            print("read {}".format(UserInput))
        else:
            UserInput = input("Enter number: ")
            while UserInput == "" \
              or  (not (UserInput.isdigit() \
                or (UserInput[0] == '-' and UserInput[1:].isdigit()))) \
              or not valid_integer(int(UserInput)):
                print("\n\nIllegal input: number must be in [-32768,32767]")
                UserInput = input("Enter number (q to quit): ")
                if UserInput == "q" :
                    sys.exit(1)
            UserInput = int(UserInput)
        register[args[0]] = UserInput

    elif opcode == "write":
        output = register[args[0]]
        print(output)
        if test_case:
            try:
                # Check the next output.
                outputs = test_case[1]
                if outputs[output_index] not in (output, Ellipsis):
                    error = ("program output '{}' when '{}' was expected"
                             .format(output, outputs[output_index]))
                    raise HMMMTestFailure(error)
                output_index += 1
            except IndexError:
                error = ("program output '{}' when no more output was expected"
                         .format(output))
                raise HMMMTestFailure(error)
            if output_index == len(outputs) and not test_case_is_exhaustive:
                # If we've reached the end of the expected output, and
                # any amount of additional output would be allowable
                # (i.e. not test_case_is_exhaustive) then everything
                # is OK.
                raise HMMMTestSuccess

    elif opcode == "jumpi":
        pc = register[args[0]]
        if pc not in list(range(codesize)):
            simulationError("Invalid jump target at pc " + str(lpc) \
              + ": " + str(pc))

    elif opcode == "loadn":
        register[args[0]] = args[1]

    elif opcode == "load":
        if args[1] not in list(range(codesize, 256)) :
            simulationError("Invalid load target at pc " + str(lpc) \
              + ": " + str(args[1]))
        register[args[0]] = memory[args[1]]

    elif opcode == "store":
        if args[1] not in list(range(codesize, 256)) :
            print(str(args[1]))
            simulationError("Invalid store target at pc " + str(lpc) \
              + ": " + str(args[1]))
        memory[args[1]] = register[args[0]]

    elif opcode == "loadi":
        if register[args[1]] not in list(range(codesize, 256)) :
            simulationError("Invalid load target at pc " + str(lpc) \
              + ": " + str(register[args[1]]))
        register[args[0]] = memory[register[args[1]]]

    elif opcode == "storei":
        if register[args[1]] not in list(range(codesize, 256)) :
            simulationError("Invalid store target at pc " + str(lpc) \
              + ": " + str(register[args[1]]))
        memory[register[args[1]]] = register[args[0]]

    elif opcode == "addn":
        register[args[0]] += args[1]
        checkOverflow(register[args[0]], ir, lpc)

    elif opcode == "add"  or  opcode == "mov"  or  opcode == "nop":
        if opcode == "nop":
            args = [0, 0, 0]
        elif opcode == "mov":
            args += [0]
        register[args[0]] = register[args[1]] + register[args[2]]
        checkOverflow(register[args[0]], ir, lpc)

    elif opcode == "sub"  or  opcode == "neg":
        if opcode == "neg":
            args = [args[0], 0, args[1]]
        register[args[0]] = register[args[1]] - register[args[2]]
        checkOverflow(register[args[0]], ir, lpc)

    elif opcode == "mul":
        register[args[0]] = register[args[1]] * register[args[2]]
        checkOverflow(register[args[0]], ir, lpc)

    elif opcode == "div":
        try:
            register[args[0]] = register[args[1]] // register[args[2]]
        except ZeroDivisionError :
            simulationError("Division by Zero Error at pc " + str(lpc) + ".")

    elif opcode == "mod":
        try:
            register[args[0]] = register[args[1]] % register[args[2]]
        except ZeroDivisionError :
            simulationError("Division by Zero Error at pc " + str(lpc) + ".")

    elif opcode == "jump"  or  opcode == "call":
        if opcode == "jump":
            args = [0] + args
        register[args[0]] = pc
        pc = args[1]
        if pc not in list(range(codesize)):
            simulationError("Invalid jump/call target at pc " + str(lpc) \
              + ": " + str(pc))

    elif opcode == "jeqz":
        if register[args[0]] == 0:
            pc = args[1]
        if pc not in list(range(codesize)):
            simulationError("Invalid jump target at pc " + str(lpc) \
              + ": " + str(pc))

    elif opcode == "jltz":
        if register[args[0]] < 0:
            pc = args[1]
        if pc not in list(range(codesize)):
            simulationError("Invalid jump target at pc " + str(lpc) \
              + ": " + str(pc))

    elif opcode == "jgtz":
        if register[args[0]] > 0:
            pc = args[1]
        if pc not in list(range(codesize)):
            simulationError("Invalid jump target at pc " + str(lpc) \
              + ": " + str(pc))

    elif opcode == "jnez":
        if register[args[0]] != 0:
            pc = args[1]
        if pc not in list(range(codesize)):
            simulationError("Invalid jump target at pc " + str(lpc) \
              + ": " + str(pc))

    else:
        simulationError("Invalid operation code at pc " + str(pc))

    # Re-force register 0 to zero so register dumps will be correct.
    register[0] = 0

def readfile(filename) :
    global memory, codesize
    try:
        f = open(filename,"r")    # file with machine code
    except:
        print("Cannot open file: ", filename)
        sys.exit(1)
    address = 0
    codesize = 0
    while 1 :
        line = f.readline()
        for c in line:
            if c not in "01 \n":
                print("\nERROR: Not a valid binary file.\n")
                sys.exit(1)
        if line == "": break
        memory[address] = line
        address = address + 1
        codesize = codesize + 1
    if codesize == 0:
        print("\nERROR: Empty file.\n")
        sys.exit(1)
    f.close()


def main ( argList=None ) :
    global debug, register_display, memory_display, visualize, \
        test_case, test_case_is_exhaustive

    # argument handling:
    fname = 0
    filename = "out.b"
    accepting_test_case = False
    if not argList:
        argList = []

    for arg in argList :
        if fname :
            filename = arg
            fname = 0
            continue
        elif accepting_test_case:
            if test_case:
                print("hmmmSimulator: more than one test case specified")
                sys.exit(1)
            test_case, test_case_is_exhaustive = eval(arg)
            if not test_case[1] and not test_case_is_exhaustive:
                # Vacuous test case: no expected output; because the
                # test case is not exhaustive, nothing that the
                # program could print could fail the test case; and
                # determining whether the input is consumed is
                # equivalent to the halting problem for a possibly
                # non-terminating program (which is what is generally
                # indicated by a non-exhaustive test). We can't do
                # anything useful, so just pass the test.
                print("Warning: vacuous test case.")
                print("[[ test case passed ]]")
                sys.exit(0)
            accepting_test_case = False
        elif arg == "--test-case"
            accepting_test_case = True
            debug = 2
        elif arg[:2] == "-f" :
            if arg[2:] :
                    filename = arg[2:]
            else: fname = 1
        elif arg == "-d" or arg == "--debug" :
            debug = 1
        elif arg == "-m" or arg == "-mr" or arg == "-rm" or arg == "--memory-display" :
            memory_display = 1
        elif arg == "-n" or arg == "--no-debug" :
            debug = 2
        elif arg == "-r" or arg == "-mr" or arg == "-rm" or arg == "--register-display" :
            register_display = 1
        else:
            if arg not in ("-h", "--help"):
                print("error: unrecognized argument: {}" .format(arg))
            print("hmmmSimulator.py")
            print("  Python program for simulating a Harvey Mudd Miniature Machine.")
            print("Takes files compiled with hmmAssembler.py as input.")
            print("  Options:")
            print("    -d, --debug               debugging mode")
            print("    -f filename               use filename as the input file")
            print("    -h, --help                print this help message")
            print("    -n, --no-debug            do not prompt for debugging mode\n")
            print("    --test-case <test-case>   run the provided test case")
            print("  Warning: --test-case is *not* validated, use hmmmgrader.py for validation")
            if arg in ("-h", "--help"):
                sys.exit(0)
            else:
                sys.exit(1)

    if filename == "" :
        filename = input("Enter binary input file name: ")

    readfile(filename)
    # to read from stdin instead we would use:  program = sys.stdin.readlines()
    if debug == 0:
        yn = input("Enter debugging mode? ")
        if re.findall(r'(^y[es]*)|(^indeed)|^t$|(^true)|(^affirmative)', yn) :
            debug = 1


    if debug == 2: debug = 0

    if memory_display or register_display :
        import visualize
    if memory_display :
        visualize.mem_setup()
    if register_display :
        visualize.reg_setup()

    try :
        run()
        inputs, outputs = test_case
        if input_index < len(inputs):
            remaining = inputs[input_index:]
            if len(remaining) > 1:
                error = ("inputs {} were not consumed by the program"
                         .format(remaining))
            else:
                error = ("input '{}' was not consumed by the program"
                         .format(remaining[0]))
            raise HMMMTestFailure(error)
        if output_index < len(outputs):
            remaining = outputs[output_index:]
            all_ellipses = True
            for output in remaining:
                if output is not Ellipsis:
                    all_ellipses = False
                    break
            if len(remaining) > 1:
                if all_ellipses:
                    error = ("expected at least {} more outputs from the program"
                             .format(len(remaining)))
                else:
                    error = ("expected outputs {} were not produced by the"
                             " program"
                             .format(remaining))
            else:
                if all_ellipses:
                    error = "expected at least one more output from the program"
                else:
                    error = ("expected output '{}' was not produced by the"
                             " program"
                             .format(remaining[0]))
            raise HMMMTestFailure(error)
    except KeyboardInterrupt :
        print("\n\nInterrupted by user, halting program execution...\n")
        sys.exit(1)
    except EOFError :
        print("\n\nEnd of input, halting program execution...\n")
        sys.exit(1)
    except HMMMTestFailure as e:
        print("[[ test case failed: {} ]]".format(str(e)))
        sys.exit(1)
    except HMMMTestSuccess:
        pass
    print("[[ test case passed ]]")
    sys.exit(0)

# When this module is executed from the command line, as in "python filename.py"
# __name__ will be __main__, so main () will be executed.
# However, when this module is imported into the python environment __name__ will
# be something else, so main() will not be executed automatically
if __name__ == "__main__" : main(sys.argv[1:])
