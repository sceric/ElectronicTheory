 // EXAMPLE INPUT-21

 // DEMONSTRATE HOW TO READ IN A
 // STRING AND BYPASS WHITESPACE
 // TOTALLY (LOOKS LIKE scanf)

 #include <header.h>

 const int length = 100 ;

 int main()
 {
    char string [length] ;
    const char quote = '\"' ;

    cout << "Enter a string: " ;
    cin >> string ;
    cout << "Your string: "
         << quote
         << string
         << quote
         << '\n' ;

    return 0 ;
 }
