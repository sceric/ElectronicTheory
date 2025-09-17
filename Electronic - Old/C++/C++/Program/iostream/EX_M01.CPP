 // EXAMPLE MANIP-01

 // HOW TO PASS THE ADDRESS OF A
 // FUNCTION AS AN ARGUMENT

 #include <header.h>

 // Function declarations

 void print() ;
 void test(void (*)()) ;

 int main()
 {
    test(print) ;

    return 0 ;
 }

 void print()
 {
    cout << "print function\n" ;
 }

 void test(void (*ptr)())
 {
    ptr() ;
 }
