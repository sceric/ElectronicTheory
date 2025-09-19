#include <adt/list.h>

#include <stdio.h>

void* take_out_first(list_t** head)
{
	list_t* first = *head;
	void* data = first->data;
	remove_data(head, data);
	return data;
}
