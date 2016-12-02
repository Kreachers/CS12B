#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include <assert.h>

#define maxStrLength 100 //max string length

void extract_chars(char* s, char* a, char* d, char* p, char* w) {
  int i=0, j=0, k=0, l=0, m=0;
  while(s[i] != '\0' && i<maxStrLength) {
    //check if it alphabetic
    if (isalpha((int)s[i])) {
      a[j]=s[i];
      j++;

      //check if its and integer
    } else if (isdigit((int)s[i])) {
      d[k] = s[i];
      k++;

      //check if its punctuation
    } else if (ispunct((int)s[i])) {
      p[l] = s[i];
      l++;

      //check if its just whitespace
    } else if (isspace((int)s[i])) {
      w[m] = s[i];
      m++;
    }
    i++;
  }
  a[j] = '\0';
  d[k] = '\0';
  p[l] = '\0';
  w[m] = '\0';
}

int main(int argc, char* argv[]) {
  FILE* in;
  FILE* out;
  char* line;
  char* word;
  char* number;
  char* punctuation;
  char* whitespace;
  int lineNum = 1;
  
  //check if the number of commands is correct
  if (argc != 3) {
    printf("Usage: %s <input file> <output file>\n", argv[0]);
    exit(EXIT_SUCCESS);
  }
  
  //prepare the input file
  in = fopen(argv[1], "r");
  if (in == NULL) { //no input
    printf("Unable to read from file %s\n", argv[1]);
    exit(EXIT_FAILURE);
  }
  
  //prepare the output file
  out = fopen(argv[2], "w");
  if (out == NULL) { //no output
    printf("Unable to write to file %s\n", argv[2]);
    exit(EXIT_FAILURE);
  }

  //allocate all the memory needed
  line = calloc(maxStrLength + 1, sizeof(char));
  word = calloc(maxStrLength + 1, sizeof(char));
  number = calloc(maxStrLength + 1, sizeof(char));
  punctuation = calloc(maxStrLength + 1, sizeof(char));
  whitespace = calloc(maxStrLength + 1, sizeof(char));
  assert( line != NULL && word != NULL && number != NULL && punctuation != NULL && whitespace != NULL);
  
  // read input file, correct type
  while (fgets(line, maxStrLength, in) != NULL) {
    extract_chars(line, word, number, punctuation, whitespace);
    fprintf(out, "line %d contains: \n", lineNum);
    
    //word
    if (strlen(word) >= 1) {
      fprintf(out, "%d alphabetic characters: %s\n", (int)strlen(word), word);
    }
    
    //number
    if (strlen(word) >= 1) {
      fprintf(out, "%d numeric characters: %s\n", (int)strlen(number), number);
    }
    
    //punctuation
    if (strlen(word) >= 1) {
      fprintf(out, "%d punctuation characters: %s\n", (int)strlen(punctuation), punctuation);
    }
    
    //whitespace
    if (strlen(whitespace) >= 0) {
      fprintf(out, "%d whitespace characters: %s\n", (int)strlen(whitespace), whitespace);
    }
    lineNum++;
  }
  
  //free allocated heap memory
  free(line);
  line = NULL;

  free(word);
  word = NULL;
  
  free(number); 
  number = NULL;
  
  free(punctuation); 
  punctuation = NULL;
  
  free(whitespace);
  whitespace = NULL;
  
  //close files
  fclose(in);
  fclose(out);
  
  return(EXIT_SUCCESS);
}

