/* cid_db_add.c - Sql query for callerid. Author : Andreas Sjöholm Date: December 2004 */
/* Released under GPL.*/
/*compile options example*/
/*gcc  cid_db_add -I/usr/local/mysql/include/ -L/usr/local/mysql/lib -lmysqlclient -lz */

#include "mysql.h"
#include <string.h>
#include <stdio.h>
#include "call_addto_db.h"

int dbadd() {

      MYSQL cid_db;
      char query[100];
      
      if (mysql_init(&cid_db)==NULL){
        logg_mess("Failed init database struct.\n",NULL,NULL);
        return -1;
      }
      if (!(mysql_real_connect(&cid_db,db_host,db_user,db_password,db_name,0,NULL,0))) {
        logg_mess("Connection failed. Error: %s\n",mysql_error(&cid_db),NULL);
        return -1;
      }

      if(!mysql_select_db(&cid_db,db_name)==0) {
        logg_mess("Failed to connect to Database: Error: %s\n", mysql_error(&cid_db),NULL);
        return -1;
      }

      sprintf(query,"INSERT IGNORE INTO %s values (now(),'%s','')",db_table_calls, incomming_num);
      mysql_real_query(&cid_db,query,strlen(query));
      sprintf(query,"INSERT IGNORE INTO %s values ('%s','%s')",db_table_book, incomming_num,"");
      mysql_real_query(&cid_db,query,strlen(query));
 
      mysql_close(&cid_db);
      return 0;
}
