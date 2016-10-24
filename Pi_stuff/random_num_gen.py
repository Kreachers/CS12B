# 20141129
# This program generates a random number between 1 and 10 every 1/2 second

import random
import time

while True:
    randX = random.randint(1,10)
    print(randX)
    time.sleep(.5)
