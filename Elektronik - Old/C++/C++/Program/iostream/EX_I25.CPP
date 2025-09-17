 // EXAMPLE INPUT-25

 // TEST getline FUNCTION

 // NOTE THAT THE LAST DOUBLE QUOTE
 // APPEARS ON THE FOLLOWING LINE
 // DUE TO THE INCLUSION OF THE
 // NEWLINE CHARACTER IN string

 #include <header.h>

 const int length = 100 ;

 int main()
 {
    char string [length] ;
    const char quote = '\"' ;

    cout << "Enter a string: " ;
    cin.getline(string , length) ;
    cout << "Your string: "
         << quote
         << string
         << quote ;

    return 0 ;
 }
