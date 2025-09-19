#ifndef list_h
#define list_h

#include <stdbool.h>

typedef struct list_t	list_t;

struct list_t {
	list_t*		succ;
	list_t*		pred;
	void*		data;
};

/* description of circular double-linked list package.
 *
 * an empty list is represented by NULL.
 *
 * every node in the list contains data.
 *
 * the first node is called head and its succ points to the next node as 
 * expected. the head's pred points to the last node.
 *
 */

void free_list(list_t** head);
void insert_first(list_t** head, void* data);
void insert_last(list_t** head, void* data);

unsigned length(list_t* head);

void transfer(list_t** head, list_t** head2);
/* transfer should move all nodes in head2 to the end of head and set head2
 * to NULL.
 */

void reverse(list_t** head);
/* reverse should reverse the list without allocating any new memory from the
 * heap, ie it should modify the existing list.
 */

void print_list(char* s, list_t* head, void (*print)(void*));


void* take_out_first(list_t** head);
void remove_data(list_t** head, void* data);
bool remove_data_with_compare(
	list_t**	head,
	void*		data, 
	int 		(*compare)(void*, void*)
);

#endif
