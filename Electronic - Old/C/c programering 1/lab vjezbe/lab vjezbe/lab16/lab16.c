#include<stdio.h>
#include<string.h>
#include<stdlib.h>

void sort(char *str[10]);

main(){
int i=0,j;
char *str[10];
char buffer[80];

printf("****Upisite string****");
printf("\n");
while(i<3)
{
gets(buffer);

*(str+i)=(char*)malloc (strlen(buffer)+1);
strcpy(*(str+i),buffer);
//str[i]=strdup(buffer);
i++;
}


printf("\n");
j=0;
while(j<3){
sort(str);

	printf("%s\n",str[j]);
j++;}

free(buffer);

}



void sort(char *str[10])
{
char *temp;
int i,j;

for(i=0;i<2;i++)

	for(j=i+1;j<3;j++)


	if(strlen(str[i])<strlen(str[j]))
		
		{

			temp=str[i];
			str[i]=str[j];
			str[j]=temp;

			}


}