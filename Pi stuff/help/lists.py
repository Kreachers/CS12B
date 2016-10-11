grocery_list = ['juice', 'Tomatoes', 'potatoes', 'Bananas']
print ('First Item', grocery_list[0]) # First item of a list is always 0

grocery_list[0] = 'Green juice' # Replace an item in a list
print ('First Item', grocery_list[0])

print (grocery_list[1:3]) # Prints selected range within list - doesn't print through last item

other_events = ['wash car', 'pick up kids', 'cash check']
to_do_list = [other_events, grocery_list] # Store lists into other lists

print (to_do_list)

print ((to_do_list[1][1])) # Print certain items in certain lists

grocery_list.append('onions') # Append items to the end of lists
print (to_do_list)

grocery_list.insert(1, 'pickle') # Inserts an item in a specified place

grocery_list.remove('pickle')

grocery_list.sort()

grocery_list.reverse()

del grocery_list[4] # Deletes a specific item in a list
print (to_do_list) # All changes to a sublist affects parent list

to_do_list2 = other_events + grocery_list

print(len(to_do_list2)) # Get length (num of items) of a list

print (max (to_do_list2)) # Maximim/highest alphabetically
print (min (to_do_list2))
