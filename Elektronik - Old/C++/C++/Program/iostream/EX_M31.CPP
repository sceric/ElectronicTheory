 // EXAMPLE MANIP-31

 // HOW TO CREATE A MANIPULATOR THAT
 // TAKES 1 ARGUMENT

 #include <header.h>

 ostream& manip(ostream& strm , int length)
 {
    strm << setw(length) << setfill('*') ;
    return strm ;
 }

 OMANIP(int) manip(int length)
 {
    return OMANIP(int) (manip , length) ;
 }

 int main()
 {
    cout << manip(7)
         << 123
         << endl ;
    cout << manip(5)
         << 45
         << endl ;

    return 0 ;
 }
