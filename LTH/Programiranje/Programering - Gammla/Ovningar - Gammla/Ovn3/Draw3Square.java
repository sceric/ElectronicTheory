import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.turtle.Turtle;

public class Draw3Square {

    public static void main(String[] args) {

        SimpleWindow w = new SimpleWindow(600,600,"Square");             
        Turtle t= new Turtle(w,100,200);               
        int k,i;
        t.penDown();
        for (k=1; k<=3; k++) {
            t.jumpTo(t.getX()+20, t.getY()+20);
		     for (i=1;i<=4; i++) {
			 t.right(90);
			 t.forward(100);
		     }
		  }
	}
}