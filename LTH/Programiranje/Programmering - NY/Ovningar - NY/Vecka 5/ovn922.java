import se.lth.cs.pt.random.*;
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.window.*;
import se.lth.cs.pt.turtle.*;
import se.lth.cs.pt.die.Die;
import se.lth.cs.pt.clock.Clock;

public class ovn922{
	
	public static void main(String[]arg){

//   OBS!!! Uppgift är lite modifierat så att vi matta in antal söldpaddor samt
//          antal maximal steg,samt införde venster och höger...rätt cool om man 
//          kör 50 söldpaddor och maximal antal 10 000 ;)		
		
		TurtleWindow win = new TurtleWindow(600,600); 
		int nbrOfTurtle=Keyboard.nextInt("Age antal skoldppador: ");
		int maxSum=Keyboard.nextInt("Age maximal antal steg: ");

        RandomNumberGenerator rng = new RandomNumberGenerator();
		Turtle[] t = new Turtle[20000];
		Die die = new Die();
		Clock clock=new Clock();
		
		boolean finish=false;
		int sum=0;
		
		for(int i=1;i<=nbrOfTurtle;i++){
			
			t[i]= new Turtle(win,300,300);
			t[i].penDown();
						
		}

      while(!finish){
		for(int k=1;k<=nbrOfTurtle;k++){
			
			die.roll();
			t[k].forward(die.getNbrOfSpots());			
			t[k].right(rng.randInt(0,180));			
			t[k].left(rng.randInt(0,180));

		      if(sum>=maxSum){
		      	
		      	finish=true;
		      	
		      	}	
         }
       
       clock.pause(50);
       sum+=die.getNbrOfSpots();
       
	  }
			
			           

	}
	
	
}
