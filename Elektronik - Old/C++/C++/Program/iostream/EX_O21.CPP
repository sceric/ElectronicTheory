 // EXAMPLE OUTPUT-21

 // HOW TO PRINT IN DECIMAL, OCTAL
 // AND HEXADECIMAL FORMATS

 #include <header.h>

 int main()
 {
    cout << 65 << '\n' ;
    cout.setf(ios::oct , ios::basefield) ;
    cout << 65 << '\n' ;
    cout.setf(ios::hex , ios::basefield) ;
    cout << 65 << '\n' ;
    cout.setf(ios::dec , ios::basefield) ;
    cout << 65 << '\n' ;

    return 0 ;
 }
