import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.turtle.Turtle;
import se.lth.cs.pt.io.ConsoleReader;

    public class D38 {

	public static void main(String[] args) {

	    SimpleWindow w = new SimpleWindow(600,600,"Square");             
	    Turtle t= new Turtle(w,300,300);
	    ConsoleReader reader= new ConsoleReader();

	    int firstStep,lastStep,dim,beta,k;
	    firstStep = reader.readInt();
	    lastStep = reader.readInt();
	    dim = reader.readInt();
	    beta = reader.readInt();
	    t.penDown();
	    while (firstStep > lastStep) {

		t.forward(firstStep);
		t.left(beta);
		k = firstStep;
		firstStep= k -dim;
	    }
	}				      
  }	    