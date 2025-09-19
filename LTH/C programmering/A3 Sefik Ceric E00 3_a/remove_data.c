#include "error.h"
#include "list.h"

void remove_data(list_t** head, void* data)
{
	list_t* first = *head;
	list_t* temp = first->succ;
    if(first->succ==0){
	   free(first->data);
	   free(first);
	   return;                       
    }
	while(temp != first){		
		if(temp->data == data){
			temp->succ->pred = temp->pred;
			temp->pred->succ = temp->succ;			
			if(temp == *head && temp->succ!=0){
				*head = temp->succ;
            }
			free(temp->data);
			free(temp);
			break;
		}
		temp = temp->succ;
	}	
	error("Kan inte hitta: %s\n",first);
	return;
}
