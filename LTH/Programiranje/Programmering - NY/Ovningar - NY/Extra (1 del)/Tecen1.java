

import se.lth.cs.pt.io.*;

class Tecen1{

    public static void main(String[] args) {





   for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print(" " +ch);
            int s =(char)ch-64;             //int s = (char)ch konvertera char  
            System.out.print(s);            //                  till int
        }
        System.out.println();
        int n = 65;
        char c = 'A';
        char p = (int)67;
        c++;
        System.out.println(n);
        System.out.println(c);
        System.out.println(p);
    
  }

}      