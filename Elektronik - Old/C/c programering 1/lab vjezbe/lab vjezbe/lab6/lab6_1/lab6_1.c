#include<stdio.h>

main()

{

 int i;
 int x[3];

 for (i=0;i<3;i++)
 {
 scanf("%d", &x[i]);
 }

 printf("normalan ispis brojeva:   ");
 for (i=0; i<3;i++)
 {
  printf("%d \t", x[i]);
 }
 printf("\nispis brojeva unatrag:    ");
 for (i=2; i>=0;i--)
 {
 printf("%d \t", x[i]);
 }


printf("\nbrojevi sa parnim indeksom su: ");
for (i=0; i<3; i++)
{
 if (i%2==0)
	 {
		 printf("%d \t", x[i]);
	}


}

printf("\nbrojevi sa neparnim indeksom su: ");
for(i=0;i<3;i++)
{
  if (i%2==1)
   {
	   printf("%d \t", x[i]);
   }
}
printf("\n\n");
}


