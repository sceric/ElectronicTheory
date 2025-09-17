// EXAMPLE FILEIO-04

// HOW TO WRITE AND READ A FILE IN
// THE SAME PROGRAM

// NOTE: FILE IS OPENED IN BINARY
// MODE TO AVOID A tellg BUG IN
// TURBO C++

#include <header.h>

const int max = 100 ;

////////////////////////////////////

int main()
{
   char buffer[max] ;
  "fstream"file_both("BOTH.DAT" ,
                      ios::in |
                      ios::out |
                      ios::binary) ;
   if (!file_both)
   {
      cout << "OPEN FAILED\n" ;
      PAUSE() ;
      exit(1) ;
   }

   cout << "Enter a line of data: " ;
   while (!cin.get(buffer , max).eof())
   {
      file_both << buffer << endl ;
      cout << "Next line: " ;
      cin >> FLUSH ;
   }

   // Flush the output buffer
   file_both << flush ;

   // Return to the start of the file
   file_both.seekg(0) ;

   // Read and print the records, and
   // show the file position marker
   int rec = 0 ;
   while (!file_both.get(buffer , max).eof())
   {
      cout << "Record #"
           << ++rec
           << ": "
           << buffer
           << endl ;
      cout << "fpm is: "
           << file_both.tellg()
           << endl ;
      file_both >> FLUSH ;
   }

   return 0 ;
}
