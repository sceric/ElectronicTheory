#include "list.h"

unsigned length(list_t* head)
{
    unsigned count;
    list_t* l1;
    if (head == 0){
        return 0;
    }
    l1 = head;
    do {
        count += 1;
        l1 = l1->succ;
    } while (l1 != head);
    return count;                         
}
