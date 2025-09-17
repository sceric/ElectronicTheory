 // EXAMPLE INPUT-12

 // DEMONSTRATE HOW TO READ IN A
 // CHARACTER AND RETAIN LEADING
 // WHITESPACE USING get(char&)

 #include <header.h>

 int main()
 {
    const char quote = '\'' ;

    cout << "Enter a character: " ;
    char ch ;
    cin.get(ch) ;
    cout << "You entered: "
         << quote
         << ch
         << quote
         << '\n' ;

    return 0 ;
 }
