// requires libcurl    -lcurl
// wap.eniro.se
// return codes obsolete
// return 0 - found match
// return -1 - no match
// return -2 - error sending request

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <curl/curl.h>
#include <curl/types.h>
#include <curl/easy.h>

#include "hitta.h"

#ifdef HITTA_DRIVER

char *incomming_num;
int main(int argc, char *argv[])
{

  if (argc <2) {printf("Syntax: %s [nummer]\n",argv[0]);exit(-1);}
  if (DEBUG) printf("Slår upp %s\n",argv[1]);
  incomming_num=argv[1];
  return enirohitta();
}
#else
#define HITTA_DRIVER 0
#endif


int detag(char*, int, char*);

 struct MemoryStruct
{
  char *memory;
  size_t size;
};

  void *myrealloc(void *ptr, size_t size)
{
  if(ptr) return realloc(ptr, size);
  else return malloc(size);
}

  size_t WriteMemoryCallback(void *ptr, size_t size, size_t nmemb, void 
      *data)
{
  register int realsize = size * nmemb;
  struct MemoryStruct *mem = (struct MemoryStruct *)data;
  mem->memory = (char *)myrealloc(mem->memory, mem->size + realsize +
      1);
  if (mem->memory) {
    memcpy(&(mem->memory[mem->size]), ptr, realsize);
    mem->size += realsize;
    mem->memory[mem->size] = 0;
  }
  return realsize;
}

  //int enirohitta(char* eniro_hitta, char* nummer)
  int enirohitta()
{
  char *url;
  url = (char *) malloc(150);
  if (url == NULL) {fprintf(stderr,"Error on malloc url\n");return STATUS_ERROR;}

      
      
  int ret;
  ret=-3;
  sprintf(url,"http://wap.eniro.se/xhtml/privatpersoner/show.jsp?search_word=%s&where=&from=1&similar=&id=%s",incomming_num,(incomming_num)+1);
      // if (DEBUG) fprintf(stderr, "%i : url: %s\n",__LINE__,url);
      
  CURL *curl_handle;
  char error_msg[CURL_ERROR_SIZE];
  struct MemoryStruct chunk;
  chunk.memory=NULL; /* we expect realloc(NULL, size) to work */
  chunk.size = 0;    /* no data at this point */


  curl_global_init(CURL_GLOBAL_ALL);
  curl_handle = curl_easy_init();
  curl_easy_setopt(curl_handle, CURLOPT_URL, url);
  curl_easy_setopt(curl_handle, CURLOPT_ERRORBUFFER, &error_msg);
  curl_easy_setopt(curl_handle, CURLOPT_TIMEOUT, (long) HITTA_TIMEOUT);
  curl_easy_setopt(curl_handle, CURLOPT_CONNECTTIMEOUT, (long) HITTA_TIMEOUT);
  curl_easy_setopt(curl_handle, CURLOPT_FAILONERROR, 1);
  curl_easy_setopt(curl_handle, CURLOPT_TCP_NODELAY, (long) 1);
  curl_easy_setopt(curl_handle, CURLOPT_WRITEFUNCTION, WriteMemoryCallback);
  curl_easy_setopt(curl_handle, CURLOPT_WRITEDATA, (void *)&chunk);
  curl_easy_setopt(curl_handle, CURLOPT_USERAGENT, "Mozilla/4.0");
  curl_easy_setopt(curl_handle, CURLOPT_AUTOREFERER, "http://http://wap.eniro.se/xhtml/?");
  curl_easy_setopt(curl_handle, CURLOPT_REFERER, "http://wap.eniro.se/xhtml/?");
  curl_easy_setopt(curl_handle, CURLOPT_FOLLOWLOCATION, 1);
  if (curl_easy_perform(curl_handle)!=0) {printf("Error sending request to eniro: %s\n",error_msg,NULL); return STATUS_ERROR;}
  curl_easy_cleanup(curl_handle);

  char *newstring;
  newstring = (char *) malloc(chunk.size);
  if (url == NULL) {fprintf(stderr,"Error on malloc newstring\n");return STATUS_ERROR;}
      
  if (HITTA_DRIVER && DEBUG) printf("%s",chunk.memory);
 
    
  ret = detag(chunk.memory,chunk.size,newstring);

  if (HITTA_DRIVER) printf("%s",newstring);
  if (!HITTA_DRIVER) sprintf(callers_name,newstring); // this will copy the result to the char* we was called with


  free(chunk.memory);
  free(url);
  free(newstring);

      //if (DEBUG) printf("Leaving enirohitta\n");



  return ret;
}
int detag(char* string, int size,char* newstring)
{
  char tkn;
  int flag=1;  /* flag = 0 means we are inside a <   >  */
  int pos=0;
  int pos2=0;
      
      
  while(size--)
  {
    tkn = string[pos++];
    if(flag && tkn == '<')
      flag = 0;
    else if(!flag && tkn == '>')
      flag = 1;
    else if(flag)
      newstring[pos2++]=tkn;

  }
  if (HITTA_DRIVER && DEBUG) printf("HERE%s\n",newstring);
  pos=0;
  while(pos2--) {
    if (pos++>22) newstring[pos-24]=newstring[pos];
  }
  if (HITTA_DRIVER && DEBUG) printf("HERE2%s\n",newstring);

  pos2=-1;
  while(pos--) {
    if (newstring[++pos2] == '\n') flag++;
    if (flag > 4) {newstring[pos2++] ='\n';newstring[pos2] ='\0';pos=0;}
  }
  if (HITTA_DRIVER && DEBUG) printf("HERE3%s\n",newstring);
  
  char* point;
  pos=-1;
  if (DEBUG && HITTA_DRIVER) printf("%s\n",newstring);
  while(pos2--) {
    pos++;
    if (newstring[pos] == '&'){
      newstring[pos] = '|';
      newstring[pos+1] = '|';
      newstring[pos+2] = '|';
      newstring[pos+5] = '|';
      point = strstr(newstring,"p;"); if (point!=NULL){*point++='o';*point++=' ';}
      point = strstr(newstring,"C5"); if (point!=NULL){*point++='Å';*point++='|';}
      point = strstr(newstring,"C4"); if (point!=NULL){*point++='Ä';*point++='|';}
      point = strstr(newstring,"D6"); if (point!=NULL){*point++='Ö';*point++='|';}
      point = strstr(newstring,"E5"); if (point!=NULL){*point++='å';*point++='|';}
      point = strstr(newstring,"E4"); if (point!=NULL){*point++='ä';*point++='|';}
      point = strstr(newstring,"F6"); if (point!=NULL){*point++='ö';*point++='|';}
      point = strstr(newstring,"E9"); if (point!=NULL){*point++='é';*point++='|';}
    }
  }
  newstring[++pos]='\0';
  char *string2;
  string2 = (char *) malloc(pos+5);
  if (string2 == NULL) {fprintf(stderr,"Error on malloc string2\n");return STATUS_ERROR;}
  pos2=-1;
  flag=0;
      
  while(newstring[++pos2]!='\0') {
    if (newstring[pos2] != '|') string2[flag++] = newstring[pos2];
            
  }
  string2[flag] ='\0';
  sprintf(newstring,string2);
  free(string2);
  point = strstr(newstring, "Tyvärr");
  if (point!=NULL) {
    sprintf(newstring,"Ingen träff!\n");
    return NOT_IN_DATABASE;
  } else {return IN_ENIRO;}

  return STATUS_ERROR;
      
      
}
