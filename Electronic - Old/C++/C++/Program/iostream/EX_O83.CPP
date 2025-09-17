 // EXAMPLE OUTPUT-83

 // HOW TO PRINT AN ADDRESS OF
 // A STRING

 #include <header.h>

 int main()
 {
    char* ptr = "ABC" ;

    cout << "The string itself is "
         << ptr
         << '\n' ;

    cout << "The address of the"
         << "string is "
         << (unsigned)(void*)ptr
         << '\n' ;

    return 0 ;
  }
