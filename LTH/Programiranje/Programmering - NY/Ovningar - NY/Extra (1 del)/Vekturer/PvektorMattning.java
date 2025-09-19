import se.lth.cs.pt.io.*;
import se.lth.cs.pt.turtle.Turtle;
import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.random.*;


public class PvektorMattning{
	
	public static void main(String[]arg){
		
		
		//SimpleWindow win = new SimpleWindow(600,600,"Kornjace");             
    	RandomNumberGenerator rng = new RandomNumberGenerator();
		ConsoleReader r = new ConsoleReader();
	    ConsoleWriter w = new ConsoleWriter();
	   
	   int n=r.readInt("Skriv antal elementer för vektorn: ");
	   
	   int []v= new int[10000000]; //OBS! i [1000000] måste vara cifra...ej//
	   
  								   //tillåt v.lenght och varijabel n,p,k....//
  
       for(int i=0; i<=n;i++){    
     
       	v[i]=rng.randInt(1,5);       	
 
       }
	  
	  
	   for(int k=0; k<=n;k++){
	  	
	  	  w.println("Vektor [" +k +"]" +"har värde" +v[k]);
	   }


	}
}