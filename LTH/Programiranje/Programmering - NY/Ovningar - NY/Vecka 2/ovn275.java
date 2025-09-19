
import se.lth.cs.pt.io.*;



public class ovn275{
	
	
	public static void main (String[] args){
		

		int a =Keyboard.nextInt("Skriv tal A: ");
		int b =Keyboard.nextInt("Skriv tal B: ");
		int temp;
		System.out.println(" ");

        if(a>b){
        
        temp=a;
        a=b;
        b=temp;
        System.out.println("A= "+a +" och B= "+b +"(A var innan store en B)");	
        	
        }else if(b>a){
        	
        	temp=b;
        	b=a;
        	a=temp;
        	
       System.out.println("B= "+b +" och A= "+a +"(B var innan store en A)");
        	
        	
        }else{
        	
       System.out.println("Det er inte meningen att bitta samma nummer!");
        	
        }
		
		
		
		
	}
	
	
	
}