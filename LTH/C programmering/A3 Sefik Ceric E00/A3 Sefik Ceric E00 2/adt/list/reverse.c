#include <adt/list.h>

void reverse(list_t** head)
{
	list_t* first = first->succ;
	list_t* temp = first;
	list_t* last = temp;
	
	if(first->next == NULL){ // inget att göra
		return;
    }
	do{
		temp = first->succ;
		(*head)->succ = (*head)->pred;
		(*head)->pred = temp;
		*head = (*head)->succ;
	}while(*head != last);
	*head = last;
}
