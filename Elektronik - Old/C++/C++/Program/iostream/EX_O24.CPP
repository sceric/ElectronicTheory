 // EXAMPLE OUTPUT-24

 // HOW TO PRINT HEX DIGITS IN
 // UPPER CASE LETTERS

 #include <header.h>

 int main()
 {
    cout.setf(ios::uppercase | ios::showbase) ;
    cout.setf(ios::hex , ios::basefield) ;
    cout << 171 << '\n' ;

    return 0 ;
 }
