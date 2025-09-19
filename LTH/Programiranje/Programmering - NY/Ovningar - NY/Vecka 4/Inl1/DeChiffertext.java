
//program desifrera stora bokstäver.char är inventerat till int och sen tillbcka
import se.lth.cs.pt.io.*;


public class DeChiffertext {
	
	public static void main(String[]arg){
		
   // String skappa objekt som kan ej ändras!
   String str = Keyboard.nextLine("Ange ett text vilken du vill deshifrera: "); 
        boolean finish=false;
        int s = 0;
        int nbr = 0;
      
      while(!finish){
 
         int n=0;
         
	     for (int k = 1; k <=25; k++) {
	       
	         for (int i = 0; i < str.length(); i++) {
	  
		        
		        char ch = str.charAt(i);
		        
		        int p = (char)ch;               
	               
		           if(!(p<=64 || p>=91 )){
		 
		            nbr= p + k; 
			              	
				        if (nbr>90){      
				            	           
				            s= nbr-90+64;
				            
				            nbr=s;
				             
				        }
				                        
			            }else{
		            	
		             nbr = p;	
		            }
	                
	            System.out.print(" " +(char)nbr);
	            
	            }    
	            
	            System.out.println("  ");
	            n++;   

        }

       
       if(n==25){
       	
       	finish=true;
       	
       }
 
 
    }



       }
  

}