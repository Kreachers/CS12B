//-----------------------------------------------------------------------------
// Search.c
//-----------------------------------------------------------------------------

#include<stdio.h>
#include<stdlib.h>
#include<assert.h>

int SequentialSearch(int* X, int n, int t){
   int i=0, found=0;
   while( i<n && !found ){
      if( t==X[i] )
         found = 1;
      else
         i++;
   }
   if( !found ) i = -1;
   return i;
}

int BinarySearch(int* X, int n, int t){
   int i=0, j=n-1, found=0, m;
   while( i<=j && !found ){
      m = (i+j)/2;
      if( t==X[m] )
         found = 1;
      else if( t<X[m] )
         j = m-1;
      else
         i = m+1;
   }
   if( !found ) m = -1;
   return m;
}

int main(int argc, char** argv){
   int i, j, k, m;
   int A[] = {2,5,-3,45,12,4,8,19,3,12};
   int B[] = {2,4,6,8,10,12,14,16,18,20};

   i = SequentialSearch(A, 10, 12);
   j = SequentialSearch(B, 10, 12);
   k = BinarySearch(B, 10, 12);
   m = BinarySearch(B, 10, 13);

   printf("%d, %d, %d, %d\n", i, j, k, m);

   return(EXIT_SUCCESS);
}
