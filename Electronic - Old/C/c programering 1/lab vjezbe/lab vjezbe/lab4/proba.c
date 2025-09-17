#include <stdio.h>

main()

{
	
	
	int a;
	int	i=0;
	int temp_par=0;
	int temp_nepar=0;

	do
	{

	printf("\nUpisite broj ---->\a");
	scanf("%d",&a);

	if(a%2==0)
	{
	temp_par=temp_par+a;
	}

	else

	if(a%2>0)
			{
			if(temp_nepar==0)
				{
			    temp_nepar=temp_nepar+a;
				}
			else
				{
				temp_nepar=temp_nepar*a;
				}
			}



i++;
	}while(a!=0);
printf("Upisali se nulu\n\n");
printf("Suma parnih brojeva je: %d\n\n", temp_par);
printf("Produkt neparnih brojeva je: %d\n\n", temp_nepar);
}