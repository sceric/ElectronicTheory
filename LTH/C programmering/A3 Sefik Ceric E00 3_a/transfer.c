#include "list.h"

void transfer(list_t** head, list_t** head2)
{
	list_t *l1 = *head;
	list_t *l2 = *head2;
	list_t *temp = l2->pred;
	
	if(l1 == 0){// first list är tom
		return;
    }
	if(l2 == 0){// andra listan är tom
		return;
    }	
	l2->pred = l1->pred;
	l1->pred = temp;
	l1->pred->succ = l2;
	temp->succ = l1;

	*head2 = 0;  // det måste vara NULL
}
