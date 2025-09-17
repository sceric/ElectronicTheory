 // EXAMPLE MANIP-22

 // A COMBINATION OF SETTING THE
 // FIELD WIDTH AND SPECIFYING
 // THE FILL CHARACTER USING
 // MANIPULATORS

 #include <header.h>

 int main()
 {
    cout << setw(5)
         << setfill('0')
         << 1
         << endl ;
    cout << setw(5)
         << setfill('*')
         << 23
         << endl ;

    return 0 ;
 }
