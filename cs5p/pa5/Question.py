#
# Devin Siems
# CMPS5P
# Tantolo
# Guess ing game. the computer trys to guess a number you think of
# it will asked for a range of number to guess in and then use 
# binary search to get responses from the user and find the number
#
print("Enter two number, low the high")
low = input("low = ")
high = input("high = ")
mid = (int(low) + int(high))//2
#print(mid)

while (low > high):
   print("")
   print("Please enter the smaller followed by the larger number")
   low = input("low = ")
   high = input("high = ")

print("")
print("Think of a number in the range of " + low + " and " + high)

answer = "null"
count = 0

while (1==1):
   print("")
   if (answer == str("E") or answer == str("e")):
      break
   if (answer == str("L") or answer == str("l")):
#      print("L")
      high = mid
      mid = (int(low) + int(high))//2
#      print(mid)

   if (answer == str("G") or answer == str("g")):
#      print("G")
      low = mid
      mid = (int(low) + int(high))//2
#      print(mid)

   if (low == mid or high == mid):
      print("Your answers have not been consistent.")
      quit()

   if (low == high):
      break

   print("Is your number Less than, Greater than, or Equal " + str(mid) + "?")
   answer = input("Type 'L', 'G' or 'E': ")
   count += 1

if (count != 1):
   print("Your number is "+ str(mid) + ". I found your number in " + str(count) + " guesses.")
if (count == 1):
   print("Your number is "+ str(mid) + ". I found your number in " + str(count) + " guess.")
