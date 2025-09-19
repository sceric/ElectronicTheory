#include <adt/list.h>

void insert_first(list_t** head, void* data)
{
	list_t* first = *head;
	
	if(first == NULL){ // första nod här
		first = calloc(1,sizeof(list_t));		
		first->data = data;
		first->succ = first;
		first->pred = first;
	}else 
        {// det är inte första nod
			
		list_t* temp = calloc(1,sizeof(list_t));
		temp->data = data;
		
		first->pred = temp;
		first = temp;
		
		temp->succ = first;
		temp->pred = first->pred;
		temp->pred->succ = temp;
	} 
	*head = first; // gör så att original listan pekar på den nya
}
