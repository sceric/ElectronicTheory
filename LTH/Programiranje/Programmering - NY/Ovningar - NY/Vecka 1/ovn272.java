
import se.lth.cs.pt.io.*;



public class ovn272{
	
	
	public static void main (String[] args){
		

		int r=Keyboard.nextInt("Skriv en negativ tal: ");
		System.out.println(" ");

		if(r<0){
			
			r=r*(-1);
			System.out.println("Tal är pozitiv och det är " + r);
			
		}else if(r>0){
			
			System.out.println("Tal är pozitiv!");
			
		}else{
			
			System.out.println("Tal är noll!");
		}	

		
		
		
		
	}
	
	
	
}