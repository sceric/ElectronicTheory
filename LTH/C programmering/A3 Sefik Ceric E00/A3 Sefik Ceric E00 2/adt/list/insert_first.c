#include <adt/list.h>

void insert_first(list_t** head, void* data)
{
	list_t* first = *head;
	
	if(first == NULL){ // första nod här
		first = calloc(1,sizeof(list_t));
        if (first==NULL){
   	        error("Kan inte s�tta in %s\n",first);               
        } 		
		first->data = data;
		first->succ = first;
		first->pred = first;
	}else 
        {// det är inte första nod
			
		list_t* temp = calloc(1,sizeof(list_t));
        if (temp==NULL){
   	        error("Kan inte s�tta in %s\n",temp);               
        }
		temp->data = data;
		
		first->pred = temp;
		first = temp;
		
		temp->succ = first;
		temp->pred = first->pred;
		temp->pred->succ = temp;
	} 
	*head = first; // gör så att original listan pekar på den nya
}
