//-----------------------------------------------------------------------------
// StackTrace.c
//-----------------------------------------------------------------------------
#include<stdio.h>
#include<stdlib.h>

int a(int x){ 
   return 2*x;
}

int b(int y){
   int u, v;
   u = a(y);
   v = u+y;
   return 2*v;
}

int main(){
   printf("%d\n", a(3));
   printf("%d\n", b(2));
   return EXIT_SUCCESS;
}