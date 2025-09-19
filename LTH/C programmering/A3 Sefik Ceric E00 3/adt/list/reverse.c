#include <adt/list.h>
#include <stdlib.h>
#include <adt/error.h>

void reverse(list_t** head)
{
	list_t* first;
	list_t* temp = first;
	list_t* last = temp;
	
	if(first == NULL){ // inget att göra
		return;
	}

	if(first->succ == NULL)
		return;
	
	first = first->succ;

	do{
		temp = first->succ;
		(*head)->succ = (*head)->pred;
		(*head)->pred = temp;
		*head = (*head)->succ;
	}while(*head != last);
	*head = last;
}
