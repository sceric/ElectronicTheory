
#include <assert.h>
#include "xdoublematrix.h"

double_matrix_t* mul(double_matrix_t* a, double_matrix_t* b)
{
    int i, j, k;
    double_matrix_t* c = new_double_matrix(a->rows, b->cols);    
    for (i = 0; i <  a->rows; i++){      
        for (j = 0; j <  b->cols; j++ ){                
            for (k = 0; k < a->cols; k++ ){     
                c->a[i][j]= c->a[i][j] + a->a[i][k] * b->a[k][j];             
            }          
        }
    }
    return c;
}

