#include <stdlib.h>
#include "xdoublematrix.h"

void free_double_matrix(double_matrix_t* a)
{ 
    int i;
    for (i = 0; i < a->rows; i++){            
        free(a->a[i]);    
    }
    free(a->a);
    free(a) ;         
}
