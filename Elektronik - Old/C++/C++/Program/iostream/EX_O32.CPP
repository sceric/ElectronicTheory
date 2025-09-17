 // EXAMPLE OUTPUT-32

 // HOW TO PRINT A CHARACTER AS A
 // DECIMAL, OCTAL AND HEXADECIMAL
 // VALUE.

 #include <header.h>

 int main()
 {
    char ch = 'A' ;

    cout << (int)ch << '\n' ;
    cout.setf(ios::oct , ios::basefield) ;
    cout << (int)ch << '\n' ;
    cout.setf(ios::hex , ios::basefield) ;
    cout << (int)ch << '\n' ;

    return 0 ;
 }
