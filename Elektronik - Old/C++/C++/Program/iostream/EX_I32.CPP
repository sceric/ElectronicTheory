 // EXAMPLE INPUT-32

 // A BETTER METHOD OF CODING
 // EXAMPLE INPUT-31

 #include <header.h>

 int main()
 {
    cout << "Enter a number: " ;
    int num ;
    while (!(cin >> num).eof())
    {
      cout << "You entered: "
           << num
           << '\n' ;
      cout << "\nNext number: " ;
    }

    return 0 ;
 }
