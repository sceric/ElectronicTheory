#include <adt/error.h>
#include <adt/list.h>

void remove_data(list_t** head, void* data)
{
	list_t* first = *head;
	list_t* temp = first->succ;

	while(temp != first){		
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
	}	
	error("Kan inte hitta: %s\n",s);
	return;
}
