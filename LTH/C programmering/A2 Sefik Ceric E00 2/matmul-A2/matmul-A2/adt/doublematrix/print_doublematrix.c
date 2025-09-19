#include <stdio.h>
#include <string.h>
#include "xdoublematrix.h"


void print_double_matrix(double_matrix_t* a, int decimals)
{
   int i,j;
   int pdec=12+decimals;
   for (i = 0; i < a->rows; i++) {
       for (j = 0; j < a->cols; j ++) {
           if (a->a[i][j]!= NULL){
               printf ("%*.*lf\t",pdec,decimals, a->a[i][j]);            
           }else{
               printf("Kan inte skriva ut matris rows\n");
               return NULL; //eller avsluta...
       }
        printf("\n");
    }
    printf("\n");
}

