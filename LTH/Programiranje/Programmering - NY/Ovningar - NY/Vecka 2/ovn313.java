
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;
import se.lth.cs.pt.die.*;



public class ovn313{
	
	
   public static void main (String[] args){
    
   RandomNumberGenerator rng = new RandomNumberGenerator ();

   Die die1 = new Die();
 
   die1.roll();        //antas att tärningen får värde tex 2
   System.out.println("1.die1: " +die1.getNbrOfSpots());
   System.out.println(" ");
   
   Die die2=die1; //tärningen får värde tex 2



   die1 = new Die();
   
   die1.roll();        //antas att tärningen får värde tex 4
   System.out.println("2.die1: " +die1.getNbrOfSpots());
   System.out.println(" ");
   

       
   
   System.out.println("die2: " +die2.getNbrOfSpots());
   System.out.println(" ");
   



  }
 
}