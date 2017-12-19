/*
* FileReverse.c
* 12M lab3
* 4/18/16
* Reverses lines from input and places them in output file
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//this actually reverses by taking in a pointer to the string and reversing it from there21
void stringReverse(char* s) {
	int i = 0, temp, j = strlen(s)-1;
	for (i = 0; i < j; i++) {
		temp = s[i];
		s[i] = s[j];
		s[j] = temp;
		j--;
	}
}

int main(int argc, char* argv[]){
	FILE* input;
	FILE* output;
	char word[256];
	//checks if there is enough argumets for the function to run
	if( argc != 3 ){
		printf("Usage: %s <input file> <output file>\n", argv[0]);
		exit(EXIT_FAILURE);
	}
	//prepares to read from the input file and exits if it fails
	input = fopen(argv[1], "r");
	if( input == NULL ){
		printf("Unable to read from file %s\n", argv[1]);
		exit(EXIT_FAILURE);
	}
	//prepares to write to the output file and exits if it fails
	output = fopen(argv[2], "w");
	if( output == NULL ){
		printf("Unable to write to file %s\n", argv[2]);
		exit(EXIT_FAILURE);
	}
	//scans the file and outputs the the word in reversed order
	while( fscanf(input, " %s", word) != EOF ){
		stringReverse(word);
		fprintf(output, "%s\n", word);
	}
	//closes the file pointers to stop memory leaks
	fclose(input);
	fclose(output);
	return(EXIT_SUCCESS);
}
