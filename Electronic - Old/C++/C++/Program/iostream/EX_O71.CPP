 // EXAMPLE OUTPUT-71

 // HOW TO EMULATE printf

 #include <header.h>

 int main()
 {
    cout.setf(ios::showpoint) ;
    cout << 1.2300 << '\n' ;
    cout << 4.00 << '\n' ;
    cout << 5.678E2 << '\n' ;
    cout << 0.0 << '\n' ;

    return 0 ;
 }
