
-----LIST H-file-----------------------------------------------------


#ifndef list_h
#define list_h

#include <stdbool.h>

typedef struct list_t	list_t;

struct list_t {
	list_t*		succ;
	list_t*		pred;
	void*		data;
};

/* description of circular double-linked list package.
 *
 * an empty list is represented by NULL.
 *
 * every node in the list contains data.
 *
 * the first node is called head and its succ points to the next node as 
 * expected. the head's pred points to the last node.
 *
 */

void free_list(list_t** head);
void insert_first(list_t** head, void* data);
void insert_last(list_t** head, void* data);

unsigned length(list_t* head);

void transfer(list_t** head, list_t** head2);
/* transfer should move all nodes in head2 to the end of head and set head2
 * to NULL.
 */

void reverse(list_t** head);
/* reverse should reverse the list without allocating any new memory from the
 * heap, ie it should modify the existing list.
 */

void print_list(char* s, list_t* head, void (*print)(void*));


void* take_out_first(list_t** head);
void remove_data(list_t** head, void* data);
bool remove_data_with_compare(
	list_t**	head,
	void*		data, 
	int 		(*compare)(void*, void*)
);

#endif





-----ERROR H-file-----------------------------------------------------

#ifndef error_h
#define error_h

char*	progname;	// program name. should be set in main from argv[0].

#define error(...)	(error(__FILE__, __LINE__, __func__, __VA_ARGS__))

void (error)(char* file, int line, const char* func, char* msg, ...);

#endif




----ERROR C-file--------------------------------------------------------------------

#include <stdarg.h>
#include <stdlib.h>
#include <stdio.h>

#include <adt/error.h>

void (error)(char* file, int line, const char* func, char* msg, ...)
{
	va_list		ap;
	static char	colon[] = ": ";

	if (progname == NULL) {
		progname = "";
		colon[0] = 0;
	}

	va_start(ap, msg);

	fprintf(stderr, "%s%serror: detected in file \"%s\", line %u"
		" in function \"%s\": ", progname, colon, file, line, func);

	vfprintf(stderr, msg, ap);

	va_end(ap);

	fputc('\n', stderr);
	exit(EXIT_FAILURE);
}



------------------------------------------------------------

#include <adt/list.h>
#include <stdlib.h>
#include <adt/error.h>

void insert_first(list_t** head, void* data)
{
  	list_t* first = *head;
	list_t* temp = calloc(1,sizeof(list_t));

	if (temp==NULL){
		error("Kan inte s‰tta in %s\n",temp);               
	}

	temp->data = data;
	
	if(first == NULL){
		first = temp;
		temp->pred = temp;		
		temp->succ = temp;	
                *head = first;
	}
	else{
	  
          temp->succ = first;
          temp->pred = first->pred; 

       	  temp->pred->succ = temp;
	  first->pred = temp;

	  *head = temp;
	}

------------------------------------------------------------

#include <adt/list.h>
#include <stdlib.h>
#include <adt/error.h>

void insert_last(list_t** head, void* data)
{
	list_t* first = *head;
	list_t* temp = calloc(1,sizeof(list_t));

	if (temp==NULL){
		error("Kan inte s‰tta in %s\n",temp);               
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

------------------------------------------------------------

#include <adt/list.h>
#include <stdlib.h>
#include <adt/error.h>
#include <stdio.h>

void print_list(char* s, list_t* head, void (*print)(void*))
{
	list_t* last = head;
	list_t* temp = head->succ;
	printf("%s: \n",s);	
	print(head->data);	
	
	while(temp != last){
		print(temp->data);
		temp = temp->succ;
	}
}

------------------------------------------------------------

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


------------------------------------------------------------

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


------------------------------------------------------------

#include <adt/list.h>
#include <stdlib.h>
#include <adt/error.h>
#include <stdio.h>

#include <stdio.h>

void reverse(list_t** head)
{

  list_t* first = *head;

  if (first != NULL && first->succ != first) {
  

    first = first->pred;
    list_t* temp = first;

    int i = 0;
    do {
       list_t* pred = temp->pred;

       temp->pred = temp->succ;
       temp->succ = pred;
       temp = pred;
       } while (temp != first);
 
    *head = first;
    
  }

     
}

------------------------------------------------------------


#include <adt/list.h>

#include <stdio.h>

void* take_out_first(list_t** head)
{
	list_t* first = *head;
	void* data = first->data;
	remove_data(head, data);
	return data;
}

------------------------------------------------------------


#include <adt/list.h>
#include <stdlib.h>

#include <stdio.h>

void transfer(list_t** head, list_t** head2)
{

	list_t *l1 = *head;
	list_t *l2 = *head2;

	
	if(l1 == NULL){// first list √§r tom
		return;
	}
	if(l2 == NULL){// andra listan √§r tom
		return;
	}	

	list_t *temp = l2;

	do {

	  insert_last(head, temp->data);
	  temp = temp->succ;
	} while (temp != l2);

	
	*head2 = NULL;  // det m√•ste vara NULL
}

------------------------------------------------------------

#include <adt/list.h>
#include <stdlib.h> 
#include <adt/error.h>

void free_list(list_t** head)
{
	// varibler som vi beh√∂ver 
	list_t* l = (*head)->succ;
	list_t* n = (*head)->succ;
	list_t* first = *head;

	if (first==NULL){
		error("Kan inte freegˆra %s\n",first);               
	}  


	while( n != *head ){    
		l = n->succ;
		free(n);
		n = l;
	}
	// radera den f√∂rsta
	free(first);
	*head=NULL;
}
