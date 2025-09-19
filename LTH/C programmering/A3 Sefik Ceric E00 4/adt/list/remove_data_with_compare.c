#include <adt/list.h>
#include <stdlib.h>
#include <adt/error.h>

bool remove_data_with_compare(list_t**	head, void* data,int (*compare)(void*, void*))
{
  
	list_t* first = *head;
	list_t* temp = first->succ;
	char* s = (char*)data;
	
	bool result = false;

	do{		
		if(compare( s,temp->data) != 0){
		  remove_data(head, temp->data);
		  
		  result = true;
		}
		temp = temp->succ;
	}while(!result && temp != first);

	return result;
}
