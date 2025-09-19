#include <adt/error.h>
#include <adt/list.h>
#include <stdlib.h>
#include <adt/error.h>

#include <stdio.h>

void remove_data(list_t** head, void* data)
{
	list_t* first = *head;
	list_t* temp = first;

	bool done = false;

	do{		
	  if(temp->data == data){
	    temp->succ->pred = temp->pred;
	    temp->pred->succ = temp->succ;			
	    if(temp == *head ){
	      first = temp->succ;
	    }
	    free(temp);
	    done = true;
	  }
	  temp = temp->succ;
	}while(!done && temp != first);

	*head = first;
	return;
}
