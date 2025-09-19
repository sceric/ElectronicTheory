#include <adt/error.h>
#include <adt/list.h>
#include <stdlib.h>
#include <adt/error.h>

void remove_data(list_t** head, void* data)
{
	list_t* first = *head;
	list_t* temp = first->succ;

	do{		
		if(temp->data == data){
			temp->succ->pred = temp->pred;
			temp->pred->succ = temp->succ;			
			if(temp == *head && temp->succ!=NULL){
				*head = temp->succ;
            }
			free(temp->data);
			free(temp);
			break;
		}
		temp = temp->succ;
	}while(temp != first)	
	error("Kan inte hitta: %s\n",data);
	return;
}
