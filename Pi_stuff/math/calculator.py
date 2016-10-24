"""
20151122 - Created by stillborn86 (c)

A simple four-function calculator program written in
Python.

"""

import os

os.system('clear')

# Adding function
def add(a, b):
    ans = a + b
    print("\n",a, "+", b, "=", ans)
    return

# Subtracting function
def subtract(a, b):
    ans = a - b
    print("\n",a, "-", b, "=", ans)
    return

# Dividing function
def divide(a, b):
    ans = a / b
    print("\n",a, "/", b, "=", ans)
    return

# Multiplying function
def multiply(a, b):
    ans = a * b
    print("\n",a, "*", b, "=", ans)
    return

try:
    while True:

        # Prompt the user for two numbers to be manipulated
        a = int(input("\nX = "))
        b = int(input("Y = "))
        
        #Ask user which function they'd like to use
        print("\n1 = Add       (X + Y)\n2 = Subtract  (X - Y)\n3 = Multiply  (X * Y)\n4 = Divide    (X / Y)")
        x = int(input("\nChoice: "))

        # Utilize the correct function
        if (x == 1):
            add(a, b)
        elif (x == 2):
            subtract(a, b)
        elif (x == 3):
            multiply(a, b)
        elif (x == 4):
            divide(a, b)
        # Some people are stupid
        else:
            print("\nYour choice is bad and you should feel bad!")
        
# If a keyboard interrupt is used, tell the user and stop the sketch
except KeyboardInterrupt:
    print("\nA keyboard interrupt has been detecte!")

# If a problem exists, tell the user before exiting the sketch
except:
    print("\nAn error or exception has occurred!")

