//-----------------------------------------------------------------------------
// StackTrace2.c
//-----------------------------------------------------------------------------
#include<stdio.h>
#include<stdlib.h>

int f(int n){
   if( n>0 )
      return n+f(n-1);
   else if( n<0 )
      return n+f(n+1);
   else
      return 0;
}

int main(){
   printf("%d\n", f(5));
   return EXIT_SUCCESS;
}