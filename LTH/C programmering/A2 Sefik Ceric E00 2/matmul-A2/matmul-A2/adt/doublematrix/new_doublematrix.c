#include <stdlib.h>
#include "xdoublematrix.h"

double_matrix_t* new_double_matrix(int rows, int cols)
{
    double_matrix_t* m;
    int i;
    m = malloc(sizeof(double_matrix_t));
    if (m == NULL){
        printf("Kan inte allokera minne för matris\n");
        return NULL; //eller avsluta...
    }
    m->a = malloc(rows * sizeof(double*));
    if (m->a == NULL){
        printf("Kan inte allokera minne för matris rows\n");
        return NULL; //eller avsluta...
    }
    for (i=0; i< rows; i++){
        m->a[i] = calloc(cols,sizeof(double));    
    }
    m->rows=rows;
    m->cols=cols;
    return m;
}
