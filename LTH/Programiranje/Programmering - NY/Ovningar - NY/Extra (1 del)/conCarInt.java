
import se.lth.cs.pt.io.*;


public class conCarInt {
	
	public static void main(String[]arg){
		
	 int nbr;	
      
     char ch='A';            //konventera char till int
     
     nbr=ch;                 // eller man kan skirva; int nbr=(char)ch
      
        System.out.println(" " +nbr);
        System.out.println(" ");
        
        
        
      int c=66; 
      
      char p=(char)c;       //konventera int till char
        
         System.out.println(" " +p);
         System.out.println(" ");
    
      char k = (char)(p+ch -10);               //OBS! OBS!
      
          System.out.println(" " +k);
          System.out.println(" ");
    
        
       }
  

}