#include <adt/list.h>
#include <stdlib.h>

void transfer(list_t** head, list_t** head2)
{
	list_t *l1 = *head;
	list_t *l2 = *head2;

	
	if(l1 == NULL){// first list är tom
		return;
	}
	if(l2 == NULL){// andra listan är tom
		return;
	}	

	list_t *temp = l2->pred;
	l2->pred = l1->pred;
	l1->pred = temp;
	l1->pred->succ = l2;
	temp->succ = l1;

	*head2 = NULL;  // det måste vara NULL
}
