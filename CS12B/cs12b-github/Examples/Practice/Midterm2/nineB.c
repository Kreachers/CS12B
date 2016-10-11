#include<stdlib.h>
#include<stdio.h>

int static void displayOctal(int n) {
   if (n>0) {
      if (n/8>0) {
         displayOctal(n/8);
      }
      printf("%d", n%8);
   }
}
