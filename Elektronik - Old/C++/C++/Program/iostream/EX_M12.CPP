 // EXAMPLE MANIP-12

 // SETTING THE STREAM STATES USING
 // MANIPULATORS

 #include <header.h>

 int main()
 {
    cout << "Input a hex number: " ;
    int number ;
    cin >> hex >> number ;
    cout << "The number in octal is "
         << oct
         << number
         << endl ;

    return 0 ;
 }
