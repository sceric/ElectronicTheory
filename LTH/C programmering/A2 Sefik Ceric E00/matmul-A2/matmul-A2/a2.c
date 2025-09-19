#include <stdio.h>
#include <stdlib.h>
#include "adt/doublematrix.h"



int main()
{
	int			        i;
	double_matrix_t*	a;
	double_matrix_t*	b;
	double_matrix_t*	c;
	double_matrix_t*	d;
	double_matrix_t*	e;
	double_matrix_t*	f;

	a = read_double_matrix("a");
	b = read_double_matrix("b");

	if (a == NULL || b == NULL)
		return 1;

	printf("a = \n");
	print_double_matrix(a, 3);
	putchar('\n');

	printf("b = \n");
	print_double_matrix(b, 3);
	putchar('\n');

	c = mul(a, b);

	printf("c = \n");
	print_double_matrix(c, 3);
	putchar('\n');

	free_double_matrix(a);
	free_double_matrix(b);
	free_double_matrix(c);

	printf("testing huge number of read/free...");
	fflush(stdout);

	//for (i = 0; i < 1000; i++) {
//		/* this loop will likely fail if
//		 * you forget to close the file...
//		 *
//		 */
//
//		a = read_double_matrix("a");
//
//		if (a == NULL)
//			return 1;
//
//		free_double_matrix(a);
//	}

	printf("ok\n\n");
		
	d = read_double_matrix("d");
	if (d == NULL)
		return 1;

	e = add(d, d);
	f = mul(d, e);

	printf("f = \n");
	print_double_matrix(f, 1);

	free_double_matrix(d);
	free_double_matrix(e);
	free_double_matrix(f);
	return 0;
}
