#
# Markov generation grading script
#


from hw10pr3 import *


# test 1 - dictionary for abc.txt
d = createDictionary( 'abc.txt' )
d_abc = d
correctd = { 'A': ['B', 'B', 'C.'], 'C': ['C', 'C.'], 
  'B': ['A.', 'C.', 'A'], '$': ['A', 'A', 'B', 'C'] }
print 'solution d for abc.txt is', correctd
print 'student\'s d for abc.txt is', d
print
if d == correctd:
  print '\ncorrect for abc - d was the right dictionary\n'
  print
else:
  print '\n** INCORRECT ** for abc - d for abc.txt was incorrect\n'
  print



# test 2 - dictionary for poptarts.txt
d = createDictionary( 'poptarts.txt' )
d_pop = d
list_for_and = ['42', 'spam.', 'poptarts']
list_for_dollar = ['I', 'Will', 'I']
print 'd[and] from solution is', list_for_and
print 'd[and] for poptarts.txt is', d['and']
print
if sorted(list_for_and) == sorted(d['and']):
  print '\ncorrect for poptarts - d had the right list for and'
  print
else:
  print '\n** INCORRECT ** for poptarts - d[and] was incorrect'
  print



# test 3 - dictionary for poptarts.txt
d = createDictionary( 'poptarts.txt' )
d_pop = d
list_for_and = ['42', 'spam.', 'poptarts']
list_for_dollar = ['I', 'Will', 'I']
print 'd[$] from solution is', list_for_dollar
print 'd[$] for poptarts.txt is', d['$']
print
if sorted(list_for_dollar) == sorted(d['$']):
  print '\ncorrect for poptarts - d had the right list for dollar'
  print
else:
  print '\n** INCORRECT ** for poptarts - d[$] was incorrect'
  print



print
# test 4 - bunch of abc-generated text
print "100 abc.txt - generated words:"
result = generateText( d_abc, 100 )
if result != None:
  print result

print
print
print
print




# test 5 - bunch of poptarts-generated text
print "100 poptarts.txt - generated words:"
result = generateText( d_pop, 100 )
if result != None:
  print result

print
print
print
print
print
print




