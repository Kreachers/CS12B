#-------------------------------------------------------------
# Guess.py
# python game
# you have 3 chance to guess the random
# number between 1 and 10
#-------------------------------------------------------------
import sys
import random
guess = random.randint(1,10)
print("I'm thinking of an integer in the range 1 to 10. You have three guesses.")
#print(guess)
print()
input = input("Enter your frist guess: ")
input = int(input)
if input > guess:
    print("Your guess is too high.")
if input < guess:
    print("Your guess is too low.")
if input == guess:
    print("You win!")
    print()
    sys.exit(0)
del input
print()
input = input("Enter your second guess: ")
input = int(input)
if input > guess:
    print("Your guess is too high.")
if input < guess:
    print("Your guess is too low.")
if input == guess:
    print("You win!")
    print()
    sys.exit(0)
del input
print()
input = input("Enter your third guess: ")
input = int(input)
if input > guess:
    print("Your guess is too high.")
if input < guess:
    print("Your guess is too low.")
if input == guess:
    print("You win!")
    print()
    sys.exit(0)
if input != guess:
    print()
    print("You loose. the number was", guess)



