// Det här programmet har skrivits av Fredrik Svensson.
// Om någon del av koden gör skada eller inte fungerar, står inte Fredrik Svensson till ansvar.
// Ni har inte tillåtelse att använda koden i olagliga program eller till andra lagöverträdelser.
// Om Ni använder den här koden i lagligt syfte och menar väl med Ert program, skriv gärna en kommenter liknande "Tack till Fredrik Svensson (till_fredrik@hotmail.com)".
// Ni får inte sprida den här koden mot betalning. Detta är en fri kod och ska så också förbli.
// Ni ska vid spridning av den här koden ange att den är tillverkad av Fredrik Svensson (till_fredrik@hotmail.com)
// Med vänliga hälsningar Fredrik Svensson

// Bara var tvungen att ta med denna del...

#include <windows.h>

int WINAPI WinMain(HINSTANCE hInstance,HINSTANCE hPrevInstance,LPSTR lpCmdLine,int nCmdShow)
{
  char username[256];
  DWORD size;
  HANDLE hMutex;

  hMutex = CreateMutex(NULL,TRUE,"Mutex");
  if(GetLastError() == ERROR_ALREADY_EXISTS)
    MessageBox(NULL,"Du kör redan det här programmet.","Kör inte programmet flera gånger...",MB_OK | MB_ICONINFORMATION);
  else
  {
    memset(username,0,256 * sizeof(char));
    size = 256;
    GetUserName(username,&size);
    MessageBox(NULL,username,"Ditt användarnamn är",MB_OK | MB_ICONINFORMATION);
  }
  CloseHandle(hMutex);
  return 1;
}
