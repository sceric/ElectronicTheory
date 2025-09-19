
import se.lth.cs.pt.die.*;
import se.lth.cs.pt.io.*;

class Extra6 {

    public static void main(String[] args) {
        int n = Keyboard.nextInt("Antal spelare: ");
        Die[] die = new Die[n];
        for (int i = 0; i < n; i++) {
            die[i] = new Die();
        }
        int[] points = new int[n];
        boolean finished;

        do {
            finished = true;
            // Genomför en spelomgång för varje spelare:
            for (int i = 0; i < n; i++) {
                die[i].roll();
                while (die[i].getNbrOfSpots() % 2 == 0) {
                    points[i] += die[i].getNbrOfSpots();
                    die[i].roll();
                }
                if (points[i] < 100) {
                    finished = false;
                }
            }
        } while (finished == false);

        int biggest = 0;
        for (int i = 0; i < n; i++) {
            if (points[i] > biggest) {
                biggest = points[i];
            }
        }
        System.out.print("Vinnare är: ");
        for (int i = 0; i < n; i++) {
            if (points[i] == biggest) {
                System.out.print((i+1) + " ");
            }
        }
        System.out.println();
    }
}
