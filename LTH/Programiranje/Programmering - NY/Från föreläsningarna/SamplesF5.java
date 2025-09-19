
import se.lth.cs.pt.io.*;

class SamplesF5 {

    public static void main(String[] args) {
        String str = Keyboard.nextLine("Ange en rad med text: ");
        for (int i = str.length()-1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }

    static void ex2() {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            System.out.print(ch);
        }
        System.out.println();
        int n = 65;
        char c = 'A';
        c++;
        System.out.println(n);
        System.out.println(c);
    }

    static void ex1() {
        int a = Keyboard.nextInt("Ange a: ");
        int b = Keyboard.nextInt("Ange b: ");
        int c = Keyboard.nextInt("Ange c: ");
        
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        if (a < c) {
            int tmp = a;
            a = c;
            c = tmp;
        }
        if (b < c) {
            int tmp = b;
            b = c;
            c = tmp;
        }
        
        if (a > b+c) {
            System.out.println("Ingen triangel!");
        } else if (a == b && b == c) {
            System.out.println("Liksidig triangel");
        }
            
        
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);

    }
}
