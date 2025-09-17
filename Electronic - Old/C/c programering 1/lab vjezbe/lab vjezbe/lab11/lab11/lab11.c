#include <stdio.h>

main()

{
char rijec[20], recenica[80];
char *p_rij,*p_rec;
int jed=0, x=0, brd=0, brs=0;

printf("Upisite rijec koju trazite\n");
gets(rijec);
printf("Upisite recenicu\n");
gets(recenica);
p_rij=rijec;
p_rec=recenica;

while(*p_rij!='\0')
{
p_rij++;
x++;
}
p_rij=rijec;
while(*p_rec!='\0')
{
	if(*p_rec==*p_rij)
	{
		jed=1;
		while(*p_rij!='\0')
		{
			if(*p_rec!=*p_rij)
				jed=0;
					p_rec++;
					p_rij++;
		}
		p_rij=p_rec;
		if(jed=1)
		{
			if((*p_rec==' '&&*(p_rec-x-1)==' ')||((p_rec-x)==recenica)||((*p_rec)=='\0'))
				brs++;
			else
				brd++;
		}
	}
	p_rec++;
}

printf("Rijec: \n");
puts(rijec);
printf("Pojavljuje se su recenici ---> ");
puts(recenica);
printf("%d puta kao samostalna rijec, a %d puta kao dio druge rijeci \n", brs,brd);
}







