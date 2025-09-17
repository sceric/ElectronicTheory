#include <stdio.h>
#include <string.h>


void ispisGradjana(struct cov *p_gradjani);
int provjeraJMBG(char JMBG[13]);

struct ljudi
{
char i_p[35];
char adr[20];
char JMBG[13];
};
main()
{

	int i;
struct ljudi cov[1];

printf("Upisite svoje podatke\n");
for(i=0;i<1;i++)
{
printf("\nime i prezime --> ");
gets(cov[i].i_p);
printf("\n");
printf("adresa --> ");
gets(cov[i].adr);
printf("\n");
printf("JMBG --> ");
gets(cov[i].JMBG);
printf("\n");

}

ispisGradjana;




}


int provjeraJMBG(char JMBG[13])
{

int prov[12]={7,6,5,4,3,2,7,6,5,4,3,2};
int i, suma=0,ost,rez;
for(i=0;i<12;i++)
{
suma=suma+(JMBG[i]-48)*(prov[i]);
}
ost=suma%11;
rez=11-ost;
return rez;


}

void ispisGradjana(struct ljudi *p_gradjani)
{
	p_gradjani->JMBG;
	
	printf("%d",provjeraJMBG(p_gradjani));
	

}

