Taken from StillBorn86's github
https://bitbucket.org/stillborn86/python.git

# Python sketch compilation
This directory is full of my various Python sketches.  Most of these sketches
are designed to work on any system with Python installed, with the main
exception being the rPi folder which is designed to work with the Raspberry Pi
platform only.

These sketches are available for educational purposes only, and any damage
resulting from the use of any code found here is the sole responsibility of the
user.

These sketches are mostly kept up to date with the most recent version of
Python, but are not guaranteed to work with the most recent version.  Any
changes required to make each sketch work is the responsibility of the user.
This can be an excellent opportunity for the user to learn the varuous
differences between the working versions of Python.

## rPi folder
The rPi folder contains Python sketches designed to work with the Raspberry Pi
platform and its GPIO.  These sketches will not work on a standard computer
system, as imported modules will not exist on systems which do not contain rPi
GPIO.

## Math folder
The math folder is filled with small sketches designed to exercise mathematical
functions.  These are mostly practice sketches, designed familiarize the user
with the various math functions available through the user through Python. 

## Help folder
The help folder is filled with small sketch "bites" consisting of example code,
each doing different things.  These tiny sketches are examples of smaller code
demonstrating mathematical functions, tuples, and other esoteric bits for the
Python language.

## Tutorial folder
The tutorial folder is full of sketches that were either designed by others or
created with the help of others.  It was designed to be used as a helpful tool
for writing sketches in the future.

## Downloading

    cd ~/Temp/dev/
    git clone https://stillborn86@bitbucket.org/stillborn86/python.git
 
## Uploading

    git init
    git remote add origin https://stillborn86@bitbucket.org/stillborn86/python.git
    git add *
