#include<stdlib.h>
#include<stdio.h>

int main(void) {
	printf("%d\n", getValue(3, 13, 5));
}

static int getValue(int a, int b, int n) {
	int x, c;
	printf("arrive: a = %d b = %d", a, b);
	c = (a+b)/2;
	if (c*c <= n) {
		x = c;
	} else {
		x = getValue(a, c-1, n);
	}
	printf("depart: a = %d b = %d", a, b);
	return(x);
}
