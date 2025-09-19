
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;
import se.lth.cs.pt.turtle.*;
import se.lth.cs.pt.window.*;
import se.lth.cs.pt.clock.Clock;

//OBS!!!!!!!!!!!!
//den uppgift är redan gjort...uppgift 4.2.1 är körbart och det här är bara
//en kopia av uppgiften



public class ovn512{
	
	
   public static void main (String[] args){
    
   RandomNumberGenerator rng = new RandomNumberGenerator ();
   
   
    int a=Keyboard.nextInt("Skriv tal a: ");
    System.out.println(" ");
    int b=Keyboard.nextInt("Skriv tal b: ");
    System.out.println(" ");

    int c=a/b;

      
    System.out.println("c=a/b är "+c);

    
    

  }
 
}