#include <adt/list.h>

void* take_out_first(list_t** head)
{
	list_t* first;
	void* data = first->data;
	remove_data(head,data);
	return data;
}
