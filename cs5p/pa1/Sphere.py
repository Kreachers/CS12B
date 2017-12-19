#Devin Siems
#dsiems@ucsc.edu
#Programming Assignment 1
#takes an inout of the radius of a shpere and then
#calculates volume and surface area of said shpere

import math
radius = float(input('Enter the radius or your circle: '))
print('The volume is: ', (4/3)*math.pi*radius**3)
print('The surface area is: ', 4*math.pi*radius**2)
