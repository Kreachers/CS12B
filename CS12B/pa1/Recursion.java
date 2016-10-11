/*
 * This is suppose to take a string of integers in random 
 * order and reverse the order 3 different ways and also
 * find the index of the maximum and minimum values in the array
 */

public class Recursion {

	// print out the reversal of the leftmost n elements in X
	static int[] reverseArray1(int[] X, int n, int[] Y) {
		if(n > 0) {							// if n==0 do nothing
			Y[X.length - n] = X[n-1];		//move the left side of Y to the right side of X
			reverseArray1(X, n-1, Y);
		}
		return Y;
	}

	// print out the reversal of the rightmost n elements in X
	static int[] reverseArray2(int[] X, int n, int[] Y) {
		if(n > 0){							// if n==0 do nothing
			reverseArray2(X, n-1, Y);		
			Y[n-1] = X[X.length-n];			//swap the right side of Y with the left side of X
		}
		return Y;
	}
	//swap the left and right sides of the array then return it
	static int[] reverseArray3(int[] X, int i, int j) {
		if(i <= j){
			int temp = X[i];				//temp variable for storing the value in the leftmost side of X
			X[i] = X[j];					//swap the leftmost side of x with the rightmost side of x
			X[j] = temp;					//swap the rightmost side of x with the temp variable
			reverseArray3(X, i+1, j-1);		//repeat on the subarray
		}
		return X;
	}
	//finds the Index of the max value within the array
	private static int maxArrayIndex(int[] X, int i, int k) {
		int j = 0;							//temp variable for the middle of the subarray
		if (i < k) {						//if i==j just return j
			j = (i+k)/2;					//calculate the middle of the subarray
			int left = maxArrayIndex(X, i, j);			//calculates the index of the max value in the left side of the array
			int right = maxArrayIndex(X, j+1, k);		//calculates the index of the max value in the right side of the array
			if (X[left] > X[right]) j = left;			//if the left side is greater set j = to the left side
			else if (X[right] > X[left]) j = right;		//iff the right side is greater set j = to the right side
		}
		return j;							//return the index of the max value
	}

	//finds the index of the min value within the array
	private static int minArrayIndex(int[] X, int i, int k) {
		int j = 0;							//temp variable for the middle of the subarray
		if (i < k) {						//if i==j just return j
			j = (i+k)/2;					//calculate the middle of the subarray
			int left = minArrayIndex(X, i, j);			//calculates the index of the min value in the left side of the array
			int right = minArrayIndex(X, j+1, k);		//calculates the index of the min value in the right side of the array
			if (X[left] < X[right]) j = left;			//if the left side is less set j = to the left side
			else if (X[right] < X[left]) j = right;		//if the right side is less set j = to the right side
		}
		return j;							//return the index of the min value
	}

	public static void main(String[] args){

		int[] A = {-1, 2, 6, 12, 9, 2, -5, -2, 8, 5, 7};
		int[] B = new int[A.length];
		int[] C = new int[A.length];
		int minIndex = minArrayIndex(A, 0, A.length-1);
		int maxIndex = maxArrayIndex(A, 0, A.length-1);

		for(int x: A) System.out.print(x+" ");
		System.out.println();

		System.out.println( "minIndex = " + minIndex );
		System.out.println( "maxIndex = " + maxIndex );
		reverseArray1(A, A.length, B);
		for(int x: B) System.out.print(x+" ");
		System.out.println();

		reverseArray2(A, A.length, C);
		for(int x: C) System.out.print(x+" ");
		System.out.println();

		reverseArray3(A, 0, A.length-1);
		for(int x: A) System.out.print(x+" ");
		System.out.println();

	}
}


