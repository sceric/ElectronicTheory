import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;

public class ovn114{
	
	public static void main(String[]arg){
		
		RandomNumberGenerator rng = new RandomNumberGenerator();
        int n=rng.randInt(1,100);
        boolean finish=false;
        int count=0;
    
        int nbr=Keyboard.nextInt("Skriv ett tal melan 1 och 100: ");
        
        System.out.println();
 

  do{
  	
  	
 
  	  
  	  if(n<nbr){
  	
  	  	System.out.print("Din tal ar storre!");
  	  	nbr=Keyboard.nextInt(" Ar det: ");

      }else if(n>nbr){
      	
	  	
  	   System.out.print("Din tal ar  mindre!");
  	   nbr=Keyboard.nextInt(" Ar det: ");
 
  	  	
      }else{
  	
  		finish=true;
  	
      }
  	
  	count++;

  	
  	
  	
  }while(!finish);
	

 	
 	
    System.out.println();
    System.out.println("OK,jag lyckas på " +count+" försök!");
    System.out.println();
    
    
    
    }   
 } 
 


