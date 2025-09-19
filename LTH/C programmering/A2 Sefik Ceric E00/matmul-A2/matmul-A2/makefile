CC		= gcc
CFLAGS		= -g -Wall -pedantic -Werror -Iadt/include 
LDFLAGS		= -g -ladt -Ladt 
OBJS		= a2.o
PROG		= a2

assignment: $(OBJS) lib
	$(CC) $(OBJS) -o $(PROG) $(LDFLAGS) 
	./a2

lib:
	cd adt; make; cd ..  

test: assignment
	./$(PROG) > out
	diff correct out

clean:
	rm -f *.o core a2 a.out out
	cd adt; make clean; cd ..

