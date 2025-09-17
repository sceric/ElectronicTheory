#include<stdio.h>
#include<stdlib.h>
#include<malloc.h>

int izbornik(void);
void push();
void pop();
void ispis();


struct clan_liste{
	int broj;
	struct clan_liste *pokazivac;
};


struct clan_liste *head=NULL;






void main(void)
{
	int r;
//	head=NULL;
	while(r!=4){
		r=izbornik();
		switch (r){
		case 1:
			push();
			break;
		case 2:
			pop();
			break;
		case 3:
			ispis();
			break;
		}
	}
	printf("\nBye, bye!\n");
}

int izbornik(void)
{
	int izbor;
	while (izbor>4 || izbor<1){
		printf("\n ------------ IZBORNIK ------------ \n");
		printf("| 1. PUSH                          |\n");
		printf("| 2. POP                           |\n");
		printf("| 3. ISPIS                         |\n");
		printf("| 4. IZLAZ IZ PROGRAMA	           |\n");
		printf(" ---------------------------------- \n");
		printf("\nVas izbor: ");
		scanf("%d",&izbor);
		if (izbor<1 || izbor>4){
			printf("Pogresan izbor!\n");
			printf("Pokusajte ponovno ...\n\n");
		}
	}
	return izbor;
}

void push(void)
{
	int i;


	struct clan_liste *novi;

	printf("\nKoju vrijednost zelite staviti na vrh stoga -> ");
	scanf("%d",&i);

	novi = (struct clan_liste *)malloc(sizeof(struct clan_liste));
	

	novi->pokazivac=head;

	novi->broj=i;

	head=novi;
}

void pop(void)
{
	struct clan_liste *novi;
	if (head != NULL)
	{
		novi=head;
		head=head->pokazivac;
		free(novi);
	}
}

void ispis(void)
{
	if (head == NULL) printf("\nLista je prazna!\n");
		else printf("\nElement na vrhu stoga je -> %d",head->broj);
}
