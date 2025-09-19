#include "list.h"

bool remove_data_with_compare(list_t**	head, void* data,int (*compare)(void*, void*))
{
  
	list_t* first = *head;
	list_t* temp = first->succ;
	
     if(first->succ==0){
	    free(first->data);
	    free(first);
	    return;
     } 
	
	 while(temp != first){		
		if(compare(first,temp->data) != 0){
			temp->succ->pred = temp->pred;
			temp->pred->succ = temp->succ;			
			if(temp == *head && temp->succ!=0){
				*head = temp->succ;
            }
			free(temp->data);
			free(temp);
			return true;
		}
		temp = temp->succ;
	}
	error("Kan inte hitta %s\n",data);
	return false;
}
