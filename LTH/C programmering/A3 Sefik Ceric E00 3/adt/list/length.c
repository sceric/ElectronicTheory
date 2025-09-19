#include <adt/list.h>
#include <stdlib.h>
#include <adt/error.h>

unsigned length(list_t* head)
{
    unsigned count;
    list_t* l1;
    if (head == NULL){
        return 0;
    }
    l1 = head;
    do {
        count += 1;
        l1 = l1->succ;
    } while (l1 != head);
    return count;                         
}
