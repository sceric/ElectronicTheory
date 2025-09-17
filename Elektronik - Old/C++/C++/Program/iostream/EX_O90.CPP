 // EXAMPLE OUTPUT-90

 // HOW TO DISPLAY THE BINARY REPRE-
 // SENTATION OF A NUMBER

 #include <header.h>

 int main()
 {
    long number = 0x414243 ;

    cout.write((char*)&number , sizeof(number)) ;
    cout << '\n' ;

    return 0 ;
 }
