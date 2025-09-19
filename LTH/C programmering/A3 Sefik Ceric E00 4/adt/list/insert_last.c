#include <adt/list.h>
#include <stdlib.h>
#include <adt/error.h>

void insert_last(list_t** head, void* data)
{
	list_t* first = *head;
	list_t* temp = calloc(1,sizeof(list_t));

	if (temp==NULL){
		error("Kan inte sätta in %s\n",temp);               
	}

	temp->data = data;
	
	if(first == NULL){
		first = temp;
		temp->pred = temp;		
		temp->succ = temp;	
                *head = first;
	}
	else{
	  list_t* last = first->pred;
	  first->pred = temp;
          temp->succ = first;
          temp->pred = last;
          last->succ = temp;

	}

}
