#include <signal.h>

#include <error.h>
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/resource.h>
#include <unistd.h>
#include <string.h>
#include "forked.h"

int forked(void)
{
  
      sigset_t mask_sigset;
	if (setpriority (PRIO_PROCESS, 0, NICE_VAL)) perror("Setting priority of child");
	
	
	if (sigfillset(&mask_sigset)) perror("sigfillset");
	if (sigdelset(&mask_sigset,SIGNAL_NEW_CALL))perror("sigdelset1");
	if (sigdelset(&mask_sigset,SIGINT))perror("sigdelset2");
	if (sigdelset(&mask_sigset,SIGQUIT))perror("sigdelset3");
	if (sigdelset(&mask_sigset,SIGTERM))perror("sigfillset4");
	if (signal(SIGNAL_NEW_CALL, &handler_new_call)==SIG_ERR)
	{
		printf("creating handler SIGNAL_NEW_CALL failed, exiting\n");
		exit(-1);
	}
	
	if (signal(SIGINT, &handler_exit)==SIG_ERR) printf("error creating handler SIGINT failed.Countinueing anyway\n");
	if (signal(SIGQUIT, &handler_exit)==SIG_ERR) printf("error creating handler SIGUIT failed.Countinueing anyway\n");
	if (signal(SIGTERM, &handler_exit)==SIG_ERR) printf("error creating handler SIGTERM failed.Countinueing anyway\n");


	pid_lock=NULL;
	pid_lock = fopen(PID_LOCK_FILE,"r");
	if (pid_lock==NULL)
	{
		if (errno==2) {  // no such file or directory
			pid_lock = fopen(PID_LOCK_FILE,"w");
			if (pid_lock==NULL)
			{
				printf("Couldnt open pid_lock file for writing, exiting: ");
				printf("%s\n",strerror(errno));
				exit(-1);
			}
			fprintf(pid_lock,"%i\n",getpid());
			fclose(pid_lock);
		} else
		{
			printf("Error pid_lock file: %s\n",strerror(errno));
			fclose(pid_lock);
		}
			
	} else
	{
		// would never happen since we did the check earlier
		printf("csid already running. If not, delete pidfile\n");
		fclose(pid_lock);
		exit(-1);
	}

	csi_proc_file = fopen("/proc/csi","w");
	if (csi_proc_file==NULL)
	{
		printf("Is the module loaded? Couldn't open /proc/csi for writing.\n%s\nExiting\n",strerror(errno));
		handler_exit();
	} else
	{
		if (DEBUG) logg_mess("Sending pid to /proc/csi\n",NULL,NULL);
		char mypid[7];
		sprintf(mypid,"%i",getpid());
		fprintf(csi_proc_file,"%s",mypid);
		fclose(csi_proc_file);
	}
	
	if (DEBUG) logg_mess("New csid started with pid %i and nice %i\n",getpid(),getpriority(PRIO_PROCESS,0));

 snprintf(db_host,17,"%s",DB_HOST);
 snprintf(db_user,8,"%s",DB_USER);
 snprintf(db_password,16,"%s",DB_PASSWORD);
 snprintf(db_name,8,"%s",DB_NAME);
 snprintf(db_table_book,8,"%s",DB_TABLE_BOOK);
 snprintf(db_table_calls,8,"%s",DB_TABLE_CALLS);
 

	//finally we can rest waiting for call
	if (DAEMON) while(1) {sigsuspend(&mask_sigset);}
	else        while (1) {sleep(1);}
		
return -1;
}
