
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.die.*;
import se.lth.cs.pt.random.*;

class SamplesF9 {

    public static void main(String[] args) {
        int[] a = {3,1,4,0,2};
        System.out.println(findSmallest(a,0,4));
    }

    static void selectionSort(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            int smallest = findSmallest(a,i,n-1);
            int tmp = a[i];
            a[i] = a[smallest];
            a[smallest] = tmp;
        }
    }

    static int findSmallest(int[] a, int low, int high) {
        int smallest = low;
        for (int i = low+1; i <= high; i++) {
            if (a[i] < a[smallest]) {
                smallest = i;
            }
        }
        return smallest;
    }

    static void ex3() {
        RandomNumberGenerator rng = new RandomNumberGenerator();
        int[] count = new int[100];
        for (int i = 1; i <= 100000; i++) {
            int rndNbr = rng.randInt(0,99);
            count[rndNbr]++;
        }
        for (int i = 0; i < 100; i++) {
            System.out.printf("%2d: %4d\n", i, count[i]);
        }
    }

    static void ex2() {
        int n = 10000;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += countPersons();
        }
        System.out.println(1.0*sum/n);
    }

    static int countPersons() {
        int[] days = new int[366];
        int n = 0;
        Die die = new Die(366);
        for (;;) {
            die.roll();
            int day = die.getNbrOfSpots();
            int pos = linearSearch(days,n,day);
            if (pos >= 0) {
                return n;
            } else {
                days[n] = day;
                n++;
            }
        }
    }

    static int linearSearch(int[] a, int n, int value) {
        for (int i = 0; i < n; i++) {
            if (a[i] == value) {
                return i;
            }
        }
        return -1;
    }

    static void ex1() {
        int[] a = {3,1,4,1};
        int n = 4;
        int value = Keyboard.nextInt("Värde: ");
        int pos = 0;
        while (pos < n && a[pos] != value) {
            pos++;
        }
        if (pos < n) {
            System.out.println("Värdet fanns i index " + pos);
        } else {
            System.out.println("Värdet fanns inte");
        }
        pos = linearSearch(a,n,value);
        if (pos >= 0) {
            System.out.println("Värdet fanns i index " + pos);
        } else {
            System.out.println("Värdet fanns inte");
        }
    }        
}
