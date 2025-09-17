 // EXAMPLE OUTPUT-61

 // HOW TO DO INTERNAL JUSTIFICATION

 #include <header.h>

 int main()
 {
    cout.setf(ios::showbase) ;
    cout.fill('=') ;
    cout.setf(ios::internal , ios::adjustfield) ;
    cout.width(10) ;
    cout.setf(ios::hex , ios::basefield) ;
    cout << 65 << '\n' ;
    cout.setf(ios::left , ios::adjustfield) ;
    cout.width(10) ;
    cout << 65 << '\n' ;

    return 0 ;
 }
