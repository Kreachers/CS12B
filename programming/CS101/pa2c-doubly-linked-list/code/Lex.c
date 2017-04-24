// $Id: Lex.c,v 1.4 2015-07-07 16:35:31-07 - - $
// Bradley Bernard, bmbernar@ucsc.edu
// CS 101: PA2
// July 6, 2015
//
// Lex.c
// Sorts the input file using a List ADT and writing
// to an output file.

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

#include "List.h"

#define MAX_LEN 255

int main(int argc, char * argv[]){
   // Initialize variables
   int count = 0;
   FILE *in, *out;
   char line[MAX_LEN];

   // check command line for correct number of arguments
   if( argc != 3 ){
      printf("Usage: %s <input file> <output file>\n", argv[0]);
      exit(1);
   }

   // open files for reading and writing 
   in = fopen(argv[1], "r");
   out = fopen(argv[2], "w");
   if( in==NULL ){
      printf("Unable to open file %s for reading\n", argv[1]);
      exit(1);
   }
   if( out==NULL ){
      printf("Unable to open file %s for writing\n", argv[2]);
      exit(1);
   }

   /* read each line of input file, then count and print tokens */
   while( fgets(line, MAX_LEN, in) != NULL)  {
      count++;
   }
   
   // reset file pointer to start of file
   rewind(in);

   char lines[count - 1][MAX_LEN];
   int ln = -1;
   // Loop through and copy the file lines into a string array
   while(fgets(line, MAX_LEN, in) != NULL) {
      strcpy(lines[++ln], line);
   }
   
   // Create new List ADT
   List list = newList();

   // Append line number zero to start sorting
   append(list, 0);

   // Insertion Sort for (length - 2) elements
   for(int j = 1; j < count; ++j) {
      char *tmp = lines[j];
      int i = j - 1;
      // Reset list index to the back so we are able to
      // movePrev() to find the right index for insertion
      moveBack(list);
      // String compare the current line and each line in the list
      while(i >= 0 && strcmp(tmp, lines[get(list)]) <= 0) {
         --i;
         movePrev(list);
      }
      
      if(index(list) >= 0)
      //Exited loop before moving off so insertAfter() index
         insertAfter(list, j);
      else
      // Fell off the list so the new element must be prepend()
         prepend(list, j);
   }
   
   // Reset index to the front of the list
   moveFront(list);
   // Loop through List to print out all lines in correct order
   while(index(list) >= 0) {
      fprintf(out, "%s", lines[get(list)]);
      moveNext(list);
   }


   /* close files */
   fclose(in);
   fclose(out);
   
   // Free list ADT
   freeList(&list);

   return(0);
}
