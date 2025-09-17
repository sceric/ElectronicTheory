#include<stdio.h>

struct automobil
{
char marka[20];
char tip[20];
int cijena;
}auti[10];

void fsort(void);
void cit(void);

////////////////////////////////////////////////////////////////////////////////
main()
{
	int i,j,broj=0,nas=0;
	FILE *fp,*tmp;
	
		printf("koliko automobila zelite dodati u listu:");
	scanf("%d",&broj);
	
	tmp=fopen("br","rb");
	fread(&nas,sizeof(int),1,tmp);
	fclose(tmp);
	
	   nas=broj+nas; //dodavanje broja za datoteku
	   
    tmp=fopen("br","wb");
    fwrite(&nas,sizeof(int),1,tmp);
    fclose(tmp);

	
	for(i=0;i<broj;i++){
printf("\nupisite marku -->");
scanf("%s",&auti[i].marka);

printf("\nupisite tip -->");
scanf("%s",&auti[i].tip);

printf("\nupisite cijenu -->");
scanf("%d",&auti[i].cijena);
	}

fp=fopen("auti", "ab");
for(j=0;j<broj;j++)
{
fwrite(&auti[j].marka,sizeof(char),20,fp);
fwrite(&auti[j].tip,sizeof(char),20,fp);
fwrite(&auti[j].cijena,sizeof(int),1,fp);
}
fclose(fp);

fsort();
cit();

system("PAUSE");

}
////////////////////////////////////////////////////////////////////////////////

void fsort(void)
{
FILE *fp,*tmp;
int i,j,temp,nas1;
char temp1[20],temp2[20];

tmp=fopen("br","rb");
fread(&nas1,sizeof(int),1,tmp);
fclose(tmp);


fp=fopen("auti","rb");

for(i=0;i<nas1;i++)
{
fread(&auti[i].marka,sizeof(char),20,fp);
fread(&auti[i].tip,sizeof(char),20,fp);
fread(&auti[i].cijena,sizeof(int),1,fp);
}
fclose(fp);

for(i=0;i<(nas1-1);i++)
for(j=(i+1);j<nas1;j++)
if(auti[i].cijena<auti[j].cijena)
{
temp=auti[i].cijena;
strcpy(temp1,auti[i].marka);
strcpy(temp2,auti[i].tip);

auti[i].cijena=auti[j].cijena;
strcpy(auti[i].marka,auti[j].marka);
strcpy(auti[i].tip,auti[j].tip);

auti[j].cijena=temp;
strcpy(auti[j].marka,temp1);                                 
strcpy(auti[j].tip,temp2);   
                             
    
    }

puts("**************************");
puts("***Najskuplji automobil***");
puts("**************************");
printf("\nMarka --> %s", auti[0].marka);
printf("\nTip --> %s",auti[0].tip);
printf("\nCijena --> %d\n",auti[0].cijena);
}
void cit(void)
{
     int i;
     FILE *fp;
     fp=fopen("br","rb");
     fread(&i,sizeof(int),1,fp);
     fclose(fp);    
     printf("Iznos broja iz temp datoteka je: %d",i);
     
     }
