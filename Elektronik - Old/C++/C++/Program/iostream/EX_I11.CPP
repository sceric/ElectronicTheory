 // EXAMPLE INPUT-11

 // DEMONSTRATE HOW TO READ IN A
 // CHARACTER AND BYPASS LEADING
 // WHITESPACE

 #include <header.h>

 int main()
 {
    const char quote = '\'' ;

    cout << "Enter a character: " ;
    char ch ;
    cin >> ch ;
    cout << "You entered: "
         << quote
         << ch
         << quote
         << '\n' ;

    return 0 ;
 }
