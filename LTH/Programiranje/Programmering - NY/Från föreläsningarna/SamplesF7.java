
import se.lth.cs.pt.random.*;
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.window.*;
import se.lth.cs.pt.turtle.*;

class SamplesF7 {

    public static void main(String[] args) {
        TurtleWindow w = new TurtleWindow(500,500);
        Turtle[] t = new Turtle[10];
        for (int i = 0; i < 10; i++) {
            t[i] = new Turtle(w, 40*(i+1), 20*(i+1));
            t[i].penDown();
            t[i].right(90);
        }
        for (int j = 1; j <= 4; j++) {
            for (int i = 0; i < 10; i++) {
                w.waitForMouseClick();
                t[i].forward(50);
                t[i].right(90);
            }
        }
    }

    static void ex6() {
        double[] values = new double[100];
        int n = 0;
        for (;;) {
            double v = Keyboard.nextDouble("Läs in tal: ");
            if (v <= 0) {
                break;
            }
            values[n] = v;
            n++;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(values[i]);
        }
    }

    static void ex5() {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = Keyboard.nextInt();
        }
        for (int i = 9; i >= 0; i--) {
            System.out.println(a[i]);
        }

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    static void ex4() {
        int a0 = Keyboard.nextInt();
        int a1 = Keyboard.nextInt();
        int a2 = Keyboard.nextInt();
        int a3 = Keyboard.nextInt();
        int a4 = Keyboard.nextInt();
        System.out.println(a4);
        System.out.println(a3);
        System.out.println(a2);
        System.out.println(a1);
        System.out.println(a0);
    }

    static void ex3() {
        double seed = 0.32242323;
        for (int i = 1; i <= 100; i++) {
            seed *= 147;
            seed = seed - Math.floor(seed);
            System.out.println(seed);
        }
    }

    static void ex2() {
        RandomNumberGenerator rng = new RandomNumberGenerator();
        for (int i = 1; i <= 13; i++) {
            double rval = rng.randDouble(0,1);
            if (rval <= 0.5) {
                System.out.println("1");
            } else if (rval <= 0.8) {
                System.out.println(" x");
            } else {
                System.out.println("  2");
            }
        }
    }

    static void ex1() {
        RandomNumberGenerator rng = new RandomNumberGenerator();
        for (int i = 1; i <= 10; i++) {
            System.out.print(rng.randInt(1,6) + " ");
        }
        System.out.println();
        for (int i = 1; i <= 10; i++) {
            System.out.print(rng.randDouble(0,20) + " ");
        }
        System.out.println();
        for (int i = 1; i <= 10; i++) {
            System.out.print(rng.randNormal(500,10) + " ");
        }
        System.out.println();
    }
}
