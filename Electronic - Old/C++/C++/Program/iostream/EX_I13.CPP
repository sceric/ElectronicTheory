 // EXAMPLE INPUT-13

 // DEMONSTRATE HOW TO READ IN A
 // CHARACTER AND RETAIN LEADING
 // WHITESPACE USING get()

 #include <header.h>

 int main()
 {
    const char quote = '\'' ;

    cout << "Enter a character: " ;
    int ch ;
    ch = cin.get() ;
    if (ch != EOF)
       cout << "You entered: "
            << quote
            << (char)ch
            << quote
            << '\n' ;
    else
       cout << "End-of-file\n" ;

    return 0 ;
 }
