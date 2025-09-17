#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/resource.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <errno.h>
#include <syslog.h>
#include <signal.h>

#include "csid.h"
#include "csid_globals.h"


extern FILE *pid_lock;

extern int file_in;
extern int file_out;
extern int file_err;


int main(int argc, char *argv[])
{
  number_of_calls=0;
 
	my_getopts(argc, argv);
	

	pid_lock = fopen(PID_LOCK_FILE,"r");
	if (pid_lock!=NULL)
	{
		printf("csid already running. If not delete %s\n",PID_LOCK_FILE);
		exit(-1);
	}
	if (DEBUG) printf("Debug mode\n");
	if ((DAEMON)&&(DEBUG)) printf("Daemon mode\n");
	if ((!DAEMON)&&(DEBUG)) printf("Not daemon mode\n");

	logg_trim();

	if (!DAEMON) forked();
	if(fork()){exit(EXIT_SUCCESS);}
	
	if (!setsid()) {perror("setsid failed!");exit(-1);}
	
	if(fork()){exit(EXIT_SUCCESS);}
	int i;
	for(i=3;i<sysconf(_SC_OPEN_MAX);i++)
	{
		close(i);
	}

	umask(0);

	
	int file_dd;
	// redirecting stdin stdout stderr
	file_in=open("/dev/null", O_RDONLY);
	if (file_in==-1) perror("Error opening new stdin");
	file_dd=dup2(file_in, 0);
	if (file_dd==-1) perror("Error directing new stdin");

	file_out=open(LOG_FILE_NAME, O_WRONLY|O_CREAT|O_APPEND);
	if (file_out==-1) perror("Error opening new stdout");
	file_dd=dup2(file_out, 1);
	if (file_dd==-1) perror("Error directing new stdout");

	file_err=open(LOG_FILE_NAME, O_WRONLY|O_CREAT|O_APPEND);
	if (file_err==-1) perror("Error opening new stdout");
	file_dd=dup2(file_err, 2);
	if (file_dd==-1) perror("Error directing new stdout");

	
	chdir("/");

	
	alarm(0);
	
	forked();
	return 0;
}

