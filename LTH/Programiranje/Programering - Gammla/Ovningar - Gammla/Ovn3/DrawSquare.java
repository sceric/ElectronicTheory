import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.turtle.Turtle;


public class DrawSquare {

     public static void main(String[] args) {

        SimpleWindow w = new SimpleWindow(600,600,"Square");             
        Turtle t= new Turtle(w,100,200);               
        int k;
        t.penDown();
        for (k=1; k<=4; k++) {
            t.right(90);
            t.forward(300);
        }
    }
}