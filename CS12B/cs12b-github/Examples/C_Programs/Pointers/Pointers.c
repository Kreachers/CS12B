//-----------------------------------------------------------------------------
// Poninters.c
//-----------------------------------------------------------------------------

#include<stdio.h>
#include<stdlib.h>

int main(){
   int x=6, y=7;
   int* p;
   int* q;

   printf("x = %d, y = %d\n", x, y);
   printf("&x = %p, &y = %p\n", &x, &y);  

   p = &x;
   q = &y;

   printf("*p = %d, *q = %d\n", *p, *q);
   printf("p = %p, q = %p\n", p, q); 

   p = q;
   q = &x;

   printf("*p = %d, *q = %d\n", *p, *q);
   printf("p = %p, q = %p\n", p, q);  

   // address-of (&) and value-at (*) are inverse operations
   printf("%s\n", *&x==x?"true":"false");
   printf("%s\n", &*p==p?"true":"false"); 


   return(EXIT_SUCCESS);
}
