 // EXAMPLE MANIP-32

 // HOW TO CREATE A MANIPULATOR THAT
 // TAKES 1 ARGUMENT, AND THAT ARGUMENT
 // IS NOT int OR long

 #include <header.h>

 // Don't forget this statement
 IOMANIPdeclare(char) ;

 ostream& manip(ostream& strm , char ch)
 {
    strm << setw(7) << setfill(ch) ;
    return strm ;
 }

 OMANIP(char) manip(char ch)
 {
    return OMANIP(char) (manip , ch) ;
 }

 int main()
 {
    cout << manip('*')
         << 123
         << endl ;
    cout << manip('$')
         << 45
         << endl ;

    return 0 ;
 }
