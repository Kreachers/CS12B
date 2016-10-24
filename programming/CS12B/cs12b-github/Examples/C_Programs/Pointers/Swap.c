//-----------------------------------------------------------------------------
// Swap.c
//-----------------------------------------------------------------------------

#include<stdio.h>
#include<stdlib.h>

void badSwap(int x, int y){
   int temp;
   temp = x;
   x = y;
   y = temp;
}

void goodSwap(int* p, int* q){
   int temp;
   temp = *p;
   *p = *q;
   *q = temp;
}

int main(){
   int a = 6, b = 7;

   printf("a = %d, b = %d\n", a, b);
   badSwap(a, b);
   printf("a = %d, b = %d\n", a, b);
   goodSwap(&a, &b);
   printf("a = %d, b = %d\n", a, b);


   return(EXIT_SUCCESS);
}
