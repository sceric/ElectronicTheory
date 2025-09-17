#include <stdio.h>

main()
{
int a,*p;
short b,*g;
float c,*e;

p=&a;
g=&b;
e=&c;


printf("Upisite vrijednost za varijablu a, tipa integer");
scanf("%d", &a);


printf("Upisite vrijednost za varijablu a, tipa integer");
scanf("%d", &b);

printf("Upisite vrijednost za varijablu a, tipa integer");
scanf("%f", &c);

printf("\n");

printf("Velicina varijable tipa integer iznosi %d\n", a );
a=sizeof(*p);
printf("Velicina pokazivaca na tip integer iznosi %d\n\n", a );


printf("Velicina varijable tipa short iznosi %d\n", b);
b=sizeof(*g);
printf("Velicina pokazivaca na tip short iznosi %d\n\n", b);

printf("Velicina varijable tipa float iznosi %f\n", c);
c=sizeof(*e);
printf("Velicina pokazivaca na tip float iznosi %f\n\n", c);

}