'''Dictionaries are values with a unique key for each value you are going
to be storing.  These are similar to lists, but you cannot join dictionaries
together like lists'''

super_villains = {'Fiddler' : 'Isaac Bowin',
                  'Captain Cold' : 'Leonard Snart',
                  'Weather Wizard' : 'Mark Mardon',
                  'Mirror Master' : 'Sam Scudder',
                  'Pied Piper' : 'Thomas Peterson'}

print(super_villains['Captain Cold']) # Pulls up an entry

del super_villains['Fiddler'] # Deletes an entry

super_villains['Pied Piper'] = 'Hardley Rathaway' # Replaces an entry

print(len(super_villains)) # Number of entries
print(super_villains.get('Pied Piper')) # Prints values
print (super_villains.keys()) # Gets a list of super_villain keys
print(super_villains.values()) # Gets a list of dictionary values
