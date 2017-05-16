#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>
#include "Dictionary.h"

//private types and fucntions---------------------------------

const int tableSize = 101;

// NodeObj
typedef struct NodeObj{
   char* key;
   char* value;
   struct NodeObj* next;
} NodeObj;

//NOde 
typedef NodeObj* Node;

// newNode()
// constructor for private Node Type
Node newNode(char* k, char*v){
   Node N = malloc(sizeof(NodeObj));
   assert(N != NULL);
   N->key = k;
   N->value = v;
   N->next = NULL;
   return (N);
}

void freeNode(Node* pN){
   if(pN != NULL && *pN != NULL){
      free(*pN);
      *pN = NULL;
   }
}

//DictionaryObj
typedef struct DictionaryObj{
   Node* H;  
   Node head;
   int numItems;
}DictionaryObj;

//rotate_left()
//rotate the bits in an unsigned int
unsigned int rotate_left(unsigned int value, int shift) {
   int sizeInBits = 8*sizeof(unsigned int);
   shift = shift & (sizeInBits - 1);
    if ( shift == 0 )
       return value;
    return (value << shift) | (value >> (sizeInBits - shift));
}

//pre_hash()
//turn a string into an unsigned int
unsigned int pre_hash(char* input) {
   unsigned int result = 0xBAE86554;
   while (*input) {
      result ^= *input++;
      result = rotate_left(result, 5);
   }
   return result;
}

//hash()
//turns a string into an int in the range 0 ti tableSize-1 
int hash(char* key){
   return pre_hash(key)%tableSize;
}

//freeArray()
//frees the hash table of Dictionary D
void freeArray(Dictionary D){
   free(D->H);
}

//public functions----------------------------------------------

//newDictioary()
//constructor for the Dictioary type
Dictionary newDictionary(void){
   Dictionary S = malloc(sizeof(DictionaryObj));
   assert(S != NULL);
   S->H = malloc(sizeof(NodeObj)*tableSize);   
   S->numItems = 0;
   return S;
}

//freeDictionary()
//destructor for the Dictionary type
void freeDictionary(Dictionary *pD){
   if( pD != NULL && *pD != NULL){
      if (!isEmpty(*pD)){
         makeEmpty(*pD);
      }
      freeArray(*pD);
      free(*pD);
      *pD = NULL;
   }
}

//isEmpty()
//returns 1 (true) id S is empty, 0 (false) otherwise
//pre: none
int isEmpty(Dictionary D){
   if(D == NULL){
      fprintf(stderr, "Dictionary Error: calling isEmpty() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   return(D->numItems == 0);
}


// size()
// returns the number of (key, value) pairs in D
// pre: none
int size(Dictionary D){
   if(D == NULL){
      fprintf(stderr, "Dictionary Error: calling size() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   return D->numItems;
}

// lookup()
// returns the value v such that (k, v) is in D, or returns NULL if no
// such value v exists.
// pre: none
char* lookup(Dictionary D, char* k){
   int m;
   if(D == NULL){
      fprintf(stderr, "Dictionary Error: calling lookup() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   m = hash(k);
   Node N = D->H[m];
   if(N == NULL){
      return NULL;
   }else{
      for( ;N != NULL;N = N->next){
         if(strcmp(N->key,k) == 0){
            return N->value;
         }
      }
      return NULL;
   }
}

// insert()
// inserts new (key,value) pair into D
// pre: lookup(D, k)==NULL
void insert(Dictionary D, char* k, char* v){
   int m;
   if(D == NULL){
     fprintf(stderr, "Dictionary Error: calling insert() on NULL Dictionary reference\n");
     exit(EXIT_FAILURE);
   }
   if(lookup(D,k) != NULL){
      fprintf(stderr, "Dictionary Error: calling insert() on a non-existent key\n");
      exit(EXIT_FAILURE);
   }
   m = hash(k);
   Node N;
   if(D->H[m] == NULL){
      N = newNode(k,v);
      N->next = D->H[m];
      D->H[m] = N;
      D->numItems++;
   }else{
      N = D->H[m];   
      for( ;N != NULL;N = N->next){}
      Node P = N->next;
      N->next = newNode(k,v);
      N = N->next;
      N->next = P;
      D->numItems++;
   }     
}

// delete()
// deletes pair with the key k
// pre: lookup(D, k)!=NULL
void delete(Dictionary D, char* k){
   int m;
   if(D == NULL){
      fprintf(stderr, "Dictionary Error: calling delete() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   if(lookup(D, k) == NULL){
      fprintf(stderr, "Dictionary Error: calling delete() on a non-existent key\n");
      exit(EXIT_FAILURE);
   }
   m = hash(k);
   Node P = D->H[m];
   for( ;strcmp(P->key,k)!=0;P=P->next){}
   Node N = D->H[m];
   if(D->H[m]->next==P->next){
      D->H[m] = D->H[m]->next;
      P->next = NULL;
      D-> numItems--;
   }else{
      for( ;N->next!=P;N=N->next){}
      N->next = P->next;
      P->next = NULL;
      D->numItems--;
   }
   freeNode(&P);
   P = NULL;
}

// makeEmpty()
// re-sets D to the empty state.
// pre: none
void makeEmpty(Dictionary D){
    int i;
    if(D == NULL){
      fprintf(stderr, "Dictionary Error: calling makeEmpty() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }
   for(i = 0; i < tableSize; i++){
      Node N = D->H[i];
      char *key;
      for( ;N != NULL;N = N->next){
         key = N->key;
         delete(D, key);
      }
   }
   D->numItems = 0;
}
                   
// printDictionary()
// pre: none
// prints a text representation of D to the file pointed to by out
void printDictionary(FILE* out, Dictionary D){
   int i;
   if(D == NULL){
      fprintf(stderr, "Dictionary Error: calling printDictionary() on NULL Dictionary reference\n");
      exit(EXIT_FAILURE);
   }   
   for(i = 0; i < tableSize; i++){
      if(D->H[i] != NULL){
         for(Node N = D->H[i];N!=NULL;N = N->next){
            fprintf(out,"%s %s\n",N->key,N->value);
         }
      }
   }
}               
