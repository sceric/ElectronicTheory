// EXAMPLE FILEIO-01

// CREATE AN OUTPUT FILE AND WRITE
// WHATEVER DATA THE OPERATOR MAY
// ENTER

#include <header.h>

const int max = 100 ;

////////////////////////////////////

int main()
{
   char buffer[max] ;
   ofstream file_out("OUTPUT.DAT") ;
   if (!file_out)
   {
      cout << "OPEN FAILED\n" ;
      PAUSE() ;
      exit(1) ;
   }

   cout << "Enter a line of data: " ;
   while (!cin.get(buffer , max).eof())
   {
      file_out << buffer << endl ;
      cout << "Next line: " ;
      cin >> FLUSH ;
   }

   return 0 ;
}
