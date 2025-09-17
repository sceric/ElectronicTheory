 // EXAMPLE OUTPUT-51

 // HOW TO SET THE FILL CHARACTER

 #include <header.h>

 int main()
 {
    const char quote = '\'' ;
    char old_fill = cout.fill('*') ;
    cout << "Old fill character is "
         << quote
         << old_fill
         << quote
         << '\n' ;

    cout << "It was changed to "
         << quote
         << cout.fill()
         << quote
         << '\n' ;

    return 0 ;
 }
