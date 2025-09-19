
import se.lth.cs.pt.io.*;



public class ovn282{
	
	
	public static void main (String[] args){
		

     System.out.println("Ange en foljd av tal och avsluta med 'noll'!");
     System.out.println(" ");

     int temp=0;
     int count=0;
     int n=0;
     int a =Keyboard.nextInt(" ");
     
     while(a!=0){
         count++;
		
		
		if(a>temp){
			
			temp=a;
			
			n=count;
			
		}
	 a =Keyboard.nextInt(" ");			

	}
	
	System.out.println("Stersta tal är" +temp +"och det er po plac nummer " +n);
	
 } 

}