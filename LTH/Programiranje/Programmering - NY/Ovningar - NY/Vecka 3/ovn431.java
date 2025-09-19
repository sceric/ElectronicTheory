
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;
import se.lth.cs.pt.turtle.*;
import se.lth.cs.pt.window.*;
import se.lth.cs.pt.clock.Clock;

//OBS!!!!!!!!!!!!
//den uppgift är redan gjort...uppgift 4.2.1 är körbart och det här är bara
//en kopia av uppgiften



public class ovn431{
	
	
   public static void main (String[] args){
    
   RandomNumberGenerator rng = new RandomNumberGenerator ();
   
//   Uppgift:
//   Indata består av en växande följd av positiva heltal avslutade me en 0:a.
//   Skrev ett program som läser in talföljden och skriver ut de tal som är felplacerade.
   
   
   
    int temp=0;
    int count=1;
    int nbr=Keyboard.nextInt("Ange tal feljd i vexande ordning...avsluta med 'noll': ");
    
    while(nbr!=0){
 	   	    
 	        temp=nbr;
            count++;
            nbr=Keyboard.nextInt("Next tal: ");
            
            if(temp<nbr){
            	
            	System.out.println("Det är fel,nummer " +nbr +" på platc " +count +" !");
            	
            }
           
	       
	     
	   	   
	   }


  }
 
}