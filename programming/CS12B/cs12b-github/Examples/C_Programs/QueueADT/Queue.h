//-----------------------------------------------------------------------------
// Queue.h
// Header file for the Queue of strings ADT
//-----------------------------------------------------------------------------

#ifndef _QUEUE_H_INCLUDE_
#define _QUEUE_H_INCLUDE_

// Queue
// Exported reference type
typedef struct QueueObj* Queue;

// newQueue()
// constructor for the Queue type
Queue newQueue(void);

// freeQueue()
// destructor for the Queue type
void freeQueue(Queue* pQ);

// isEmpty()
// returns 1 (true) if Queue Q is empty, 0 (false) otherwise
int isEmpty(Queue Q);

// enqueue()
// adds the string s to back of Queue Q
void enqueue(Queue Q, char* s);

// dequeue()
// deletes and returns the string from front of Queue Q
// pre: !isEmpty()
char* dequeue(Queue Q);

// peek()
// returns string at front of Queue Q
// pre: !isEmpty()
char* peek(Queue Q);

// dequeueAll()
// sets Queue Q to the empty state
// pre: !isEmpty()
void dequeueAll(Queue Q);

// printQueue()
// prints a text representation Queue Q to the file pointed to by out
void printQueue(FILE* out, Queue Q);

// equals()
// returns 1 (true) if Q and R are the same sequence of strings, 0 (false) 
// otherwise
int equals(Queue Q, Queue R);

#endif
