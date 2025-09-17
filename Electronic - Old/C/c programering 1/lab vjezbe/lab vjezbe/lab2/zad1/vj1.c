#include <stdio.h>

//funkcija vracanja vrijednosti

int vrac(int x)

{
if(x>0)
{
return 1;
}
else 

if(x==0)
{
return 0;
}
else
 
if(x<0)
{
return -1;
}
}

//glavna funkcija programa
main()
{
int a;
int broj;
printf("Upisite jedan broj ---->\n");
scanf("%d",&a);

broj=vrac(a);

printf("Funkcija je vratila broj : %d\n\n" ,broj);




}