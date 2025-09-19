
import se.lth.cs.pt.io.*;


public class Tecken2 {
	
	public static void main(String[]arg){
		
		
        String str = Keyboard.next("Ange ett ord: "); //skappa objekt som kan ej ändras


        int nbr = 0;
       


       System.out.println("Redni broj slova abecede u stringu :");


        for (int i = 0; i < str.length(); i++) {
  
 
            char ch = str.charAt(i);

            if(ch<='Z'){
            
            	nbr = (char)ch - 64;    // (char)ch konvertira till int
                        
            }else{
            	nbr = (char)ch - 96;
            }

        System.out.print(" " +nbr);

        }
        
        
        
    }


}