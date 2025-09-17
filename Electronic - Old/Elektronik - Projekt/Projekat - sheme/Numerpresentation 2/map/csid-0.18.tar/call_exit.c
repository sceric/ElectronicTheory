#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include "call_exit.h"


void handler_exit()
{
	remove_pid();
	logg_mess("csid exited normally due to signal\n",NULL,NULL);
	close(file_in);
	close(file_out);
	close(file_err);
	close(0);
	close(1);
	close(2);
	
	
exit(0);
}

int remove_pid()
{
	if (DEBUG) logg_mess("removing lock file %s\n",PID_LOCK_FILE,NULL);
	return unlink(PID_LOCK_FILE);

}
