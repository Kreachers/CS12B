//-----------------------------------------------------------------------------
//  ArraysOnHeap.c
//
//  Compile: gcc -std=c99 -o ArraysOnHeap ArraysOnHeap.c 
//
//-----------------------------------------------------------------------------

#include<stdio.h>
#include<stdlib.h>

void printArray(int* X, int m);

int main(int argc, char* argv[]){

   int n;
   int* A;
   int* B;

   // Read an integer from the command line.  The program will seg fault if 
   // run with no command line argument (try it).
   sscanf(argv[1], " %d", &n); 

   // Allocate an array on the stack, must use a constant in brackets [].
   int C[10];  

   // Attempt to allocate array on stack of variable length [n].  Some 
   // compilers may allow this, some don't.  Don't do it in any case.
   // int C[n];  
   
   // Allocate two arrays from heap memory, one with calloc() one with malloc() 
   A = calloc(n,sizeof(int));
   B = malloc(n*sizeof(int));

   // Note we're printing out uninitialized arrays here.  This should always be 
   // considered garbage.  calloc() initializes its array to all zeros.  malloc() 
   // may do this also depending on the particular C implementation.
   printArray(A, n);
   printArray(B, n);
   printArray(C, 10);

   // Let's print out data past the ends of these arrays and see more garbage.
   printArray(A, 2*n);
   printArray(B, 2*n);
   printArray(C, 20);  
 
   return(EXIT_SUCCESS);
}

// This function prints out the first m integers in the array X.  The caller
// can place a number in the slot for m that is bigger than the length of X.
// This will access memory not in the array, which is bad.  Can't do this in Java.
void printArray(int* X, int m){
   int i;
   for(i=0; i<m; i++)
      printf("%d ", X[i]);  // could have been *(X+i)
   printf("\n");
}
