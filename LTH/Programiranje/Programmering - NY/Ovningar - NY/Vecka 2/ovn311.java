
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;
import se.lth.cs.pt.die.*;



public class ovn311{
	
	
   public static void main (String[] args){
    
   RandomNumberGenerator rng = new RandomNumberGenerator ();

   Die die1 = new Die();
   Die die2 = new Die(); //(rad 2)
   
   die1.roll();        //antas att tärningen får värde tex 4

   System.out.println("die1: " +die1.getNbrOfSpots());
   System.out.println(" ");
  
   die2.roll();        //antas att tärningen får värde tex 2
   
   System.out.println("die2: " +die2.getNbrOfSpots());
   System.out.println(" ");
   
   die1=die2;         //die1 får värde 2
   
   System.out.println("die1=die2: " +die1.getNbrOfSpots());
   System.out.println(" ");
   
   die2=null;
   
   
//   Svar på frågor: 	1. Program innehåller 12 referensvariabel (die1 och die2)
//   					2. Två objekt skapas
//   					3. På rad två (titta uppe) skapas namlös objek (die2 referera till den)
//   					4. Vi får utskrift 2 (om vi antar de uppe texeplerna)
//   					5. Efter sista rad finns bara ett objekt tillgenligt (det är die1)
//   					   pga sista objekt referera null dvs: die2=null; och die2 försviner
   

  }
 
}