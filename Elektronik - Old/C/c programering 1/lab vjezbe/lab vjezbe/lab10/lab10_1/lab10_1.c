#include<stdio.h>
#include<time.h>
#include<stdlib.h>

#define S 26

int main()
{
	int slova[S]={0};
	int i, br;
	do
	{
		printf("Upisite broj iz intervala 100-1000");
		scanf("%d",&br);
	}while(!(br>=100 && br<=1000));
	srand ((unsigned)time(NULL));
	for(i=0;i<br;i++)
		++ slova[(int)(rand()/(RAND_MAX+1.)*S)];
	for(i=0;i<S;i++)
		printf("%-9c%-4d\n",'a'+i,slova[i]);
	return 0;
}