#include <stdio.h>
#include <math.h>

main()

{
int m, n, i, j;
int x[100][100];
int y[100][100];

printf("Odredite velicinu matrice");

scanf("%d %d", &m, &n);

printf("matrica x[%d][%d]\n\n", m,n);

printf("Upisite vrijednosti polja --->\n\n");

for(i=0;i<m; i++){
for(j=0;j<n;j++){
		printf("polje matrice x[%d][%d]= ", i , j);
		scanf("%d", &x[i][j]);
}
}

for(i=0;i<m;i++){
	for(j=0;j<n;j++){
		y[i][j]=abs(x[i][j]);


	}
}


printf("\n\nUnesena matrica : \n ");
for(i=0; i<m; i++){
	printf("\n");
for(j=0; j<n;j++){
	printf("%5d", x[i][j]);
	
}
}

printf("\n\nTransponirana matrica : \n");
for(i=0; i<n; i++){
printf("\n");
	for(j=0; j<m; j++){
printf("%5d",  y[j][i]);

	}

}


printf("\n\n");

}