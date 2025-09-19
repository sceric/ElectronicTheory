import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.turtle.Turtle;


public class D37 {   

public static void main(String[] args) {
        SimpleWindow w = new SimpleWindow(600,600,"Square");             
        Turtle t= new Turtle(w,100,200);               

        while (true) {
	    w.waitForMouseClick();
	    int a=w.getMouseX();
	    int b=w.getMouseY()
	    t.jumpTo(a,b);
	    t.penDown();
	    for(int k=1;k<=4; k++) {
		 t.right(90);
		 t.forward(100);
	    }
	}
    }
}     