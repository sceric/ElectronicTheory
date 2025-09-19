
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;
import se.lth.cs.pt.turtle.*;
import se.lth.cs.pt.window.*;
import se.lth.cs.pt.clock.Clock;



public class ovn323{
	
	
   public static void main (String[] args){
    
   RandomNumberGenerator rng = new RandomNumberGenerator ();
   
   TurtleWindow w= new TurtleWindow(600,600);
   Turtle t= new Turtle(w,400,400);
   Clock clock = new Clock();
   t.penDown();
   t.left(90);
   
//	   for(int i=1;i<=3;i++){   //ritas ett triangel
//	   	
//	   	t.forward(100);
//	    t.right(120);
//	   	   	
//	   }

    //om vi vill rita flera trianglar
    
        for(int k=1;k<=10;k++){
 
    	   for(int i=1;i<=3;i++){   //ritas ett triangel
	   	
    	   	t.forward(100);
	        t.right(120);
	        clock.pause(1000);
	      }
	   	   t.jumpTo(400-k*20,400-k*20);	
	   }


  }
 
}