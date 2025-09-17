#include <stdio.h>
#include <stdlib.h>
#include <time.h>

main()
{
int x[100][100];
int y[100][100];
int z[100][100];
int i,j,m,n,broj;

printf("\n\t\t\t\tDobro dosli ! ! !\n\nprogram izbacuje nasumicne brojeve od 8-13 i upisuje ih u obliku matrica\n\n"); 


printf("Upisite velicinu vase matrice --->\t");
scanf("%d%d", &m,&n);
srand((unsigned) time(0));

printf("\nprva matrica :\n\n");
for(i=0;i<m;i++)
	{
		for(j=0;j<n;j++)
		{
			x[i][j]=8+rand()%6;
			printf("clan matrice [%d][%d] --->\t", i,j);
			printf("%d", x[i][j]);
			printf("\n");
		}
	}



	printf("\n\ndruga matrica :\n\n");
for(i=0;i<m;i++)
	{
		for(j=0;j<n;j++)
		{
			y[i][j]=8+rand()%6;
			printf("clan matrice [%d][%d] --->\t", i,j );
			printf("%d", y[i][j]);
			printf("\n");
		}
	}



do{
printf("\n\nIzaberite racunsku operaciju za matrice --->\n\n");
printf("\n 1 za zabrajanje,\n 2 za oduzimanje,\n 3 za mnozenje");
printf("\n\n");
scanf("%d", &broj);
	if(broj>3||broj<=0)
printf("\npogresan izbor, morate odabrati broj 1 - 3 za racunsku operaciju");
}
while(broj>3||broj<=0);
switch(broj)
	{

case 1:
	printf("\nrezultat zbrajanja matrice :\n\n");
	for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
			{
				z[i][j]=x[i][j]+y[i][j];
				printf("clan matrice [%d][%d] --->\t", i,j );
				printf("%d\n", z[i][j]);
			}
		}
break;

case 2:
	printf("\nrezultat oduzimanja matrice :\n\n");
	for(i=0;i<m;i++)
	{
		for(j=0;j<n;j++)
		{
			z[i][j]=x[i][j]-y[i][j];
			printf("clan matrice [%d][%d] --->\t", i,j );
			printf("%d\n", z[i][j]);
		}
	}
break;

case 3:
 
	printf("\nrezultat mnozenja matrice :\n\n");
	for(i=0;i<m;i++)
	{
		for(j=0;j<n;j++)
		{
			z[i][j]=x[i][j]*y[j][i];
			printf("clan matrice [%d][%d] --->\t", i,j );
			printf("%d\n", z[i][j]);
		}
	}
break;

	}

printf("\n\n");
}



