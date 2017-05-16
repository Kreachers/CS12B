print("Enter two number, low the high")
low = input("low = ")
high = input("high = ")

while (low > high):
   print("Please enter the smaller followed by the larger number")
   low = input("low = ")
   high = input("high = ")

print("Think of a number in the range of " + low + " and " + high)
print("Is your number Less than, Greater than, or Equal " + str(( int(low) + int(high) )//2) + "?")
input = input("Type 'L', 'G' or 'E': ")

count = 1
while (input != str("E") or input != str("e")):
   count += 1
   if (input == str("L") or input == str("l")):
      print("L")
   if (input == str("G") or input == str("g")):
      print("G")
   input = input("Type 'L', 'G' or 'E': ")

if (count != 1):
   print("I found your number in " + count + " guesses.")
if (count == 1):
   print("I found your number in " + count + " guess.")
