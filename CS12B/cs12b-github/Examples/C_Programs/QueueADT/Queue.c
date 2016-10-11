//-----------------------------------------------------------------------------
// Queue.c
// Array based implementation of the Queue of strings ADT.  Uses a circular,
// expandable array.
//-----------------------------------------------------------------------------

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<assert.h>
#include"Queue.h"

// private types and functions ------------------------------------------------

static const int initialSize = 1;

// QueueObj
typedef struct QueueObj{
   char** item;        // array of Queue items
   int physicalSize;   // current size of underlying array
   int numItems;       // number of items in Queue
   int front;          // index of front item
   int back;           // index of back item
} QueueObj;

// doubleItemArray()
// doubles the physical size of the underlying array item[]
void doubleItemArray(Queue Q){
   int i, p, n, f;
   char** newArray;
   
   p = Q->physicalSize;
   n = Q->numItems;
   f = Q->front;
   newArray = calloc(2*p, sizeof(char*));
   
   for(i=0; i<n; i++) newArray[i] = Q->item[(f+i)%p];
   free(Q->item);
   Q->item = newArray;
   Q->physicalSize = 2*p;
   Q->front = 0;
   Q->back = n-1;
}


// public functions -----------------------------------------------------------

// newQueue()
// constructor for the Queue type
Queue newQueue(){
   Queue Q = malloc(sizeof(QueueObj));
   assert(Q!=NULL);
   Q->item = calloc(initialSize, sizeof(char*));
   Q->physicalSize = initialSize;
   Q->numItems = 0;
   Q->front = 0;
   Q->back = -1;
   return Q;
}

// freeQueue()
// destructor for the Queue type
void freeQueue(Queue* pQ){
   if( pQ!=NULL && *pQ!=NULL ){
      dequeueAll(*pQ);
      free((*pQ)->item);
      free(*pQ);
      *pQ = NULL;
   }
}

// isEmpty()
// returns 1 (true) if Queue Q is empty, 0 (false) otherwise
int isEmpty(Queue Q){
   return(Q->numItems==0);
}

// enqueue()
// adds the string s to back of Queue Q
void enqueue(Queue Q, char* s){
   if( Q->numItems==Q->physicalSize ) doubleItemArray(Q);
   Q->numItems++;
   Q->back++;
   Q->back %= Q->physicalSize;
   Q->item[Q->back] = s;
}

// dequeue()
// deletes and returns the string from front of Queue Q
// pre: !isEmpty()
char* dequeue(Queue Q){
   if( Q->numItems==0 ){
      fprintf(stderr, "Queue Error: cannot dequeue() empty Queue\n");
      exit(EXIT_FAILURE);
   }
   char* returnVal = Q->item[Q->front];
   Q->front++;
   Q->front %= Q->physicalSize;
   Q->numItems--;
   return returnVal;
}

// peek()
// returns string at front of Queue Q
// pre: !isEmpty()
char* peek(Queue Q){
   if( Q->numItems==0 ){
      fprintf(stderr, "Queue Error: cannot peek() empty Queue\n");
      exit(EXIT_FAILURE);
   }
   return Q->item[Q->front]; 
}

// dequeueAll()
// sets Queue Q to the empty state
// pre: !isEmpty()
void dequeueAll(Queue Q){
   if( Q->numItems==0 ){
      fprintf(stderr, "Queue Error: cannot dequeueAll() empty Queue\n");
      exit(EXIT_FAILURE);
   }
   Q->numItems = 0;
   Q->front = 0;
   Q->back = -1;
}

// printQueue()
// prints a text representation Queue Q to the file pointed to by out
void printQueue(FILE* out, Queue Q){
   int i, n=Q->numItems, f=Q->front, p=Q->physicalSize;
   for(i=0; i<n; i++){
      fprintf(out, "%s ", Q->item[(f+i)%p]);
   }
   fprintf(out, "\n");
}

// equals()
// returns 1 (true) if Q and R are the same sequence of strings, 0 (false)
// otherwise
int equals(Queue Q, Queue R){
   int i, n, m;
   int eq = ( Q->numItems == R->numItems );
   
   for(i=0; eq && i<Q->numItems; i++){
      n = (Q->front+i)%Q->physicalSize;
      m = (R->front+i)%R->physicalSize;
      eq = ( strcmp(Q->item[n], R->item[m])==0 ); 
   }
   return eq;
}
