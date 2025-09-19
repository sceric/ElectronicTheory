#include <stdio.h>
#include <stdlib.h>
#include "xdoublematrix.h"

double_matrix_t* read_double_matrix(const char* file)
{
    int i, j, cols, rows;
    float sigma;
    double_matrix_t* a;   
    FILE *fp;
      
    fp = fopen(file, "r"); 
    if (fp == NULL){
        printf("Kan inte öppna file\n");
        return NULL; //avsluta program
    }
    fscanf(fp, "%d ", &rows); 
    fscanf(fp, "%d ", &cols);
    double_matrix_t* c=new_double_matrix(rows, cols);
    for( i = 0; i <rows ; i++) {   
        for(j = 0 ; j <cols ; j++){ 
            fscanf(fp, "%f", &sigma);
            c->a[i][j]=sigma;       	
        }  
    }
    return c;
    fclose(fp);                
}
