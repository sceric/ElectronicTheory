// EXAMPLE FILEIO-06

// HOW TO PRINT FROM WITHIN A
// PROGRAM

#include <header.h>

int main()
{
   ofstream printer ;
   // "prn" is the DOS printer
   printer.open("prn") ;
   if (!printer)
   {
     cerr << "Can't open\n" ;
     exit(1) ;
   }
   printer << "This line appears"
           << " on the printer\n" ;

   return 0 ;
}

