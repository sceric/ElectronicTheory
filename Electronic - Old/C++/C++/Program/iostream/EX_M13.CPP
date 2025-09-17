 // EXAMPLE MANIP-13

 // DEMONSTRATE HOW TO READ IN A
 // STRING AND RETAIN EMBEDDED
 // WHITE SPACE, BUT BYPASS
 // LEADING WHITE SPACE

 #include <header.h>

 const int length = 100 ;

 int main()
 {
    char string [length] ;
    const char quote = '\"' ;

    cout << "Enter a string: " ;
    cin >> ws ;
    cin.get(string , length) ;
    cout << "Your string: "
         << quote
         << string
         << quote
         << endl ;

    return 0 ;
 }
