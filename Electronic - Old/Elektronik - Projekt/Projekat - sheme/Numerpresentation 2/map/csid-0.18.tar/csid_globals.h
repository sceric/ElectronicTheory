

FILE *csi_proc_file; // the proc file from module
FILE *pid_lock;

int file_in;
int file_out;
int file_err;


int status;             // the status of the incomming number, dolt, local, extern database etc
int number_of_calls;
char *incomming_num;    // the incomming number
char *callers_name;     //  lookup from local database
char *eniro_hitta;      // lookup from internet

char db_host[17];
char db_user[8];
char db_password[16];
char db_name[8];
char db_table_book[8];
char db_table_calls[8];