#include <stdio.h>
void buble(struct automobil a[3]);
struct motor
	{
		int obujam;
		int maksimalna_brzina;
		int okretni_moment;
	};


	struct automobil
	{
		char marka[20];
		char tip[20];
		char boja[20];
		int cijena;
		struct motor podatci_o_motoru;
	}; 
main()

{
int i,najb,index;

	struct automobil kola[3];

	for(i=0;i<3;i++)
	{
		printf("%d. Automobil\n", i+1);


		
		printf("Marka --> ");
		scanf("%s", &kola[i].marka);
		printf("Tip --> ");
		scanf("%s", &kola[i].tip);
		printf("Boja --> ");
		scanf("%s", &kola[i].boja);
		printf("Cijena --> ");
		scanf("%d", &kola[i].cijena);
		printf("Podatci o motoru:\n");
		printf("Obujam --> ");
		scanf("%d", &kola[i].podatci_o_motoru.obujam);
		printf("Maksimalna brzina --> ");
		scanf("%d", &kola[i].podatci_o_motoru.maksimalna_brzina);
		printf("Okretni moment --> ");
		scanf("%d", &kola[i].podatci_o_motoru.okretni_moment);

	}
	najb=kola[0].podatci_o_motoru.maksimalna_brzina;
	index=0;
		for(i=1;i<3;)
		{
			if(najb<kola[i].podatci_o_motoru.maksimalna_brzina)
				{
					najb=kola[i].podatci_o_motoru.maksimalna_brzina;
					index=i;
				}

				i++;
		}
printf("\nNajbrzi je automobil %s %s i njegova max brzina iznosi %d kmh\n", kola[index].marka, kola[index].tip, najb);
printf("\nSortiranje po cijeni:");
for(i=0;i<3;i++)
{
	

	buble(kola[i].cijena);
}
}


void buble(struct automobil a[3])
{
int i,j,temp=0;
for(i=0;i<2;i++)
	{
		for(j=1;j<3;j++)
		{
			if(a[i].cijena>a[j].cijena)
			{
				temp=a[i].cijena;
				a[i].cijena=a[j].cijena;
				a[j].cijena=temp;
			}
		}
	}
for(i=0;i<3;i++)
printf("%d",a[i].cijena);
printf("\n");
}
