 // EXAMPLE INPUT-22

 // IT'S POSSIBLE TO OVERFLOW AN
 // ARRAY WHEN INPUTTING A STRING

 #include <header.h>

 const int max = 10 ;

 int main()
 {
    char array[max] ;

    cout << "Enter a string: " ;
    cin >> array ;
    cout << "You entered: "
         << array
         << '\n' ;

    return 0 ;
 }

