quote = "\"Always remember you are unique" # Backslash adds quotes without
                                           # ending string

multi_line_quote = '''just like
everyone else\"'''

new_string = quote + multi_line_quote # You can add strings

print ("%s %s %s" % ('I like the quote',quote,multi_line_quote)) # Printing
                                                                 # multiple
                                                                 # quotes

print ('\n' * 5) # \n is a new line - you can multiply this however many times

print ("I don't like ", end="")
print ("newlines")
