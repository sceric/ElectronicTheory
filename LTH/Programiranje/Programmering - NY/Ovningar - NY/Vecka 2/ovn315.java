
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;
import se.lth.cs.pt.die.*;



public class ovn315{
	
	
   public static void main (String[] args){
    
   RandomNumberGenerator rng = new RandomNumberGenerator ();

   Die die1 = new Die();
   Die die2 = new Die();
 
   die1.roll();
   die2.roll();
   
   boolean finish=false;
   int count=0;
   
   do{
   	
   	   die1.roll();
       die2.roll();
 
       count++;
       
       if(die1.getNbrOfSpots()==die2.getNbrOfSpots()){
       	
       	   System.out.println("die1=die2: " +die1.getNbrOfSpots());
           System.out.println(" ");
           System.out.println("Man måste kasta: " +count +" gånger");
           System.out.println(" ");
           
           finish=true;
       	
       }
   	
   	  
   	
   }while(!finish);
 




  }
 
}