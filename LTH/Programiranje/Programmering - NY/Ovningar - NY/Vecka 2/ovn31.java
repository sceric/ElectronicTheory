
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;
import se.lth.cs.pt.die.*;



public class ovn31{
	
	
   public static void main (String[] args){
    
   RandomNumberGenerator rng = new RandomNumberGenerator ();

   Die die = new Die();

 
   die.roll();

   
   boolean finish=false;
   int count=0;
   int num1=0;
   int num2=0;
   
   do{
   	
   	   die.roll();
       count++;
       
       num1=die.getNbrOfSpots();
       
       			System.out.println(" ");
			   	System.out.println("Nummer " +num1);
			   	System.out.println(" ");
       
       if(num1==num2){
       	
       	   System.out.println("Nummer " +num1 +" har komitt två gånger i rad vid " +count +" kast");

           System.out.println(" ");
           
           finish=true;
       	
       }
					   	
 
   	   num2=num1;
   	   
   	
   }while(!finish);
 




  }
 
}