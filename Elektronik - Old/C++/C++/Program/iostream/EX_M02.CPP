 // EXAMPLE MANIP-02

 // HOW TO PASS CREATE YOUR OWN
 // MANIPULATOR

 #include <header.h>

 ostream& manip(ostream& strm)
 {
    strm.width(5) ;
    strm.fill('*') ;
    return strm ;
 }

 int main()
 {
    cout << manip
         << 23
         << '\n' ;

    return 0 ;
 }
