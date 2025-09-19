
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.die.*;

class SamplesF6 {

    public static void main(String[] args) {
        String str = Keyboard.next("Ange en vokal: ");
        char ch = str.charAt(0);
        switch (ch) {
        case 'a':
        case 'o':
        case 'u':
        case 'å':
            System.out.println("En hård vokal");
            break;
        case 'e':
        case 'i':
        case 'y':
        case 'ä':
        case 'ö':
            System.out.println("En mjuk vokal");
            break;
        default:
            System.out.println("Ingen vokal!");
        }
    }

    static void ex10() {   
        int cmd = Keyboard.nextInt("Ange kommando (0-5): ");
        switch (cmd) {
        case 0:
            System.out.println("Hantera kommando 0");
            break;
        case 1:
            System.out.println("Hantera kommando 1");
            break;
        case 2:
            System.out.println("Hantera kommando 2");
            break;
        default:
            System.out.println("Otillåtet kommando");
        }


        if (cmd == 0) {
            System.out.println("Hantera kommando 0");
        } else if (cmd == 1) {
            System.out.println("Hantera kommando 1");
        } else if (cmd == 2) {
            System.out.println("Hantera kommando 2");
        } else if (cmd == 3) {
            System.out.println("Hantera kommando 3");
        } else if (cmd == 4) {
            System.out.println("Hantera kommando 4");
        } else if (cmd == 5) {
            System.out.println("Hantera kommando 5");
        } else {
            System.out.println("Otillåtet kommando");
        }
            
            
    }

    static void ex8() {
        Die d1 = new Die();
        Die d2 = new Die();
        int count = 0;
        do {
            d1.roll();
            d2.roll();
            count++;
        } while (d1.getNbrOfSpots() != d2.getNbrOfSpots());
        System.out.println(count);
    }

    static void ex7() {
        Die d1 = new Die();
        Die d2 = new Die();
        int count = 1;
        d1.roll();
        d2.roll();
        while (d1.getNbrOfSpots() != d2.getNbrOfSpots()) {
            d1.roll();
            d2.roll();
            count++;
        }
        System.out.println(count);
    }

    static void ex6() {
        int n = Keyboard.nextInt("Ange n: ");
        Keyboard.nextLine();
        String str = Keyboard.nextLine("Skriv in en rad: ");
        System.out.printf("Talet var %d, raden var: %s\n", n, str);
    }

    static void ex5() {
        for (int n = 1; n <= 10; n++) {
            System.out.printf("%2d:%12.4f%6d\n", n, Math.sqrt(n), n*n);
        }
    }

    static void ex4() {
        System.out.printf("pi = %8.3f\n", Math.PI);
        int a = 1;
        int b = 2;
        System.out.println("Summan är " + a + b);
        System.out.printf("%d + %d = %d\n", a, b, a+b);
    }

    static void ex3() {
        String str = Keyboard.next("Ange ett ord: ");
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ('a' <= ch && ch <= 'z') {
                sum += ch - 'a' + 1;
            }
        }
        System.out.println("Bokstavssumman är " + sum);
    }

    static void ex2() {
        String str1 = Keyboard.nextLine("Ange namn: ");
        String str2 = Keyboard.nextLine("Ange namn: ");
        if (str1.compareTo(str2) < 0) {
            System.out.println(str1);
            System.out.println(str2);
        } else if (str1.compareTo(str2) == 0) {
            System.out.println(str1);
        } else {
            System.out.println(str2);
            System.out.println(str1);
        }            
    }

    static void ex1() {
        String str1 = "Bo";
        String str2 = Keyboard.nextLine("Ange namn: ");
        if (str1.equals(str2)) {
            System.out.println("Strängarna är lika");
        } else {
            System.out.println("Strängarna är olika");
        }
        String str = Keyboard.nextLine("Sträng: ");
        for (int i = 0; i < str.length(); i++) {
            int value = str.charAt(i);
            System.out.println(str.charAt(i) + ": " + value);
        }
    }
}
