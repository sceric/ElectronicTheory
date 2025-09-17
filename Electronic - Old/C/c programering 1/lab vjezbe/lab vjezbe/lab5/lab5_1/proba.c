#include <stdio.h>

main()


{
	int x, x_5,y,z;
	int temp=0;
	int br_5=0;
	printf("Program posebno zbraja samo brojeve 5 i vece, i sve druge zajedno \nUpisite brojeve -->");
	
	
	for(z=0; z<5; z++)
	{
    scanf("%d", &y);
	
	if (y>=5){
	x_5=y+br_5;
	br_5=x_5;
	printf("zbroj brojeva 5 ili vecih iznosi ---> %d\n\n",x_5);}
	else 
	{
	x=y+temp+br_5;
	
	temp=0;
	temp=x;

	printf("zbroj svih brojeva je ---> %d\n", x);

	}
	printf("Upisite brojeve -->");
	}
}