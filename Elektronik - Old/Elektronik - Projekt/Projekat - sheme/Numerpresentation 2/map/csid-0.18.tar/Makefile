#change DEBUG or not. Perhaps also change libs path

DEFINES= -DDEBUG -DDAEMON -DMAX_LOG_BYTES=1500000
OPT= -O2 -march=i686
MYSQL_LIBS= -L/usr/local/mysql/lib -lmysqlclient -lz -lcurl
WARNINGS = -Wall

objects = csid.o  getopts.o forked.o call_handler.o call_exit.o log.o process_number.o dblookup.o hitta.o broadcast.o call_addto_db.o

csid : $(objects) csid.h
	gcc $(DEFINES) $(WARNINGS) -o csid $(objects) $(MYSQL_LIBS) $(OPT)

getopts.o : getopts.c
	gcc $(WARNINGS) -c getopts.c $(DEFINES) $(OPT)

forked.o : forked.c
	gcc $(WARNINGS) -c forked.c $(DEFINES) $(OPT)
call_handler.o : call_handler.c
	gcc $(WARNINGS) -c call_handler.c $(DEFINES) $(OPT)
call_exit.o : call_exit.c
	gcc $(WARNINGS) -c call_exit.c $(DEFINES) $(OPT)
log.o : log.c
	gcc $(DEFINES) $(WARNINGS) -c log.c  $(OPT)
csid.o : csid.c
	gcc $(DEFINES) $(WARNINGS) -c csid.c $(OPT)
process_number.o : process_number.c
	gcc $(DEFINES) $(WARNINGS) -c process_number.c $(OPT)
dblookup.o : dblookup.c
	gcc $(DEFINES) $(WARNINGS) -c dblookup.c -I/usr/local/mysql/include $(OPT)
hitta.o : hitta.c
	gcc $(DEFINES) $(WARNINGS) -c hitta.c $(OPT)
broadcast.o : broadcast.c
	gcc $(DEFINES) $(WARNINGS) -c broadcast.c $(OPT)
call_addto_db.o : call_addto_db.c
	gcc $(DEFINES) $(WARNINGS) -c call_addto_db.c -I/usr/local/mysql/include $(OPT)

clean :
	rm -rf $(objects) csid
tmp_clean :
	rm -rf ./*~

