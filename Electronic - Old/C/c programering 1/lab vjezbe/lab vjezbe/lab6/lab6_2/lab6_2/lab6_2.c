#include<stdio.h>
#include<math.h>


main()

{
	int i, j, m, n;
	int x[100][100];
	int y[100][100];

printf("unesite dimenzije matrice -->");
scanf("%d %d", &m, &n);

 printf("unesite vrijednosti polja -->\n");
 for(i=0; i<m; i++ )
	 for(j=0; j<n; j++){
		 printf("x[%d][%d] = ", i, j);
		 scanf("%d" ,&x[i][j] );
 }

  for(i=0; i<n; i++ )
	 for(j=0; j<m; j++){
		 y[i][j]=abs(x[j][i]);
 }


printf("Upisana matrica je:\n");
for(i=0; i<m; i++ ){
	printf("\n");
	 for(j=0; j<n; j++){
		 printf(" %5d ", x[i][j]);
	 }
 }

printf("\nTransponirana matrica je:\n");
for(i=0; i<n; i++ ){
	printf("\n");
	 for(j=0; j<m; j++){
		 printf(" %5d ", y[i][j]);
	 }
 }
 printf("\n");
}