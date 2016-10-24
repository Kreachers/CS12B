//-----------------------------------------------------------------------------
// QueueTest.c
// Test client for the Queue of strings ADT
//-----------------------------------------------------------------------------

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include"Queue.h" 

int main(int argc, char* argv[]){
   Queue A = newQueue();
   Queue B = newQueue();

   enqueue(A, "one");
   enqueue(A, "two");
   enqueue(A, "three");

   enqueue(B, "four");
   enqueue(B, "five");
   enqueue(B, "six");

   printQueue(stdout, A);
   printQueue(stdout, B);
   fprintf(stdout, "%s\n", equals(A, B)?"true":"false");

   enqueue(A, "four");
   enqueue(A, "five");
   enqueue(A, "six");

   printQueue(stdout, A);
   printQueue(stdout, B);
   fprintf(stdout, "%s\n", equals(A, B)?"true":"false");

   dequeue(A);
   dequeue(A);
   dequeue(A);

   printQueue(stdout, A);
   printQueue(stdout, B);
   fprintf(stdout, "%s\n", equals(A, B)?"true":"false");

   // free heap memory
   freeQueue(&A);
   freeQueue(&B);

   return(EXIT_SUCCESS);
}
