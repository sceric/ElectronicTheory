 // EXAMPLE OUTPUT-72

 // HOW TO EMULATE printf AND SET
 // THE PRECISION

 #include <header.h>

 int main()
 {
    cout.setf(ios::showpoint) ;
    cout.precision(1) ;
    cout << 1.2300 << '\n' ;
    cout << 4.00 << '\n' ;
    cout << 5.678E2 << '\n' ;
    cout << 0.0 << '\n' ;

    return 0 ;
 }
