#include <windows.h> //Inkluderar header filen windows.h

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance,//Insisterar windows headern
      LPSTR lpCmdLine, int nCmdShow)
{//Börjar själva main programet
  MessageBox(NULL, "Volim te draga do bola....CMMMMOK !", "Ceric", MB_OK);
  //Messagebox=msgruta, "Valfritt
  //msg"=Det du skriver här blir msg i rutan
  //"Rubrik"=Ja rubrik MB_OK=Gör så att en knapp som
  //heter OK kommer upp under texten
  return 0;
}//Avslutar programmet
