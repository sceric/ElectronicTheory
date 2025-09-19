
import se.lth.cs.pt.io.*;



public class ovn552{
	
	
	public static void main (String[] args){
 
 
  System.out.println(" ");   
  System.out.println("Man får följande utskrift: ");
  System.out.println(" ");
  
    for(char ch='a';ch<='Z';ch++){  //här man får ingen utskrift OBS!!! lila 'a'ligger
									//efter 'Z' i ASCII ordningen
    System.out.print(ch);
    
     }
  
  System.out.println(" "); 
  
  
      for(char ch='a';ch<='z';ch++){ //här man får utskrift OBS!!! lila 'a'ligger
									 // före lila 'z' i ASCII ordningen
       System.out.print(ch);
    
     }

  System.out.println(" "); 
      	
    }
    


}
 


