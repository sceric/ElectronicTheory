CC		= gcc
CFLAGS		= -g -Wall -pedantic -Werror -Iadt/include -std=c99
LDFLAGS		= -g -ladt -Ladt 
A		= 3
OBJS		= a$(A).o
PROG		= a$(A)

assignment: $(OBJS) lib
	$(CC) $(OBJS) -o $(PROG) $(LDFLAGS) 
	./$(PROG)

lib:
	cd adt; make; cd ..  

test: assignment
	./$(PROG) 

clean:
	rm -f *.o core a? a.out out
	cd adt; make clean; cd ..

