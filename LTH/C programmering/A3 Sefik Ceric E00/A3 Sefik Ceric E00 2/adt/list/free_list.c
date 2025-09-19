
#include "include\adt\list.h"

void free_list(list_t** head)
{
	// varibler som vi behöver 
	list_t* l->(*head)->succ;
	list_t* n = (*head)->succ;
	list_t* first = *head;
    if (first==NULL){
   	   error("Kan inte freeg�ra %s\n",first);               
    }  

	while( n != *head ){    
		l = n->succ;
		free(n);
		n = l;
	}
	*head=NULL;
	// radera den första
	free(first);
}
