#include <stdio.h>

main()
{
int provjeraJMBG(char JMBG[13]);
int ispis;
	char JMBG[13];

	printf("Upisite svoj JMBG --> ");
	scanf("%s",JMBG);
	printf("zadnja znamenka je %d\n",provjeraJMBG(JMBG));
    ispis=JMBG[12]-48;
	if(provjeraJMBG(JMBG)==ispis)
	printf("\ntocan JMBG; HVALA ! ! !\n\n");
	else
		printf("netocan JMBG\n\n");
	
}

int provjeraJMBG(char JMBG[13])
	{
int i,umnozak,suma=0,rez,ost;
char prov[12]={'7','6', '5', '4', '3', '2', '7', '6', '5', '4', '3', '2'};

for(i=0;i<12;i++){
umnozak=(JMBG[i]-48)*(prov[i]-48);
suma=suma+umnozak;
}
ost=suma%11;
rez=11-ost;



return (rez);
	}