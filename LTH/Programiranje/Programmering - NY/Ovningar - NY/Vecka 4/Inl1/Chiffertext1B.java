
//program shifrera stora bokstäver

import se.lth.cs.pt.io.*;


public class Chiffertext1B {
	
	public static void main(String[]arg){
		
		//String skappa objekt som kan ej ändras
        String str = Keyboard.nextLine("Ange ett ord vilken du vill koda: "); 
        int hopp = Keyboard.nextInt("Ange nummer for kodning: ");
        char s;
        char nbr ;

        for (int i = 0; i < str.length(); i++) {
  
	        
	        char ch = str.charAt(i);
	        
	                     
               
	           if(!(ch<=('A'-1) || ch>=('Z'-1) )){
	 
	           
	            nbr= (char)(ch+hopp); 
		              	
			        if (nbr>'Z'){      
			            	           
			            s= (char)(nbr-'Z'+('A'- 1)); //ny bokstäver efter att 
			                                         //vi gick över "Z"
			            nbr=s;                       // dvs: ...XYZ ABC...                       
			             
			        }                                
			                        
		            }else{
	            	
	             nbr = ch;	
	            }
                
            System.out.print(" " +nbr);
            
            }       


       }
  

}