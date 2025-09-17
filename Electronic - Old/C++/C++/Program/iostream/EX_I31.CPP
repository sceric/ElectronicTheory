 // EXAMPLE INPUT-31

 // ENTER A NUMBER AND LOOP
 // UNTIL EOF IS DETECTED

 #include <header.h>

 int main()
 {
    cout << "Enter a number: " ;
    int num ;
    cin >> num ;
    while (!cin.eof())
    {
       cout << "You entered: "
            << num
            << '\n' ;
       cout << "\nNext number: " ;
       cin >> num ;
    }

    return 0 ;
 }
