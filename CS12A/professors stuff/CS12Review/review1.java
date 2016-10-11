//NOTE: java.util is being used for the Arrays.toString() method. 
//None of the exercises requires Arrays.toString(), it's just to print out arrays.
import java.util.*;
class review1{
	
	public static void main(String[] args){
		//You can also try doing your own arrays to test more cases!
		int [] testArray = {10,5,1,7,3,2,4,8,9,6};
		//First exercise: Traversing an array.
		System.out.println("The minimum in this array is: "+findMin(testArray));
		System.out.println("The minimum in this array is found at: "+argMin(testArray));
		//Other exercises for practice: Try coding argMax and findMax on paper and on this file. 

		//Second exercise: Mathematical Operations. 
		System.out.println("3 to the power of 5 is: " + atoN(3,5));
		System.out.println("5 factorial is: " + factorial(5));
		//Other exercises for pracice: Try coding the fibonnacci sequence in iterative or recursive.

		//Third exercise:  Bubblesort
		// NOTE: Arrays.toString(array) is a great way to print out arrays. 
		System.out.println("Array before sorting :"+Arrays.toString(testArray));
		//Swap 2 and 3 in the array.
		//2 and 3 are at positions 4 and 5 in the array.
		swapElements(testArray,4,5);
		System.out.println("Array after swapping 2 and 3 :"+Arrays.toString(testArray));
		//Sort the array
		bubbleSort(testArray);
		System.out.println("Array after sorting :"+Arrays.toString(testArray));


	}

	static void bubbleSort(int [] arr){
		//You want to go to length-1 so you don't point to null when checking the last pair.
		for(int i=0; i<arr.length-1; i++){
			//You want to cover whatever is in the array except for the positions you have already covered.
			for(int j=1; j<arr.length-i; j++){
				//Check pairs in j-1 and j 
				//If it's larger in the left, then we swap to "float" the bigger values to the top. 
				if(arr[j-1] > arr[j]){
					swapElements(arr,j-1,j);
				}
			}
		}
	}

	static void swapElements(int [] arr, int ind1, int ind2){
		//Store first element in temporary variable. 
		int temp = arr[ind1];
		//Swap first and second.
		arr[ind1] = arr[ind2];
		//Swap second with first (stored in temporary variable);
		arr[ind2] = temp;
	}

	static int atoN(int a, int n){
		//n to the 0 is always 1.
		int pow = 1;
		for(int i = 1; i<=n; i++){
			//Multiply a n times.
			pow *= a; 
		}
		return pow; 
	}

	//Recursive version for reference.
	static int atoNRecursive(int a, int n){
		if(n == 1)
			return a; 
		else
			return a*atoNRecursive(a,n-1);
	}

	static int factorial(int n){
		//Start with 1 because with 0, it will always multiply to 0.
		int fac = 1;
		for(int i = 1; i<=n; i++){
			//Multiply the current number to the total.
			fac *= i; 
		}
		return fac; 
	}

	//Recursive version for reference. 
	static int factorialRecursive(int n){
		if(n == 1)
			return 1;
		else
			return n * factorialRecursive(n-1);
	}

	static int findMin(int [] arr){
		//Use the first element as the first one to compare. 
		int min = arr[0];
		for(int i = 0; i<arr.length; i++){
			if(arr[i] < min){
				min = arr[i];
			}
		}
		return min; 
	}

	static int argMin(int [] arr){
		//Use the first position as the first one to compare. 
		int min = 0;
		for(int i = 0; i<arr.length; i++){
			if(arr[i] < min){
				min = i;
			}
		}
		return min; 
	}
} 

