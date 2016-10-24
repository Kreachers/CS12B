/* Re-do problem 6 but this time in C. Use the function heading void sortWords(char** W, int n).
Assume that W is an array of length n whose elements are null-terminated char arrays (i.e. C strings) */

void sortWords(char** W, int n) {
  int i, j;
  char* temp;
  for(j=1; j<n; j++) {
    temp = w[j];
    i = j-1;
    while(i >= 0 && strcmp(temp, w[i]) < 0) {
      w[i+1] = w[i];
      i--;
    }
    w[i+1] = temp;
  }
}
