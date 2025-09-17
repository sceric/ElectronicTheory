#include <stdio.h>
#include <stdlib.h>

void meni(void); 
float zbrajanje(float, float);
float oduzimanje(float,float);
float mnozenje(float,float);
float dijeljenje(float,float);


main()
{



int o;
int putz=1,puto=1,putm=1,putd=1;
float k, j;

meni();

do
{
printf("\n\nIzaberite racunsku operaciju --> ");
scanf("%d", &o);
if(o<1||o>5)
{
printf("\npogresan izbor ! ! !\n\npokusajte ponovo ..................");
}


switch(o)
{
case 1: 
	
	printf("\nIzabrali ste zbrajanje %d. put\n", putz);
	putz++;
	printf("Upisite dva broja za izracun odvojena razmakom -->");
	scanf("%f %f", &k, &j);
	printf("%.3f + %.3f = %.3f", k, j, zbrajanje(k,j));
	break;

case 2:

	printf("\nIzabrali ste oduzimanje %d. put\n", puto);
	puto++;
	printf("Upisite dva broja za izracun odvojena razmakom --> ");
	scanf("%f %f", &k, &j);
	printf("%.3f - %.3f = %.3f", k, j, oduzimanje(k,j));
	break;

case 3:

	printf("\nIzabrali ste mnozenje %d. put\n", putm);
	putm++;
	printf("Upisite dva broja za izracun odvojena razmakom --> ");
	scanf("%f %f", &k, &j);
	printf("%.3f * %.3f = %.5f", k ,j ,mnozenje(k,j));
	break;

case 4:

	printf("\nIzabrali ste dijeljenje %d. put\n", putd);
	putd++;
	printf("Upisite dva broja za izracun odvojena razmakom -->");
	scanf("%f %f", &k, &j);
	printf("%.3f / %.3f = %.5f", k ,j, dijeljenje(k,j));
	break;

}


	
}


while(o!=5);
printf("\n\n");
	exit(1);
	


}



void meni(void)
{
printf("\t\t\t---------------------------\n");
printf("\t\t\t:      1. ZBRAJANJE       :\n");
printf("\t\t\t:      2. ODUZIMANJE      :\n");
printf("\t\t\t:      3. MNOZENJE        :\n");
printf("\t\t\t:      4. DIJELJENJE      :\n");
printf("\t\t\t:      5. IZLAZ           :\n");
printf("\t\t\t---------------------------\n");
}




float zbrajanje(float p, float l)
{
float rez;
rez=p+l;
return rez;
}




float oduzimanje(float p, float l)
{
float rez;
rez=p-l;
return rez;
}


float mnozenje(float p, float l)
{
float rez;
rez=p*l;
return rez;
}

float dijeljenje(float p, float l)
{
float rez;
rez=p/l;
return rez;
}

