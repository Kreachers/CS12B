//-----------------------------------------------------------------------------
// Reverse.c
//-----------------------------------------------------------------------------

#include<stdio.h>
#include<stdlib.h>

void swap(int* A, int i, int j){ // int A[] would also work
   int temp;
   temp = A[i];
   A[i] = A[j];
   A[j] = temp;
}

void arrayReverse(int* A, int n){
   int i=0, j=n-1;
   while( i<j ){
      swap(A, i, j);
      i++;
      j--;
   }
}

int main(){
   int i;
   int X[] = {1, 2, 3, 4, 5};

   for(i=0; i<5; i++){ 
      printf("%d ", X[i]);
   }
   printf("\n");
   
   arrayReverse(X, 5);
   
   for(i=0; i<5; i++){ 
      printf("%d ", X[i]);
   }
   printf("\n");

   return(EXIT_SUCCESS);
}
