 // EXAMPLE OUTPUT-12

 // TEST TURNING ON FORMAT FLAG BITS

 #include <header.h>

 int main()
 {
    cout.setf(ios::oct | ios::hex) ;
    FORMATFLAGS() ;
    cout.setf(ios::dec , ios::dec | ios::oct | ios::hex) ;
    FORMATFLAGS() ;

    return 0 ;
 }
