//-----------------------------------------------------------------------------
//  MemoryErrors.c
//
//  Compile this program calling the executable MemoryErrors:
//
//      gcc -std=c99 -o MemoryErrors MemoryErrors.c
//  
//  then run it under valgrind:
//
//      valgrind --leak-check=full MemoryErrors
//
//-----------------------------------------------------------------------------

#include<stdio.h>
#include<stdlib.h>

int main(){

   int x = 6;
   int* p;

   //--------------------------------------------------------------------------
   //  Accessing free blocks of heap memory
   //--------------------------------------------------------------------------

   // allocate some heap memory, then free it
   p = malloc(sizeof(int));
   free(p);

   // p is now a pointer to a free block of memory.  Being free, the block may be
   // allocated later in the program. Accessing it then may cause problems
   
   x = *p;  // This is an illegal read from the block.  Likely to be junk.
   *p = 7;  // This is an illegal write to the block. It may corrupt memory.

   // We should have done this
   p = malloc(sizeof(int));
   free(p);
   p = NULL;  // Set the pointer to something other than the free block, like NULL.

   // Since p now contains the NULL address, it no longer points to a free block.  
   // Accessing the value at p now causes a segmentation fault.  Although this is
   // a runtime error and crashes the program, is better than the previous error.
   
   // *p = 6;  // uncomment this line to get a seg fault


   //--------------------------------------------------------------------------
   //  Memory Leaks
   //--------------------------------------------------------------------------

   // Allocate some heap memory again
   p = malloc(sizeof(int));  // * this memory will be leaked

   // Assign p to point to somthing else without first freeing the memory it
   // currently points to. 
   p = &x; 

   // The heap memory that was allocated on line 53 is still allocated, but 
   // cannot be accessed, since we've lost its address.  In particular it can't
   // be freed, so it cannot be allocated or used for any purpose.  We call this
   // a memory leak.

   return(EXIT_SUCCESS);
}
