#include "xdoublematrix.h"

double_matrix_t* add(double_matrix_t* a, double_matrix_t* b)
{
    int i,j;
    double_matrix_t* c = new_double_matrix(a->rows, a->cols);
    for (i = 0; i < a->rows; i++) {
        for (j = 0; j < a->cols; j ++) {
            if (a->a[i][j] == NULL || b->a[i][j] == NULL ){
                    printf("Kan inte addera matris rows\n");
                    return NULL; //eller avsluta...
                }
            c->a[i][j]=a->a[i][j]+b->a[i][j];
        }
    }
    return c;
}
