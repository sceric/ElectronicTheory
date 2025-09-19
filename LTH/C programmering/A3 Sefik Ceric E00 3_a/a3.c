#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdarg.h>

#include "error.h"
#include "list.h"

static void print_string(void* s)
{
	printf("%s ", (char*)s); // unnecessary cast to silence gcc.
}

int main(int argc, char** argv)
{
	list_t*		head;			// list head.
	list_t*		head2;			// secondary list head.
	list_t*		p;			// list iterator.
	int		i;			// loop index.
	char*		test = "abcdefgh";	// test string.
	char*		s;			// used for casts.


  
	head = NULL;
	head2 = NULL;

	
    transfer(&head, &head2); // nothing should happen.
   
	if (length(head) != 0)
		error("the length of an empty list is 0\n");
  
	reverse(&head);
   
	insert_last(&head, "b");

	reverse(&head);
   
	if (strcmp(head->data, "b") != 0)
		error("reverse one element failed\n");

	insert_last(&head, "c");

	reverse(&head);

	if (strcmp(head->data, "c") != 0
		|| strcmp(head->succ->data, "b") != 0)
		error("reverse two elements failed\n");

	reverse(&head);

	insert_last(&head, "d");
	insert_first(&head, "a");
	insert_last(&head, "e");
   
	print_list("list", head, print_string);

	insert_last(&head2, "f");
	insert_last(&head2, "g");
	insert_last(&head2, "h");

	transfer(&head, &head2); // transfer nodes from head2 to end of head

	if (head2 != NULL)
		error("head2 should be NULL after transfer\n");

	if (length(head) != strlen(test))	
		error("wrong length of list");

	i = 0;
	p = head;
	do {
		s = p->data;

		if (s[0] != test[i])
			error("bug detected for character '%c'", test[i]);
		p = p->succ;
		++i;
	} while (p != head);

	if (test[i] != 0)
		error("bug in detected for character '%c'", test[i]);

	print_list("string list", head, print_string);

	reverse(&head);
	reverse(&head);
	reverse(&head);

	i--;
	p = head;
	do {
		s = p->data;

		if (s[0] != test[i])
			error("bug in \"reverse\" detected for "
				"character '%c'", test[i]);
		p = p->succ;
		--i;
	} while (p != head);

	print_list("reversed string list", head, print_string);

	reverse(&head);

	printf("%s\n", (char*) take_out_first(&head));

	print_list("after remove first", head, print_string);
	reverse(&head);
	print_list("reversed string list", head, print_string);
	reverse(&head);

#if 0
	p = NULL;
	take_out_first(&p);
#endif

	s = head->data;
	remove_data(&head, s);
	print_list("after remove data", head, print_string);

	s = head->succ->succ->data;
	remove_data(&head, s);
	print_list("after remove data", head, print_string);

	remove_data_with_compare(&head, "f", (int (*)(void*, void*))strcmp);
	print_list("after remove data with compare", head, print_string);

	remove_data_with_compare(&head, "d", (int (*)(void*, void*))strcmp);
	print_list("after remove data with compare", head, print_string);

	remove_data_with_compare(&head, "c", (int (*)(void*, void*))strcmp);
	print_list("after remove data with compare", head, print_string);

	remove_data_with_compare(&head, "h", (int (*)(void*, void*))strcmp);
	print_list("after remove data with compare", head, print_string);

	free_list(&head);

	if (head != NULL)
		error("bug in \"free_list\": should set head to NULL");

	return 0;
}
