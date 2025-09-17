 // EXAMPLE OUTPUT-13

 // TEST ios::basefield

 #include <header.h>

 int main()
 {
    cout.setf(ios::oct | ios::hex) ;
    FORMATFLAGS() ;
    cout.setf(ios::dec , ios::basefield) ;
    FORMATFLAGS() ;

    return 0 ;
 }
