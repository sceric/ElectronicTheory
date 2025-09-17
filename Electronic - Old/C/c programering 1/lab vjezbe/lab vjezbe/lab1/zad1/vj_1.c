#include <stdio.h>

//Funkcija zbrajanja
 int zbroj(int x, int y)
 {
 return(x+y);
 }

 //Funkcija mnozenja
 int umnozak(int x, int y)
 {
 return(x*y);
 }

 //glavna(main) funkcija

 main()
 {
 int a,b;
 int rez_zbroj, rez_umnozak;

 printf("\nDobrodosli, ovaj program racuna zbroj i umnozak dvaju brojeva");
 printf("\n\nUpisite dva cjelobrojna broja -------->");
 scanf("%d %d", &a,&b);

 //pozivanje funkcije
rez_zbroj=zbroj(a,b);
rez_umnozak=umnozak(a,b);

printf("\n\nZbroj broja %d i broja %d iznosi %d", a,b,rez_zbroj);
printf("\n\nUmnozak broja %d i broja %d iznosi %d\n\n", a,b,rez_umnozak);


}
