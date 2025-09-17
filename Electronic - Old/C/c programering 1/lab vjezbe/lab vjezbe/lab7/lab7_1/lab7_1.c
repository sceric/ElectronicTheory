#include <stdio.h>
#include <stdlib.h>
#include <time.h>

main()
{
int x[100][100];
int i,j,m,n;
srand((unsigned) time(0));
printf("\nOdredite velicinu vase matrice\n");

scanf("%d%d",&m,&n);

for(i=0;i<m;i++)
	{

		for(j=0;j<n;j++)
		{

		
		x[i][j]=8+rand()%6;
		}
printf("\n");
	}


	printf("Ispis vase matrice\n\n");


	for(i=0;i<m;i++)
	{
		for(j=0;j<n;j++)
		{
			printf("%5d",x[i][j]);

		}
		printf("\n");

	}












}