#include <stdio.h>
main()

{
int x[100][100];
int m,n,i,j,z,temp;

printf("\nUnesite velicinu matrice\n\n");
scanf("%d %d",&m,&n);

printf("\nUnesite vrijednosti u polja\n\n");
for(i=0;i<m;i++){
	
	for(j=0;j<n;j++){

scanf("%d", &x[i][j]);
	}
}
printf("\n\n");
for(i=0;i<m;i++){
	
	for(j=0;j<n;j++){

printf(" %d ", x[i][j]);
	}
	printf("\n");
}



printf("\n\nparni -->\t");


	for (i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
			{
				
			z=0;
			z=z+x[i][j];
				if(z%2==0)
				{
					printf(" %d ",z);
				
				}
			}
		}


			
printf("\n\nneparni -->\t");
	
		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
			{
				z=0;
				z=z+x[i][j];
				if(z%2!=0)
				{
				printf(" %d ",z);
				
				}

			}
		}
	

		printf("\n\nSuma parnih ---> ");

temp=0;
		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
			{
				z=0;
				z=z+x[i][j];
			
				if(z%2==0)
					{
						temp=temp+z;
					}
			}
				
			
		}

				printf("%d" ,temp);
		

		printf("\n\nSuma neparnih --->");

temp=0;
		for(i=0;i<m;i++)
		{
			for(j=0;j<n;j++)
			{	
				z=0;
				z=z+x[i][j];
				if(z%2!=0)
				{
				temp=temp+z;
				}
				
			}
		}


			
				printf("%d",temp);
	


		
	printf("\n\n");
	
}
