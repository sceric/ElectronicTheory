 // EXAMPLE INPUT-42

 // SHOW HOW TO HANDLE ANYTHING
 // THE OPERATOR CAN THROW AT
 // THE PROGRAM

 #include <header.h>

 int main()
 {
    cout << "\nEnter a number: " ;
    int number ;
    while (!(cin >> number).eof())
    {
      // Test for a bad number
      if (!cin)
        cout << "Input error!\n" ;

      // Process a good number
      else
        cout << "YOU ENTERED: "
             << number
             << endl ;

      // Clear out the input buffer.
      cin >> FLUSH ;

      cout << "\nNext number: " ;
    }
    cout << "\nEND OF PROGRAM\n" ;

    return 0 ;
 }
