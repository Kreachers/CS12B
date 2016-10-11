"""
20150209 - Created by stillborn86 (c)
This sketch is designed to calculate the
surface area of any polygon after prompting
the user for information about the
sides/corners of the polygon
"""

import os
import math

def con_2_deg(angle):
    return angle * 180 / math.pi
def con_2_rad(angle):
    return angle * math.pi / 180

os.system('clear')

n = input('How many sides/corners does the polygon have?: ')
print ' '

if n < 3:
    print 'YOU ARE A LIAR!!!'
    raise SystemExit

print 'Are you measuring the radius from the center to the'
print '1: corners'
print '2: middle of one of the sides'
y = input('?: ')
print ' '

if (y != 1 and y != 2):
    print 'Your selection is bad and you should feel bad!'
    raise SystemExit

if y == 1:
    R = input('What is the distance from the center of the polygon to one of the corners?: ')
    a = 0.5 * n * (R**2) * math.sin(2 * math.pi / n)

if y ==2:
    r = input('What is the distance from the center of the polygon to the center of one of the sides?: ')
    a = n * r**2 * math.tan(math.pi / n)

print ' '
print 'The area of this',n,'sided polygon is:',a,'square units.'

