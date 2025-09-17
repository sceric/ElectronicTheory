// EXAMPLE FILEIO-05

// GIVE THE USER COMPLETE FLEXIBILITY
// AS TO THE MODE OF THE FILE AND THE
// DATA WRITTEN AND READ

// ARGUMENTS ARE ENTERED FROM THE DOS
// COMMAND LINE. THE FIRST ARGUMENT
// IS THE DISK FILE NAME, AND THE
// REMAINING ARGUMENTS REPRESENT THE
// VARIOUS OPEN MODES, EXACTLY AS
// SPECIFIED BY THE ENUMERATED TYPES

// NOTE THAT A CLASS IS NOW USED TO
// CONTROL THE VARIOUS OPERATIONS ON
// A FILE OBJECT. HOWEVER, A POINTER
// IS DECLARED INSTEAD OF AN INSTANCE
// TO AVOID A BORLAND BUG

#include <header.h>

const int max = 100 ;

class file
{
   fstream* ptr ;
     public:

   file()
   {
      ptr = new fstream() ;
   }

   int open(int argc , char* argv[]) ;
   void read() ;
   void write() ;
   void beginning() ;
   void end() ;
   void close() ;
} ;

// Open the file by setting up the
// field 'mode' with the OR of what-
// ever modes the user has chosen

int file::open(int argc , char* argv[])
{
   int mode = 0 ;

   for (int i = 2 ; i < argc ; ++i)
   {
      if (!strcmp (argv[i] , "out"))
          mode |= ios::out ;
      else if (!strcmp (argv[i] , "in"))
          mode |= ios::in ;
      else if (!strcmp (argv[i] , "app"))
          mode |= ios::app ;
      else if (!strcmp (argv[i] , "ate"))
          mode |= ios::ate ;
      else if (!strcmp (argv[i] , "trunc"))
          mode |= ios::trunc ;
      else if (!strcmp (argv[i] , "nocreate"))
          mode |= ios::nocreate ;
      else if (!strcmp (argv[i] , "noreplace"))
          mode |= ios::noreplace ;
      else if (!strcmp (argv[i] , "binary"))
          mode |= ios::binary ;
      else
          cout << "Invalid mode: "
                << argv[i]
                << endl ;
   }

   // Perform the actual open
   ptr->open(argv[1] , mode) ;

   // If an error occurred, return
   // "true"
   return (!*ptr) ;
}

// Read the file

void file::read()
{
   char buffer [max] ;

   cout << "Data line: " ;
   ptr->get(buffer , max) ;
   *ptr >> FLUSH ;
   if (!(ptr->eof()))
      cout << buffer << endl ;
   else
      cout << "EOF\n" ;
   ptr->clear() ;
}

// Write the file

void file::write()
{
   char buffer [max] ;

   cout << "Enter some data: " ;
   cin.get(buffer , max) ;
   cin >> FLUSH ;
   *ptr << buffer << endl ;
}

// Return to the start of the file

void file::beginning()
{
   ptr->seekg(0) ;
   ptr->seekp(0) ;
}

// Seek to the end of the file

void file::end()
{
   ptr->seekg(0 , ios::end) ;
   ptr->seekp(0 , ios::end) ;
}

// Close the file

void file::close()
{
   ptr->close() ;
}

///////////////////////////////////

char menu() ;

int main(int argc , char* argv [])
{
   file my_file ;

   if (argc < 2)
   {
      cout << "NO FILE NAME\n" ;
      exit(1) ;
   }

   if(my_file.open(argc , argv))
   {
      cout << "OPEN FAILED\n" ;
      exit(2) ;
   }

   char ch ;
   while ((ch = menu()) != 'X')
   {
      switch (ch)
      {
        case 'R' : my_file.read() ;
                   break ;
        case 'W' : my_file.write() ;
                   break ;
        case 'B' : my_file.beginning() ;
                   break ;
        case 'E' : my_file.end() ;
                   break ;
        default :  cout << "INVALID\n" ;
                   break ;
      }
   }
   my_file.close() ;

   return 0 ;
}

///////////////////////////////////////

char menu()
{
   cout << "\t(R)ead a record\n" ;
   cout << "\t(W)rite a record\n" ;
   cout << "\t(B)eginning of file\n" ;
   cout << "\t(E)nd of the file\n" ;
   cout << "\te(X)it\n" ;

   cout << "\n\tYour choice: " ;
   char ch ;
   cin >> ch >> FLUSH ;
   return (toupper(ch)) ;
}
