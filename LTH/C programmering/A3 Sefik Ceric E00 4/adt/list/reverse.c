#include <adt/list.h>
#include <stdlib.h>
#include <adt/error.h>

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
