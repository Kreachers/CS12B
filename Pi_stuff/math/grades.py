"""This sketch prompts the user
for numerical grades until the
user decides to stop.  At that
point, the sketch will convert
the numerical grades into letter
grades, then output the number
of each letter grade"""

stop = ' '
l_grades = [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ]

while (stop != 'stop'):
    grades = input('Enter grade -- type "stop" to end : ')
    if (grades == 'stop'):
        stop = 'stop'
    if (grades >= 93 and grades != 'stop'):
        print 'A'
        l_grades[0] += 1
    if (grades >= 90 and grades < 93):
        print 'A-'
        l_grades[1] += 1
    if (grades >= 87 and grades < 90):
        print 'B+'
        l_grades[2] += 1
    if (grades >= 83 and grades < 87):
        print 'B'
        l_grades[3] += 1
    if (grades >= 80 and grades < 83):
        print 'B-'
        l_grades[4] += 1
    if (grades >= 77 and grades < 80):
        print 'C+'
        l_grades[5] += 1
    if (grades >= 73 and grades < 77):
        print 'C'
        l_grades[6] += 1
    if (grades >= 70 and grades < 73):
        print 'C-'
        l_grades[7] += 1
    if (grades >= 67 and grades < 70):
        print 'D+'
        l_grades[8] += 1
    if (grades >= 63 and grades < 67):
        print 'D'
        l_grades[9] += 1
    if (grades >= 60 and grades < 63):
        print 'D-'
        l_grades[10] += 1
    if (grades < 60):
        print 'F'
        l_grades[11] += 1

print 'A  =',l_grades[0]
print 'A- =',l_grades[1]
print 'B+ =',l_grades[2]
print 'B  =',l_grades[3]
print 'B- =',l_grades[4]
print 'C+ =',l_grades[5]
print 'C  =',l_grades[6]
print 'C- =',l_grades[7]
print 'D+ =',l_grades[8]
print 'D  =',l_grades[9]
print 'D- =',l_grades[10]
print 'F  =',l_grades[11]

