 // EXAMPLE OUTPUT-81

 // HOW TO PRINT AN ADDRESS IN
 // DECIMAL AS AN UNSIGNED LONG

 #include <header.h>

 int main()
 {
    int number ;

    cout << "Address of number as a\n"
         << "  long integer is "
         << (unsigned long)&number
         << '\n' ;

    return 0 ;
 }
