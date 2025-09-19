
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;
import se.lth.cs.pt.turtle.*;
import se.lth.cs.pt.window.*;
import se.lth.cs.pt.clock.Clock;



public class ovn35{
	
	
   public static void main (String[] args){
    
   RandomNumberGenerator rng = new RandomNumberGenerator ();
   
   TurtleWindow w= new TurtleWindow(600,600);
   Turtle t= new Turtle(w,400,400);
   Clock clock = new Clock();
   t.penDown();
   
   int count=0;
   int firstStep=Keyboard.nextInt("Ange första steg: ");
   int lastStep=Keyboard.nextInt("Ange sista steg: ");
   int dim=Keyboard.nextInt("Minskning av steglängd: ");
   int beta=Keyboard.nextInt("Vridning efter varje steg: ");
   System.out.println(" ");
   

    
    while(firstStep>lastStep){
 	   	    
 	   	    count++;
 
    	   	t.forward(firstStep);
    	   
    	   	System.out.println("Skälpadda gå fram " +firstStep +" i " +count +" steg");
    	   	
	        t.left(beta);
	        firstStep=firstStep-dim;
	        clock.pause(1000);
	        
	       
	     
	   	   
	   }


  }
 
}