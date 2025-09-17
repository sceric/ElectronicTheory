// EXAMPLE FILEIO-03

// NOW READ THE FILE THAT WAS JUST
// CREATED

#include <header.h>

const int max = 100 ;

////////////////////////////////////

int main()
{
   char buffer[max] ;
   ifstream file_in("OUTPUT.DAT") ;
   if (!file_in)
   {
      cout << "OPEN FAILED\n" ;
      PAUSE() ;
      exit(1) ;
   }

   int rec = 0 ;
   while (!file_in.get(buffer , max).eof())
   {
      cout << "Record #"
           << ++rec
           << ": "
           << buffer
           << endl ;
      file_in >> FLUSH ;
   }

   return 0 ;
}
