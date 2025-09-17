#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define N 5

void fcount(char *rec[N],int br); //zadatak 2.1
void fmin(char *rec[N],int br); //zadatak 2.2
void fmax(char *rec[N], int br); //zadatak 2.2
main()
{

char *rec[N];
char buffer[80];
int i,j,br=0;



for(i=0;i<N;i++)
{
	
gets(buffer);

if(*buffer=='0')
   break;
                     
rec[i]=(char*)malloc(strlen(buffer)+1);
strcpy(rec[i],buffer);
br++;

}    

      
		  fcount(rec,br);

                        printf("\nnakon poziva funkcije\n");   
						
          for(j=0;j<i;j++)
                 {     
                 printf("%s\n\n",rec[j]);
                                            }
		  
                        
                        printf("\n\nRecenica s najvecim brojem rijeci je %s \nRecenica s najmanjim brojem rijeci je %s\n\n",rec[0],rec[br-1]);
                      
      
						
						fmax(rec,br);
						fmin(rec,br);
						
							free(buffer);
						system("PAUSE");
     
      }
void fcount(char *rec[N], int br)
{
    int i,j;
	char *temp;
    for(i=0;i<(br-1);i++){
		for(j=i+1;j<br;j++){
		if(strlen(rec[i])<strlen(rec[j]))
		{
			temp=rec[i];
			rec[i]=rec[j];
			rec[j]=temp;
		}   
						}

						}

}

void fmax( char *rec[N], int br)
{
char *max;
int i;
max=rec[0];
for(i=1;i<br;i++)
{

if(strlen(max)<strlen(rec[i]))
	{
	
		max=rec[i];
	}

}
printf("Bez sortiranja najveca recenica je  -> %s\n", max);

}

void fmin( char *rec[N], int br)
{
char *min;
int i;
min=rec[0];
for(i=1;i<br;i++)
{

if(strlen(min)>strlen(rec[i]))
	{
	
		min=rec[i];
	}

}
printf("Bez sortiranja najmanja recenica je  -> %s\n", min);

}