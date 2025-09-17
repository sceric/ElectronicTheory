 // EXAMPLE OUTPUT-31

 // HOW TO PRINT A CHARACTER AND A
 // NON-CHARACTER IN CHARACTER
 // FORMAT.

 #include <header.h>

 int main()
 {
    // No cast needed here
    char ch1 = 'A' ;
    cout << ch1 << '\n' ;
    char ch2 = 65 ;
    cout << ch2 << '\n' ;

    // Cast needed here
    int ch3 = 65 ;
    cout << (char)ch3 << '\n' ;
    int ch4 = 0101 ;
    cout << (char)ch4 << '\n' ;
    int ch5 = 0x41 ;
    cout << (char)ch5 << '\n' ;

    return 0 ;
 }
