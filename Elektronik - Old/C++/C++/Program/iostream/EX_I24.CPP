 // EXAMPLE INPUT-24

 // DEMONSTRATE HOW TO READ IN A
 // STRING AND RETAIN WHITESPACE,
 // BOTH LEADING AND EMBEDDED

 #include <header.h>

 const int length = 100 ;

 int main()
 {
    char string [length] ;
    const char quote = '\"' ;

    cout << "Enter a string: " ;
    cin.get(string , length) ;
    cout << "Your string: "
         << quote
         << string
         << quote
         << '\n' ;

    return 0 ;
 }
