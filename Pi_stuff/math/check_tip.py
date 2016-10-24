""" A quick sketch to assess how
much a tip should be for any given
check you'd receive at a restaurant."""

print('Do you have:')
print('')
print('1. A check with tax already added')
print('2. A check which you have to add tax')
print('')
choice = input('?: ')

if (choice != 1 and choice != 2):
    print('Your choice is bad and you should feel bad!')
    raise SystemExit

meal = input('How much was the meal?: ')

if choice == 2:
    tax = float(input('How much is the tax percentage?: '))
    tax = tax / 100
    meal = meal + meal * tax

tip = float(input('What percentage would you like to leave as tip?: '))
tip = tip / 100
tip = meal * tip

total = float(meal + tip)
tip = round(tip, 2)
total = round(total,2)

print 'Your tip for this meal should be',tip,' for a total bill of',total

