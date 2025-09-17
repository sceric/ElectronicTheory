#include <stdio.h>

main()

{
	float fSredPolje(float a[]);
	float fIspis(float b[]);
	int i;
	float k,x[10];

	for(i=0;i<10;i++)
	{
		printf("%d. element upisan u polje =  ", i+1);
	scanf("%f",&x[i]);
	}


	 k=fSredPolje(x);

	 for (i=0;i<10;i++){
		 printf("\n%d. clan polja je %3f", i+1, x[i] );
	 }


	  printf("\n\npisem %f\n\n", k);

	

}


float fSredPolje(float a[])
{
	int i, k;
	float j,temp;
		temp=0;

	k=10;
	for(i=0; i<10; i++)
	{
		
	
	if(a[i]<0)
		{
	
			a[i]=0;
			k--;

		}
	
		
		temp=temp+a[i];
		
		}
	
	
	j=temp/k;
	return(j);
	
	
}



