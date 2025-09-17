/* UDP BROADCAST */
#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <netdb.h>
#include <string.h>
#include <unistd.h>
#include "broadcast.h"

#define MAXBUF 2000

#ifdef DRIVER
int main() {
  char* msg = "åäöÅÄÖ-%E5%E4%F6"a;
  return skicka_broadcast(msg);
}
#endif
//int skicka_broadcast(char* buffer,int port)
int skicka_broadcast(char* buffer)
{
  int sock, status, buflen, sinlen;
  int yes = 1;
  struct sockaddr_in sock_in;
 
  sinlen = sizeof(struct sockaddr_in);
  memset(&sock_in, 0, sinlen);
  buflen = MAXBUF;

  sock = socket (PF_INET, SOCK_DGRAM, IPPROTO_UDP);
  if (sock==-1) {printf("Couldnt create socket\n"); return -1;}
  sock_in.sin_addr.s_addr = htonl(INADDR_ANY);
  sock_in.sin_port = htons(0);
  sock_in.sin_family = PF_INET;

  status = bind(sock, (struct sockaddr *)&sock_in, sinlen);
  if (status>0) {printf("Couldnt bind socket\n");return -1;}
  
  status = setsockopt(sock, SOL_SOCKET, SO_BROADCAST, &yes, sizeof(int) );
  if (status>0) {printf("Couldnt setsockopt\n");return -1;}

  sock_in.sin_addr.s_addr=htonl(-1); /* send message to 255.255.255.255 todo?*/
  sock_in.sin_port = htons(BROADCAST_PORT);    /* port number */
  sock_in.sin_family = PF_INET;

  buflen = strlen(buffer);
  status = sendto(sock, buffer, buflen, 0, (struct sockaddr *)&sock_in, sinlen);
  if (status==0) {printf("Didnt send any data\n"); shutdown(sock,2);close(sock);return -1;}
  shutdown(sock, 2);
  close(sock);
  return 0;
}

