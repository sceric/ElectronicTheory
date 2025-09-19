#include <adt/list.h>
#include <stdlib.h>
#include <adt/error.h>

bool remove_data_with_compare(list_t**	head, void* data,int (*compare)(void*, void*))
{
  
	list_t* first = *head;
	list_t* temp = first->succ;
	char* s = (char*)data;

	do{		
		if(compare( s,temp->data) != 0){
			temp->succ->pred = temp->pred;
			temp->pred->succ = temp->succ;			
			if(temp == *head && temp->succ!=NULL){
				*head = temp->succ;
            }
			free(temp->data);
			free(temp);
			return true;
		}
		temp = temp->succ;
	}while(temp != first);
	error("Kan inte hitta %s\n",s);
	return false;
}
