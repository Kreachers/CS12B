"""
20160518 - Created by stillborn86 (c)

This simple sketch is designed to swap a boolean value of TRUE/FALSE when an
input is given, then output that changed boolean value.
"""

# Set initial variable boolean value
x = False

try:
    while True:
        input("Press any key to continue...")
        x ^= 1
        print(x)

except KeyboardInterrupt:
    print("\nA keyboard interrupt has been detected!")

except:
    print("\nAn error or exception has occurred!")

#finally:
