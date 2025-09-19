CC		= gcc
CFLAGS		= -g -Wall -pedantic -Werror -I../include -std=c99
OBJS		= error.o

lib: $(OBJS)
	ar rcv ../libadt.a $(OBJS)

clean:
	rm -f *.o 
