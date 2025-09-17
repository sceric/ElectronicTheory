
#include <stdlib.h>
#include <errno.h>
#include <error.h>
#include <stdio.h>
#include "call_handler.h"

int handler_new_call()
{
  number_of_calls++;
 

	incomming_num = (char *) malloc(100);
	callers_name =  (char *) malloc(100);
      status=NO_STATUS;
	
	if (incomming_num == NULL) {printf("Error on malloc incomming_num\n");return 1;}
	if (callers_name  == NULL) {printf("Error on malloc callers_name\n");free(incomming_num);return 1;}

	csi_proc_file = fopen("/proc/csi","r");
	if (csi_proc_file==NULL)
	{perror("Couldn't open /proc/csi for reading\n");free (incomming_num);free (callers_name);return 1;}
	
	if (fgets(incomming_num,50,csi_proc_file)==NULL)
	{
		printf("fgets failed, no string in proc-entry\n");
		free (incomming_num);free (callers_name);return 1;
	}

 logg_mess("(%i) New call: %s\n",number_of_calls,incomming_num);
	
	if (process_number()) printf("Process_number returned failure\n");

      fclose(csi_proc_file);
      free (incomming_num);
	free (callers_name);
	

	return 0;
}
