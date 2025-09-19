#include "list.h"

void insert_last(list_t** head, void* data)
{
	list_t* first = *head;
	list_t* temp = calloc(1,sizeof(list_t));
    if (temp==0){
        error("Kan inte sätta in %s\n",temp);               
    }
	temp->data = data;
	
	if(first == 0){
		first = temp;
		temp->pred = temp;		
		temp->succ = temp;	
	}
	else{
		temp->succ = first;		
		first->pred = temp;	
		temp->pred = first->pred;
		temp->pred->succ = temp;
	}
	*head = first;
}
