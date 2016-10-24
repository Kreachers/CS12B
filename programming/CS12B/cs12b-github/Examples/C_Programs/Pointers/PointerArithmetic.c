//-----------------------------------------------------------------------------
// PoninterArithmetic.c
//-----------------------------------------------------------------------------

#include<stdio.h>
#include<stdlib.h>

int main(){
   int i;
   int X[] = {1, 2, 3, 4};
   int* Y;

   Y = X;       // Y is now an alias for array X
   Y[2] = -10;  // we've just changed X indirectly

   // print both X and Y to verify they are the same
   for(i=0; i<4; i++){
      printf("%d %d\n", X[i], Y[i]);
   }
   printf("\n");

   // check pointer arithmetic identities
   // note that cond?exp1:exp2 works same as in Java
   printf( "%s\n", X==&X[0]     ? "true" : "false" );  
   printf( "%s\n", X+1==&X[1]   ? "true" : "false" );
   printf( "%s\n", X+2==&X[2]   ? "true" : "false" );
   printf( "%s\n", *X==X[0]     ? "true" : "false" );
   printf( "%s\n", *(X+1)==X[1] ? "true" : "false" );
   printf( "%s\n", *(X+2)==X[2] ? "true" : "false" );
   printf("\n");

   // print both X and Y using pointer arithmetic
   for(i=0; i<4; i++){ 
      printf( "%d %d\n", *(X+i), *(Y+i) );
   }
   printf("\n"); 

   // change what Y points to
   Y++;  // now Y is &X[1]
   Y++;  // now Y is &X[2]
   printf("%d\n", *Y); 

   // can't do this with X since its declaration makes it constant
   // X++; // uncomment for a syntax error

   // read past the end of an array, bad! (never do this)
   printf("%d\n", X[50]); 

   // write past the end, very bad!! (never do this)
   X[50]=25;
   printf("%d\n", X[50]); 

   return(EXIT_SUCCESS);
}
