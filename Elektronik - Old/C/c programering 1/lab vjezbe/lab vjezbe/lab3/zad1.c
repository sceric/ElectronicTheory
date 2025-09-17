#include <stdio.h>
#include <stdlib.h>
#include <time.h>
main()
{
int a, broj;

printf("Upisite broj do kojeg ce se izvrsiti slucajni --->" );
scanf("%d",&a);

srand((unsigned)time(0));

broj=rand()%a;

printf("broj je %d\n\n", broj);
}