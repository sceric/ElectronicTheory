#include <adt/list.h>
#include <stdlib.h>

#include <stdio.h>

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

	list_t *temp = l2;

	do {

	  insert_last(head, temp->data);
	  temp = temp->succ;
	} while (temp != l2);

	
	*head2 = NULL;  // det måste vara NULL
}
