#ifndef double_matrix_h
#define double_matrix_h

typedef struct double_matrix_t double_matrix_t;

double_matrix_t* read_double_matrix(const char* file);
double_matrix_t* new_double_matrix(int rows, int cols);
void free_double_matrix(double_matrix_t* a);
void print_double_matrix(double_matrix_t* a, int decimals);
double_matrix_t* add(double_matrix_t* a, double_matrix_t* b);
double_matrix_t* sub(double_matrix_t* a, double_matrix_t* b);
double_matrix_t* mul(double_matrix_t* a, double_matrix_t* b);

#endif
