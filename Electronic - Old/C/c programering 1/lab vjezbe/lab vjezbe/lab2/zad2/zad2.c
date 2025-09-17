#include <stdio.h>



//funkcija "novi red"
 int i;
 int a, b[10];
void nov_red(int x)
 {
	int c;
	 for(i=1;i<10;i++){
		b[i-1]=(x%(10^i))/(10^(i-1));
		x=x-x%(10^i);
	 }
	
 }


 main()
 
 {

printf("\n\nUpisite jednu cjelobrojnu vrijednost ---->");
scanf("%d", &a);

nov_red(a);

for(i=1;i<10;i++){
printf("Broj:%d\n\n", b[i]);
} 
 }