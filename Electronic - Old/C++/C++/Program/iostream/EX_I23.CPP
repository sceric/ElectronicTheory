 // EXAMPLE INPUT-23

 // HOW TO AVOID OVERFLOWING AN
 // ARRAY WHEN INPUTTING A STRING
 // WITH THE EXTRACTION OPERATOR

 #include <header.h>

 const int max = 10 ;

 int main()
 {
    char array[max] ;

    cout << "Enter a string: " ;
    cin.width(max) ;
    cin >> array ;
    cout << "You entered: "
         << array
         << '\n' ;

    return 0 ;
 }
