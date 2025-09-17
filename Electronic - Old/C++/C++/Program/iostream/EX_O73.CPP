 // EXAMPLE OUTPUT-73

 // HOW TO EMULATE printf AND SET
 // THE PRECISION

 #include <header.h>

 int main()
 {
    cout.setf(ios::showpoint) ;
    cout.precision(2) ;

    // Guarantee fixed decimal
    cout.setf(ios::fixed , ios::floatfield) ;
    cout << 1.2300 << '\n' ;
    cout << 4.00 << '\n' ;
    cout << 5.678E2  << '\n' ;
    cout << 0.0 << '\n' ;

    // Guarantee scientific
    cout.setf(ios::scientific , ios::floatfield) ;
    cout << 1.2300 << '\n' ;
    cout << 4.00  << '\n' ;
    cout << 5.678E2<< '\n' ;
    cout << 0.0 << '\n' ;

    return 0 ;
 }
