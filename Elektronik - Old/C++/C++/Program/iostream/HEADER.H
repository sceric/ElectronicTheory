// header.h
// for iostream tutorial by Eric Nagler
//
////////////////////////////////////
// My private header file for C++ programs
////////////////////////////////////

// There's also a #define ZORTECH in my Zortech header file so that I can
// write different statements to print addresses.

#define BORLAND

// OLD is defined in the cc.bat file which I use to compile Turbo C++
// using the old (version 1.2) style I/O. Therefore, use <stream.h>

#ifdef OLD
#include <stream.h>

// Otherwise, it must be version 2.0, so use <fstream.h>, which also
// includes <iostream.h>

#else
#include <fstream.h>

// Any manipulators taking a parameter will also be accommodated

#include <iomanip.h>
#endif

// I also need console I/O for the PAUSE() function

#include <conio.h>

// Include <stdio.h> for C style I/O

#include <stdio.h>

// Include these because they're used so frequently, and really don't add
// that much to the compilation time

#include <string.h>
#include <ctype.h>
#include <stdlib.h>
#include <time.h>

///////////////////////////////////

// My private defines

#define FALSE               0
#define TRUE                !FALSE
#define AND                 &&
#define OR                  ||
#define NO                  0
#define YES                 !NO
#define EQUALS              ==
#define IS_EQUAL_TO         ==
#define NOT                 !
#define IS_NOT_EQUAL_TO     !=
#define NOT_EQUAL_TO        !=
//
#define BLANK               ' '
#define SPACE               ' '
#define ASTERISK            '*'
#define DECIMAL             '.'
#define NEW_LINE            '\n'
#define NUL                 '\0'
#define TAB                 '\t'
#define BACKSPACE           '\b'
#define BEEP                '\a'
#define FORMFEED            '\f'
#define RETURN              '\r'

///////////////////////////////////

// My private PAUSE function

void PAUSE()
{
   cout << "Press any key to "
        << "continue...\n" ;
   getch() ;
}

// My private flush-the-input-buffer manipulator until either EOF or
// new-line is found.

istream& FLUSH(istream& strm)
{
   strm.clear() ;
   char ch ;
   while (!strm.get(ch).eof() AND ch != NEW_LINE)
                         ;  // Empty body
   return strm ;
}

////////////////////////////////////
// This function prints the various I/O flags of an input stream.
// Defaults to 'cin'

void IOFLAGS(istream& stream=cin)
{
   cout << "eof state is  " << (stream.eof()
           ? "ON" : "OFF") << endl ;
   cout << "good state is " << (stream.good()
           ? "ON" : "OFF") << endl ;
   cout << "fail state is " << (stream.fail()
           ? "ON" : "OFF") << endl ;
   cout << "bad state is  " << (stream.bad()
           ? "ON" : "OFF") << endl ;
   cout << "if (!instance) returns "<< (!stream ? "TRUE" : "FALSE") << endl ;
   cout << "if (instance) returns " << (stream ? "TRUE" : "FALSE") << endl ;
}

/////////////////////////////////////
// This function prints the format flags of an output stream.
// Defaults to 'cout'

void FORMATFLAGS(ostream& stream=cout)
{
   static char* message[] =
   {
     "skipws" ,
     "left" ,
     "right" ,
     "internal" ,
     "dec" ,
     "oct" ,
     "hex" ,
     "showbase" ,
     "showpoint" ,
     "uppercase" ,
     "showpos" ,
     "scientific" ,
     "fixed" ,
     "unitbuf" ,
     "stdio"
   } ;

   cout << "FORMAT FLAGS\n" ;
   long f = stream.flags() ;
   for (int i = 0 ; i < 16 ; ++i)
   {
     if (f & 0x0001)
       cout << message[i] << endl ;
     f >>= 1 ;
   }
}

///////////////////////////////////

// Define a global instance of the
// class 'ofstream' called POUT that
// is tied to the printer

ofstream POUT("prn") ;

/////////////////////////////////////

// A manipulator that directs to the printer all subsequent output for
// the one statement in which it is found

ostream& PRINTER(ostream&)
{
   return POUT ;
}

// A manipulator that directs to the screen all subsequent output for
// the one statement in which it is found

ostream& SCREEN(ostream&)
{
   return cout ;
}

// A manipluator to set left justification

ostream& LEFT(ostream& str)
{
   str.setf(ios::left , ios::adjustfield) ;
   return str ;
}

// A manipluator to set right justification

ostream& RIGHT(ostream& str)
{
   str.setf(ios::right , ios::adjustfield) ;
   return str ;
}

// A manipluator to set internal justification

ostream& INTERNAL(ostream& str)
{
   str.setf(ios::internal , ios::adjustfield) ;
   return str ;
}

// A manipulator to show the decimal point

ostream& SHOWPOINT(ostream& str)
{
   str.setf(ios::showpoint) ;
   return str ;
}

// A manipulator to show the base on hex and octal output

ostream& SHOWBASE(ostream& str)
{
   str.setf(ios::showbase) ;
   return str ;
}

// A manipulator to suppress the showing of the base

ostream& NOSHOWBASE(ostream& str)
{
   str.unsetf(ios::showbase) ;
   return str ;
}

// A manipulator to show fixed point output

ostream& FIXED(ostream& str)
{
   str.setf(ios::fixed , ios::floatfield) ;
   return str ;
}

// A manipulator to show scientific point output

ostream& SCIENTIFIC(ostream& str)
{
   str.setf(ios::scientific , ios::floatfield) ;
   return str ;
}

// A manipulator to show uppercase output on hex and scientific
// numbers

ostream& UPPERCASE(ostream& str)
{
   str.setf(ios::uppercase) ;
   return str ;
}

// A manipulator to show lowercase output on hex and scientific
// numbers

ostream& LOWERCASE(ostream& str)
{
   str.unsetf(ios::uppercase) ;
   return str ;
}

// A manipulator to show a '+' on positive numbers

ostream& SHOWPOS(ostream& str)
{
   str.setf(ios::showpos) ;
   return str ;
}

// A manipulator to negate showing a '+' on positive numbers

ostream& NOSHOWPOS(ostream& str)
{
   str.unsetf(ios::showpos) ;
   return str ;
}
