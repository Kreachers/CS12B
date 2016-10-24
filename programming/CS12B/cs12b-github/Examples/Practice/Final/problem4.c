/* Write a C function with prototype char* cat(char* s1, char* s2) that takes two null (\0)
terminated char arrays s1 and s2, allocates sufficient heap memory to store the concatenation of the two
arrays (including a terminating null (\0) character), then returns a pointer to the new char array.
You may not use functions from the string.h library to accomplish the above tasks, in particular,
you must manually determine the length of char arrays s1 and s3 by searching for their terminating null characters */

char* cat (char* s1, char* s2) {
  int l1 = 0;
  int l2 = 0;
  int i, j , length;
  while(s1[l1] != '\0') {
    l1++;
  }
  while(s2[l2] != '\0') {
    l2++;
  }
  length = l1+l2;
  char* concat = calloc(length, sizeof(char));
  for(i = 0; i < l1; i++) {
    concat[i] = s1[i];
  }
  int i = 0;
  for(j = l1; j < length; j++) {
    concat[j] = s2[i];
    i++;
  }
  return concat;
}

int main(void) {
  printf("print1");
  char* A = "hello \0";
  printf("print2");
  char* B = "world \0";
  
  printf("print3");
  printf("%s", cat(A,B));
}
