#include <stdio.h>

main()
{

	int kvad(int);  
	int w,i,x[20]={0},j=0;	
				
    FILE *fp;
	FILE *ispis;


  ispis=fopen("ispis.txt","w");
  if((fp=fopen("broj.txt","r"))==NULL)
        
        printf("dokument nije otvoren\n");
    else
        printf("dokument je otvoren\n");
    printf("ispis .....\n");
    printf("\n");

	while((fscanf(fp,"%d",&i))!=EOF){
            printf("kvadrat broja %d iznosi %d\n",i,kvad(i));
                printf("\n");
                   }
    fclose(fp);
    

    fp=fopen("broj.txt","r");
	while((fscanf(fp,"%d",&j))!=EOF)
	{
		while(j>0)
		{
     x[j%10]++;
	 j=j/10;
		}

	}

	

      
		for(w=0;w<10;w++){
		printf("\nbroj %d nalazi se u ulaznoj datoteci %d puta",w,x[w]);
		fprintf(ispis,"\nbroj %d nalazi se u ulaznoj datoteci %d puta",w,x[w]);
		}
	
     
		fclose(fp);
		fclose(ispis);
       

}



int kvad(int x)
{
int rez;
rez=x*x;
return rez;
}



