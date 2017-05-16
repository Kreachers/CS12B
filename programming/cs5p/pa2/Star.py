#------------------------------------------------------------------------------
#  Devin Siems
#  dsiems@ucsc.edu
#  star.py
#------------------------------------------------------------------------------

import turtle
wn = turtle.Screen() # Set up the window and its attributes

sides = input("Enter an odd integer greater than or equal to 3: ")
wn.title(sides + "-pointed star")

tess = turtle.Turtle() # Create tess and set some attributes
tess.color('blue', 'green3')
tess.begin_fill()
tess.pensize(2)
tess.penup()
tess.goto(-150,0)
tess.pendown()
tess.speed(0)

for x in range(0,(int)(sides)):
   tess.forward(300)
   tess.right(180.0-(180.0/(float)(sides)))
   tess.dot(10, 'red')

tess.end_fill()
tess.hideturtle()

wn.mainloop()
