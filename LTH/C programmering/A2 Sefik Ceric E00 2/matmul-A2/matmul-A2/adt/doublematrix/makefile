CC		= gcc
CFLAGS		= -g -Wall -pedantic -Werror -I../include -std=c99
OBJS		= read_doublematrix.o new_doublematrix.o free_doublematrix.o \
		print_doublematrix.o add.o sub.o mul.o 

lib: $(OBJS)
	ar rcv ../libadt.a $(OBJS)

clean:
	rm -f *.o 
