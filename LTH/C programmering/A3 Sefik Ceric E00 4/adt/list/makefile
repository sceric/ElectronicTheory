CC		= gcc
CFLAGS		= -g -Wall -pedantic -Werror -I../include -std=c99
OBJS		= free_list.o insert_first.o insert_last.o length.o\
			print_list.o reverse.o transfer.o remove_data.o\
			remove_data_with_compare.o take_out_first.o

lib: $(OBJS)
	ar rcv ../libadt.a $(OBJS)

clean:
	rm -f *.o 
