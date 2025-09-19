
//program desifrera stora bokstäver

import se.lth.cs.pt.io.*;


public class DeChiffertext1B {
	
	public static void main(String[]arg){
		
		//String skappa objekt som kan ej ändras
        String str = Keyboard.nextLine("Ange ett ord vilken du vill koda: "); 
        char s;
        char nbr ;
        boolean finish=false;
 
 
 while(!finish){

     int n=0;
     
     for (int k = 1; k <=25; k++) {
	       

        for (int i = 0; i < str.length(); i++) {
  
	        
	        char ch = str.charAt(i);
	        
	                     
               
	           if(!(ch<=('A'-1) || ch>=('Z'-1) )){
	 
	           
	            nbr= (char)(ch+k); 
		              	
			        if (nbr>'Z'){      
			            	           
			            s= (char)(nbr-'Z'+('A'- 1)); //ny bokstäver efter att 
			                                         //vi gick över "Z"
			            nbr=s;                       // dvs: ...XYZ ABC...                       
			             
			        }                                
			                        
		            }else{
	            	
	             nbr = ch;	
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