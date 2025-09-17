 // EXAMPLE OUTPUT-22

 // HOW TO PRINT IN DECIMAL, OCTAL
 // AND HEXADECIMAL FORMATS AND SHOW
 // THE BASE FOR OCTAL AND HEX
 // NUMBERS

 #include <header.h>

 int main()
 {
    cout.setf(ios::showbase) ;
    cout << 65 << '\n' ;
    cout.setf(ios::oct , ios::basefield) ;
    cout << 65 << '\n' ;
    cout.setf(ios::hex , ios::basefield) ;
    cout << 65 << '\n' ;
    cout.setf(ios::dec , ios::basefield) ;
    cout << 65 << '\n' ;

    return 0 ;
 }
