
#include "list.h"

void free_list(list_t** head)
{
	// varibler som vi behöver 
	list_t* l=(*head)->succ;
	list_t* n =(*head)->succ;
	list_t* first = *head;
    if (first==0){
   	   error("Kan inte freeg�ra %s\n",first);
       return;               
    }  

	while( n != *head ){    
		l = n->succ;
		free(n);
		n = l;
	}
	// radera den första
	free(first);
}
