#include <stdio.h>
main()
{
	float funkcija_zenon1(float);
	float funkcija_zenon2(float, int);
	int n;
	float q;
	printf("Program izracunava geometrijski niz\n\n");

	do{
		printf("upisite broj u rasponu od -1 do 1\n q = ");
		scanf("%f",&q);
		
	} while ((q<-1)||(q>1));

	printf("\n Koliko ce clanova biti u sumi n:");
	scanf("%d",&n);
	
	printf("\n Suma geometrijskog niza je: %f", funkcija_zenon1(q));
	printf("\n Suma prvih %d clanova niza je: %f \n", n, funkcija_zenon2(q,n));
}


float funkcija_zenon1(float x)
{
float ge_niz;

ge_niz=1/(1-x);
return (ge_niz);
}


float funkcija_zenon2(float y, int m)
{
float ge_niz1, temp;
int i;
ge_niz1=1;
temp=y;
for(i=1; i<m; i++){
	ge_niz1=ge_niz1+y;
	y=y*temp;
}
return(ge_niz1);
}

