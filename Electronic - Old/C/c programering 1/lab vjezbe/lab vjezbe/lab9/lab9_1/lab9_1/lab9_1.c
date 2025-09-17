#include <stdio.h>

main()

{
 int min(int a[]);
 int max(int c[]);
 int x[10];
 int i,j,z;


 printf("Upisite vrijednosti :\n\n");
 
 for(i=0;i<10;i++)
 {
 printf("Upisite %d. clan niza --> ", i+1);
 scanf("%d",&x[i]);
 }
 printf("\n");
 z=max(x);
 j=min(x);
 printf("najmanja vrijednost je: %d\n\n", j);
 printf("najveca vrijednost je: %d\n\n", z);
}



int min(int a[])
{

	int b,i;
	b=a[0];

		for(i=0;i<10;i++)
	{
		if(b>a[i])
		{
		b=a[i];
		}
		
		
	}
return(b);
}



int max(int c[])
{
int i, k;
k=c[0];

for(i=0;i<10;i++)
{

	if(k<c[i])
	{
	k=c[i];
	}


}
return(k);
}