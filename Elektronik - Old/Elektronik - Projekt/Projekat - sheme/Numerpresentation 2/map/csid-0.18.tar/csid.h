#define __HAVE_CSID

#define CSID_VERSION "0.1pre"

#ifndef NULL
#define NULL (void *)0
#endif

#ifndef SIGNAL_NEW_CALL
#define	SIGNAL_NEW_CALL SIGUSR1
#endif

#ifndef EOF
#define EOF -1
#endif

#ifndef NICE_VAL
#define NICE_VAL -5
#endif

#ifndef DEBUG
#define DEBUG 0
#endif

#ifndef DAEMON
#define DAEMON 0
#endif

#ifndef PID_LOC_FILE 
#define PID_LOCK_FILE	"/var/run/csid.pid"
#endif

#ifndef LOG_FILE_NAME
#define LOG_FILE_NAME "/var/log/csid"
#endif

#ifndef MAX_LOG_BYTES
#define MAX_LOG_BYTES 10000000
#endif

#ifndef     BROADCAST_PORT
#define 	BROADCAST_PORT 	1500
#endif

#ifndef 	DOLT_NUMMER_SEQ
#define	DOLT_NUMMER_SEQ	"10"
#endif

#ifndef DB_HOST
#define DB_HOST "127.0.0.1"
#endif

#ifndef DB_USER
#define DB_USER "cid"
#endif

#ifndef DB_PASSWORD
#define DB_PASSWORD "cidpasswd"
#endif

#ifndef DB_NAME 
#define DB_NAME "cid"
#endif

#ifndef DB_TABLE_BOOK
#define DB_TABLE_BOOK "book"
#endif

#ifndef DB_TABLE_CALLS
#define DB_TABLE_CALLS "calls"
#endif

#ifndef HITTA_TIMEOUT
#define HITTA_TIMEOUT 4 //sekunder
#endif

#define NO_STATUS             0
#define DOLT_NUMMER           1
#define IN_DATABASE           2
#define NOT_IN_DATABASE       3
#define IN_ENIRO              4
#define STATUS_ERROR         -1

int cleanlog(void);  //rensa log
int process_number(void); // fortsätt processa inkommande nummer från handler_new_call
int logg_trim(void); // kolla om är för stor
int logg_mess(char*,char*,char*); // logga ett meddelande
int my_getopts(int, char*[]); // parsing command line
int remove_pid(void); // ta bort pid
int handler_new_call(void); // handler for new call interrupt
void handler_exit(void); // when exit
int forked(void); // daemon is forked
int simulate_call(char*); // simulera ett inkommande samtal
int dblookup(); // sök i lokal databas
int enirohitta(); // sök i extern databas
int skicka_broadcast(char*); // udp broadcast
int dbadd(); // lägg till i lokal databas
void dumphelp(); // visa hjälp
