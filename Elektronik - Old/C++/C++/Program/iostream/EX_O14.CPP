 // EXAMPLE OUTPUT-14

 // TEST THE flags MEMBER FUNCTION

 #include <header.h>

 int main()
 {
    long value = cout.flags(0) ;
    cout.setf(ios::hex , ios::basefield) ;
    cout << "value is "
         << value
         << '\n' ;
    FORMATFLAGS(cout) ;

    return 0 ;
 }
