#include <string.h>
#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <signal.h>
#include <unistd.h>
#include <errno.h>
#include <getopt.h>
#include "getopts.h"


int my_getopts(int argc, char *argv[])
{
  int o;
  struct option longOptions[] = {
    {"help", 0, 0, 'h'},
    {"simulate", required_argument, 0, 's'},
    {"version",0,0,'V'},
    {0, 0, 0, 0}
  };
  int optIndex = 0;
  
  while ((o = getopt_long (argc, argv, "s:hV", longOptions, &optIndex)) != -1)
  {
    switch (o)
    {

      case 's':
      
        simulate_call(optarg);
        exit(0);

      break;

      case 'V':
        printf("csid version %s\n",CSID_VERSION);
        exit(0);
        break;

      case 'h':
                  // Help
        dumphelp();
        exit(0);
        break;
        
        default:
             exit(-1);
          break;
    }
  }
  return 0;
}


 int simulate_call(char *simulate_this)
{
	/*
	What we doing here to simulate a call is
	1) opening the module's procfile
	2) and writing the number there
	3) get the pid of the runnig instance of csid by reading the lock file
	4) sending the pid a SIGUSR1 signal to signal new call
	*/
	FILE *procfile;
	procfile = fopen("/proc/csi", "w");
	if (procfile==NULL) {perror("Opening /proc/csi failed");exit(-1);}
	fprintf(procfile,"S%s",simulate_this);
	fclose(procfile);
	
	FILE *pid_file;
	char the_pid[10];
	int int_pid;
	pid_file = fopen(PID_LOCK_FILE, "r");
	if ((pid_file==NULL)&&(errno=2)) {printf("csid is not running. Please start it first.\n");exit(-1);}

	fgets(the_pid,10,pid_file);
	int_pid = atoi(the_pid);
	fclose(pid_file);
	kill(int_pid,SIGNAL_NEW_CALL);

	return 0;
}
void dumphelp()
{
  printf (
          "Usage: csid [OPTIONS] \n"
              "   or: csid -s [NUMBER] | --simulate [NUMBER]\n"
              "   or: csid -h | --help | -V | --version\n"
              "\nCommands:\n"
              " -s, --simulate [NUMBER]             Simulate a call from number\n"
              " -h, --help                          Display help\n"
              " -V, --version                       Display version information\n"
              "\nOptions:\n"
              " -v, --verbose                       Verbose output\n"
              "\nReport any bugs to asjoholm@kth.se\n"
              "For a detailed help use --help or see web page.\n"
         );
}
