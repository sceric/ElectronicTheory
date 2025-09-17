 // EXAMPLE OUTPUT-60

 // HOW TO LEFT-JUSTIFY A FIELD

 #include <header.h>

 int main()
 {
    cout.setf(ios::left , ios::adjustfield) ;
    cout.width(5) ;
    cout.fill('0') ;
    cout << 1 << '\n' ;
    cout.width(5) ;
    cout.fill('*') ;
    cout << 23 << '\n' ;

    return 0 ;
 }
