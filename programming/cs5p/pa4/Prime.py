def isPrime( m, L ):
	for i in L:
		if i<=math.sqrt(m):
#			print("checking m%i")
			if m%i==0:
				return
	L.append(m)

import math
listOPrimes = [2]
numOPrimes = int(input("Enter the number of Primes to compute: "))

i=3
while(len(listOPrimes) < int(numOPrimes)):
#	print("in isPrime")
	isPrime(i, listOPrimes)
	i+=1

print("the first " + str(numOPrimes) + " primes are: ")
print(" ".join(str(x) for x in listOPrimes))
#print(listOPrimes)
