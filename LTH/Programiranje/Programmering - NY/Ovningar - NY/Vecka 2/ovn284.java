
import se.lth.cs.pt.io.*;



public class ovn284{
	
	
	public static void main (String[] args){
     
     int n=Keyboard.nextInt("Ange max nummer: ");
     
     
     System.out.println(" ");
     System.out.println("Negativa tal är :");
     System.out.println(" ");
  
//genom att i varje steg öka räknarvariablen med 2

	for(int i=1;i<n;i=i+2){
	
	System.out.print(" " +i);
	
    }
    System.out.println(" ");
    System.out.println(" ");
    System.out.println(" ");	

//genom att i varje steg öka räknarvariabeln med 1

	for(int i=1;2*i-1<n;i=i+1){

	
	System.out.print(" " +(2*i-1));
	
    }
    System.out.println(" ");



 } 

}