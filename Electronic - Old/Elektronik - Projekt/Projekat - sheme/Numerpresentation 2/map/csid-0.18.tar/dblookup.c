/* dblookup.c - Sql query for callerid. Author : Andreas Sjöholm Date: December 2004 */
/* Released under GPL.*/
/*compile options*/
/*gcc -o dblookup.o dblookup.c -I/usr/local/mysql/include/ -L/usr/local/mysql/lib -lmysqlclient -lz */
// return -1 fel
// return 0 inget resultat
// return 1 hittade

#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <stdio.h>
#include "mysql.h" 				/*Headers for MySQL */
#include "dblookup.h"


int dblookup()
 {
	
	MYSQL cid_db;
	MYSQL_RES *result;
	MYSQL_ROW row;
	char query[70];

	if (mysql_init(&cid_db)==NULL) {
		printf("mysql_init failed, check mysql server\n");
		return -1;
	}
	if (!(mysql_real_connect(&cid_db,db_host,db_user,db_password,db_name,0,NULL,0))) {
		printf("mysql_real_connect: %s\n",mysql_error(&cid_db));
		return -1;
	}
	if(!mysql_select_db(&cid_db,db_name)==0) {
		printf("mysql_select_db :%s\n",mysql_error(&cid_db));
		return -1;
	}

	sprintf(query, "SELECT Name FROM %s WHERE number='%s'",db_table_book,incomming_num);
	
	if (mysql_real_query(&cid_db,query,strlen(query))==0) { 
		result = mysql_store_result(&cid_db);
		if (result) {
				row = mysql_fetch_row(result);
			if (row==NULL) {mysql_free_result(result);mysql_close(&cid_db);return NOT_IN_DATABASE;} else {
				sprintf (callers_name, row[0]);  /* hittade ett nummer skriv till namn */
				}
		}
	}
	else {
		printf("mysql_real_query: %s\n",mysql_error(&cid_db));
		return STATUS_ERROR;
	}

	mysql_free_result(result);
	mysql_close(&cid_db);
 if (strlen(callers_name)==0) {return NOT_IN_DATABASE;} else {return IN_DATABASE;}
 return STATUS_ERROR;
}

