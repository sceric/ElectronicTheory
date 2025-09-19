#include <adt/list.h>
#include <stdlib.h>
#include <adt/error.h>
#include <stdio.h>

void print_list(char* s, list_t* head, void (*print)(void*))
{
	list_t* last = head;
	list_t* temp = head->succ;
	printf("%s: ",s);	
	print(head->data);	
	
	while(temp != last){
		print(temp->data);
		temp = temp->succ;
	}
}
