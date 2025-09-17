#include <unistd.h>
#include <stdio.h>
#include <time.h>
#include <errno.h>
#include <string.h>
#include "log.h"


int logg_mess(char *format,char *s1,char *s2)
{

  static  time_t curtime;
  static struct tm *loctime;

	curtime = time (NULL);
	loctime = localtime (&curtime);
	char* time;
	time=asctime(loctime);
	time[strlen(time)-1]='\0';

	fprintf(stdout,"%s ",time);
	if (s2==NULL)fprintf(stdout,format,s1);
	else if (s1==NULL)fprintf(stdout,format);
	else if (s2!=NULL)fprintf(stdout,format,s1,s2);
	
	return 0;
}

int logg_trim()
{
	int long ret;
 FILE *logfile;
	logfile = fopen(LOG_FILE_NAME, "r");
	if (logfile==NULL)
	{
		if (errno==2)
		{
			if (DEBUG) fprintf(stderr,"no log file, will create new\n");
			logfile = fopen(LOG_FILE_NAME, "a");
			if (logfile==NULL) {perror("error creaing new log file");return -1;}
			else {fclose(logfile);return 0;}
				
		}
		if (errno!=2) {fprintf(stderr, "other error opening logfile\n");perror("logfile");}
	
	}
	ret = fseek(logfile, 0, SEEK_END );
	if (ret!=0)	{perror("seeking logfile");fclose(logfile);return -1;}
	
	ret = ftell(logfile);
	
	if (DEBUG) logg_mess("Logfile is %i bytes \n",ftell(logfile)+1,NULL);
	fclose(logfile);
	if (ret>MAX_LOG_BYTES)
	{
		if (DEBUG) logg_mess("Rotating log\n",NULL,NULL);
		if (unlink(LOG_FILE_NAME)==-1){perror("unlinking log file");return -1;}
	}
	return 0;
}


