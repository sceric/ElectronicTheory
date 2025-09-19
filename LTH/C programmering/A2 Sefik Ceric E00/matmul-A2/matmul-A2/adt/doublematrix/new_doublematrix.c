#include <stdlib.h>
#include "xdoublematrix.h"

double_matrix_t* new_double_matrix(int rows, int cols)
{
    double_matrix_t* m;
    int i;
    m = malloc(sizeof(double_matrix_t));
    m->a = malloc(rows * sizeof(double*));
    for (i=0; i< rows; i++){
        m->a[i] = calloc(cols,sizeof(double));    
    }
    m->rows=rows;
    m->cols=cols;
    return m;
}
