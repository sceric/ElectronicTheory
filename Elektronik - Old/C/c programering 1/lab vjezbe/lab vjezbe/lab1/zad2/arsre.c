#include <stdio.h>

//funkcija za izracun aritmeticke sredine

float ar_sredina(float temp, float a)
{
return(temp/a);
}

//main glavna funkcija
main()
{
	int i;
	float a,b;
	float  temp =0;
	float rez;

printf("\nDobro dosli, ovaj program racuna aritmeticku sredinu");

printf("\n\nUpisite koliko brojeva zelite racunati ----->");

scanf("%f",&a);
	  for(i=0; i<a;i++)
	  {
	
		printf("Unesite %d. znak: ", i+1);
		scanf("%f", &b);
		temp = temp + b;
	
	  }

rez=ar_sredina(temp,a);

printf("\n\nAritmeticka sredina je %f\n\n\n", rez);


 
}
