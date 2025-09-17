#include<stdio.h>

main()


{
	int i , j , m ,n, z;
	int x[100][100];
	printf("\n\n\t*********************************************************\n");
	printf("\t********  Program racuna sumu dijagonale matrice  *******\n");
	printf("\t*********************************************************\n\n\n\n");
	
	

do{
	printf("\n\nUnesite dimenzije matrice, matrica mora biti kvadraticna ! ! ! \n");

	scanf("%d %d", &m,&n);
if(m!=n)
	printf("\n\nMorate unjeti isto stupaca i brojeva za Kvadratnu matricu");
  
}

while(m!=n);


printf("\n\nUnesite vrijednosti u polja matrice\n\n");
for (i=0; i<m; i++){
for(j=0;j<n; j++){
scanf("%d", &x[i][j]);
	}
}





printf("uneshene vrijednosti u  polja matrice su :\n\n");
for (i=0; i<m; i++){

for(j=0;j<n; j++){
	
printf("%5d", x[i][j]);

	}
	printf("\n");
}



printf("dijagonala :\n\n");
z=0;	
for(i=0; i<m; i++)
{
 printf("%d \n" , x[i][i]);
 z= z+ x[i][i];
}
  

printf("\n\nsuma brojeva u dijagonali matrice je = %d\n\n", z);

}



