#include <stdio.h>
#include <stdlib.h>
#include "Dictionary.h"

int main(void){
   Dictionary D = newDictionary();
   
   char* word1[] = {"one","two","three","four","five","six","seven"};
   char* word2[] = {"foo","bar","blah","galumph","happy","sad","blue"};
   int i;

   for(i=0; i<7; i++){
      insert(D, word1[i], word2[i]);
   }

printDictionary(stdout, D);

   delete(D,"one");
   delete(D,"three");
   delete(D,"six");
   
   printDictionary(stdout, D);
   
   freeDictionary(&D);
   printDictionary(stdout, D);

}
