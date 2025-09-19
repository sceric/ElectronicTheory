
import se.lth.cs.pt.io.*;



public class ovn53{
	
	
	public static void main (String[] args){
 
     System.out.println(" ");
     System.out.println("En ekvation har följande almena utryck: a*x^2+b*x+c=0");
     
     double a=Keyboard.nextDouble("Skriv koeficient a: ");
     double b=Keyboard.nextDouble("Skriv koeficient b: ");
     double c=Keyboard.nextDouble("Skriv koeficient c: ");
     
     
     double x1= -(b/(2*a))+ Math.sqrt((b/(2*a)*(b/(2*a)-c/a)));
     double x2= -(b/(2*a))- Math.sqrt((b/(2*a)*(b/(2*a)-c/a)));
   
     if((Math.sqrt((b/(2*a)*(b/(2*a)-c/a)))<0.00001)){
       
       System.out.println(" ");	
       System.out.println("Det är dubbelrot i "+x1);

     }else if(((b/(2*a)*(b/(2*a)-c/a))<0)){
     	
     	System.out.println(" ");
     	System.out.println("Inga reella rötter");
     	
     }else{
     	
     	System.out.println(" ");
     	System.out.println("En rot är "+x1 +" och den andra är " +x2);
     
    }
    
  System.out.println(" ");
  
 } 

}
 


