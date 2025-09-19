
//program shifrera stora bokstäver...konventerat char till int och tillbacka
import se.lth.cs.pt.io.*;


public class Chiffertext {
	
	public static void main(String[]arg){
		
		//String: skappa objekt som kan ej ändras
        String str = Keyboard.nextLine("Ange ett ord vilken du vill koda: "); 
        int hopp = Keyboard.nextInt("Ange nummer for kodning: ");
        int s = 0;
        int nbr = 0;
      

        for (int i = 0; i < str.length(); i++) {
  
	        
	        char ch = str.charAt(i);
	        
	        int p = (char)ch;               
               
	           if(!(p<=64 || p>=91 )){
	 
	            nbr= p + hopp; 
		              	
			        if (nbr>90){      
			            	           
			            s= nbr-90+64;  //ny bokstäver efter att vi gick över "Z"
			            
			            nbr=s;         //dvs: ...XYZ ABCD...
			             
			        }
			                        
		            }else{
	            	
	             nbr = p;	
	            }
                
            System.out.print(" " +(char)nbr);
            
            }       


       }
  

}