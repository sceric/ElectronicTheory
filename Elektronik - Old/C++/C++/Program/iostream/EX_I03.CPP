 // EXAMPLE INPUT-03

 // INTEGERS CAN BE INPUT IN ANY OF
 // 3 DIFFERENT BASES

 #include <header.h>

 int main()
 {
    int number ;

    cout << "Enter a decimal number: " ;
    cin >> number ;
    cout << "You entered: "
         << number
         << endl ;

    cout << "Enter an octal number: " ;
    cin.setf(ios::oct , ios::basefield) ;
    cin >> number ;
    cout << "You entered: "
         << number
         << endl ;

    cout << "Enter a hex number: " ;
    cin.setf(ios::hex , ios::basefield) ;
    cin >> number ;
    cout << "You entered: "
         << number
         << endl ;

    return 0 ;
 }
