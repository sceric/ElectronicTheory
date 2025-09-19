import se.lth.cs.pt.random.*;
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.window.*;
import se.lth.cs.pt.turtle.*;
import se.lth.cs.pt.clock.Clock;

public class ovn81{
	
	public static void main(String[]arg){
		
		RandomNumberGenerator rng = new RandomNumberGenerator();
		TurtleWindow win = new TurtleWindow(600,600);             
        Turtle t = new Turtle(win,300,300);//skapas en sköldpadda
        Clock clock = new Clock();
        
        int sum=0;
        int count=0;
        boolean finish=false;
        t.penDown();
        
   while(!finish){
        int steg=rng.randInt(1,5);
        sum+=steg;
 
        if(sum>1000){

        	steg=sum-1000;
        	sum=1000;
        }

        int angleL=rng.randInt(0,360);
        int angleR=rng.randInt(0,360);
        t.forward(steg);
        t.left(angleL);
        t.right(angleR);
        
        count++;
        if(sum==1000){
        
     	finish=true;
     	       	
        }
        clock.pause(50);
        System.out.printf("%2d: %3d\n", count, sum);       
    }
      System.out.println("Antal varv som man körde att uppnå 1000 steg är: "+count); 
       
	}
}