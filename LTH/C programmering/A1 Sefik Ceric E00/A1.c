#include <stdio.h>
#include <limits.h>

#define SIZE	(1024)
#define N	(SIZE / CHAR_BIT)

int i,p,k;
int j=0;

typedef struct {
	unsigned int array[N];
} bitset_t;


void clear_bitset(bitset_t* a)
{
    i=0;   
    while(i<N){                
        a->array[i]=0;
        i++;
    }  
}


void set_bit(bitset_t* a, unsigned int pos)
{ 
    unsigned int mask = 1 << (pos%(CHAR_BIT));
    a->array[pos/(CHAR_BIT)]= a->array[pos/(CHAR_BIT)]|mask;
}


void clear_bit(bitset_t* a, unsigned int pos)
{         
    unsigned int mask = 1 << (pos%(CHAR_BIT)+1);
    a->array[pos/(CHAR_BIT)]= a->array[pos/(CHAR_BIT)]& mask;    
}


void print_bitset(char* id, bitset_t* a)
{
     printf("\n%s:",id);
     for(i=0;i<N;i++){                                 
         for(k=0;k<8;k++){
             if(((a->array[i]>>k)%2)==1){
                 printf(" %d",i*CHAR_BIT+k);
             }                                                                         
         }   
     } 
}


void bitset_union(bitset_t* a, bitset_t* b, bitset_t* c)
{
    for(i=0;i<N;i++){ 
        c->array[i]= a->array[i]|b->array[i];
    }      
}


void bitset_intersection(bitset_t* a, bitset_t* b, bitset_t* c)
{
    for(i=0;i<N;i++){ 
        c->array[i]= a->array[i]& b->array[i];
    }     
}


int main()
{
	bitset_t	a,b,c,d;

	clear_bitset(&a);
	clear_bitset(&b);
	clear_bitset(&c);

	set_bit(&a, 1);   
    set_bit(&a, 2);
	set_bit(&a, 3);
	
	set_bit(&a, 12);
	set_bit(&a, 13);
	set_bit(&a, 1021);
	set_bit(&a, 1022);
	set_bit(&a, 1023);
	print_bitset("a", &a);
 

	set_bit(&b, 2);
	set_bit(&b, 3);
	set_bit(&b, 20);
	set_bit(&b, 511);
	set_bit(&b, 512);
	print_bitset("b", &b);
    

	bitset_union(&a, &b, &c);
	print_bitset("c", &c);
 
	clear_bit(&c, 12);

	print_bitset("c", &c);

	bitset_intersection(&a, &c, &d);
	print_bitset("d", &d);
	getchar();

	return 0;
}

/* bitset-A1/correct

a: 1 2 3 12 13 1021 1022 1023 
b: 2 3 20 511 512 
c: 1 2 3 12 13 20 511 512 1021 1022 1023 
c: 1 2 3 13 20 511 512 1021 1022 1023 
d: 1 2 3 13 1021 1022 1023 

bitset-A1/makefile

C		= gcc
CFLAGS		= -g -Wall -pedantic -Werror
OBJS		= a1.o
PROG		= a1

assigmnent: $(OBJS)
	$(CC) $(OBJS) -o $(PROG)

test: $(PROG)
	./$(PROG) > out
	diff correct out

clean:
	rm -f *.o core a1 a.out out
*/









