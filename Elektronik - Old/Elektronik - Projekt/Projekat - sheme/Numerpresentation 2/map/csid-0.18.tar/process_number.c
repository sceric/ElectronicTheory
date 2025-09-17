#include <stdio.h>
#include <string.h>
#include "process_number.h"

int process_number()
{

  status=NO_STATUS;
  if (!strcmp(incomming_num,DOLT_NUMMER_SEQ))
    {status=DOLT_NUMMER;}
  else
   { //inte dolt nummer
     status = dblookup();
     if (status==NOT_IN_DATABASE)
     { //inte i lokala databas
       status = enirohitta();
     }
   }
  
   switch( status )
   {
     case   IN_DATABASE :
       skicka_broadcast(callers_name);
       logg_mess("In local database: %s\n",callers_name,NULL);
       dbadd();
     break;

     case  IN_ENIRO :
       skicka_broadcast(callers_name);
       logg_mess( "In extern database:\n %s",callers_name,NULL );
       dbadd();
     break;
     
     case  DOLT_NUMMER :
       skicka_broadcast("Dolt nummer");
       logg_mess( "Dolt nummer\n",NULL,NULL);
       dbadd();
       break;

     case NOT_IN_DATABASE :
       skicka_broadcast(incomming_num);
       dbadd();
       if (DEBUG) logg_mess( "Not in any database. \n",NULL,NULL);
     break;

     case NO_STATUS :
       logg_mess( "No status. Should never come here?!\n",NULL,NULL);
       dbadd();
       skicka_broadcast(strcat(incomming_num,"\nerr__NO_STATUS"));
       
     break;

     case STATUS_ERROR :
       logg_mess( "Error from database functions\n",NULL,NULL);
       dbadd();
       skicka_broadcast(strcat(incomming_num,"\nerr_DATABASE__STATUS__ERROR\nproblably timed out"));
     break;

     default  :
       logg_mess( "Default. Shold never come here?!\n" ,NULL,NULL);
       skicka_broadcast(strcat(incomming_num,"\nerr__DEFAULT_STATUS"));
       dbadd();
       
     break;
   }     



return 0;
}
