#include <stdio.h>

main()
{
int a,b,*p,*c;

	printf("Upisite dva cjelobrojna broja\n\n");
	scanf("%d" "%d", &a,&b);



	printf("Vrijednosti varijable prije zamjene %d  %d\n", a, b);


	
			p=&a;
			c=&b;
	
		

printf("Vrijednost varijable poslije zamjene %d  %d\n", *c, *p);

}