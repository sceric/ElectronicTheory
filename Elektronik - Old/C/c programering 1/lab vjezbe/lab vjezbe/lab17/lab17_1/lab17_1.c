#include <stdio.h>
#define MAX 100

int fcount(char str[MAX]);

main()
{
char str[MAX];

gets(str);
printf("U recenici se nalaze %d rijeci\n", fcount(str));
system("PAUSE");
}

int fcount(char str[MAX])
{

	int i=0,br=1;

while (str[i]!='\0')
{

	if(str[i]==' ')
	{
if(str[i+1]>='a'||str[i+1]>='A')
                 {                 
      		br++;
        }
    
    }
    i++;
}
if(str[0]==' '||str[0]=='\0')
{
             br--; 
              }


return br;
}
