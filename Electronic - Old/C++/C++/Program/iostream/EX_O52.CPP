 // EXAMPLE OUTPUT-52

 // A COMBINATION OF SETTING THE
 // FIELD WIDTH AND SPECIFYING
 // THE FILL CHARACTER

 #include <header.h>

 int main()
 {
    cout.width(5) ;
    cout.fill('0') ;
    cout << 1 << '\n' ;
    cout.width(5) ;
    cout.fill('*') ;
    cout << 23 << '\n' ;

    return 0 ;
 }
