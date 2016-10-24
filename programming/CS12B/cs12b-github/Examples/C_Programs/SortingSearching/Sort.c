//-----------------------------------------------------------------------------
// Sort.c
//-----------------------------------------------------------------------------

#include<stdio.h>
#include<stdlib.h>
#include<assert.h>

void printArray(int* A, int n){
   int i;
   for(i=0; i<n; i++){
      printf("%d ", A[i]);
   }
   printf("\n");
}

void swap(int* A, int i, int j){
   int temp;
   temp = A[i];
   A[i] = A[j];
   A[j] = temp;
}

void BubbleSort(int* A, int n){
   int i, j;
   for(j=n-1; j>0; j--){
      for(i=1; i<=j; i++){
         if( A[i]<A[i-1] ) swap(A, i, i-1);
      }
   }
}

void SelectionSort(int* A, int n){
   int i, j, imax;
   for(j=n-1; j>0; j--){
      imax = 0;
      for(i=1; i<=j; i++) 
         if( A[imax]<A[i] ) imax = i;
      swap(A, imax, j);
   }
}

void InsertionSort(int* A, int n){
   int i, j, temp;
   for(j=1; j<n; j++){
      temp = A[j];
      i = j-1;
      while( i>=0 && temp<A[i] ){
         A[i+1] = A[i];
         i--;
      }
      A[i+1] = temp;
   }
}

void Merge(int* A, int p, int q, int r){
   int i, j, k, n1=q-p+1, n2=r-q;
   int* L = calloc(n1, sizeof(int));
   int* R = calloc(n2, sizeof(int));
   assert(L!=NULL && R!=NULL);

   for(i=0; i<n1; i++) L[i] = A[p+i];
   for(j=0; j<n2; j++) R[j] = A[q+j+1];
   i = 0; j = 0;
   for(k=p; k<=r; k++){
      if( i<n1 && j<n2 ){
         if( L[i]<R[j] ){ A[k] = L[i]; i++;}
         else{ A[k] = R[j]; j++;}
      }
      else if( i<n1 ){ A[k] = L[i]; i++;}
      else{ /* j<n2 */ A[k] = R[j]; j++;}
   }
   free(L);
   free(R);
}

void MergeSort(int* A, int p, int r){
   int q;
   if( p<r ){
      q = (p+r)/2;
      MergeSort(A, p, q);
      MergeSort(A, q+1, r);
      Merge(A, p, q, r);
   }
}

int Partition(int* A, int p, int r){
   int i, j, x;
   x = A[r];
   i = p-1;
   for(j=p; j<r; j++){
      if( A[j]<=x ){
         i++;
         swap(A, i, j);
      }
   }
   swap(A, i+1, r);
   return(i+1);
}

void QuickSort(int* A, int p, int r){
   int q;
   if( p<r ){
      q = Partition(A, p, r);
      QuickSort(A, p, q-1);
      QuickSort(A, q+1, r);
   }
}

void CountingSort(int* A, int* B, int n, int k){
   int i, j;
   int* C = calloc(k+1, sizeof(int));
   assert(C!=NULL);
   for(i=0; i<=k; i++) C[i] = 0;
   for(j=0; j<n; j++) C[A[j]] = C[A[j]]+1;
   for(i=1; i<=k; i++) C[i] = C[i] + C[i-1];
   for(j=n-1; j>=0; j--){
      B[C[A[j]]-1] = A[j];
      C[A[j]]--;
   }
   free(C);
}

int main(int argc, char** argv){
   int i, n=9;
   int A[] = {9,5,3,6,7,4,8,1,2};
   int B[9];

   printArray(A, n);

   //BubbleSort(A, n);
   //SelectionSort(A, n);
   //InsertionSort(A, n);
   //MergeSort(A, 0, n-1);
   QuickSort(A, 0, n-1);
   //CountingSort(A, B, n, 9);

   printArray(A, n);


   return(EXIT_SUCCESS);
}
