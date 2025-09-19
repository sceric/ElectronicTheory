
import se.lth.cs.pt.io.*;



public class ovn542{
	
	
	public static void main (String[] args){
    
    char x=Keyboard.nextChar("Skriv tal x: ");
    int y=Keyboard.nextInt("Skriv tal y: ");
    
    if(x>0 && y>0){   // x>0 och y>0
    	
        	System.out.println(" ");
    	    System.out.println("Geller vilkor: x>0 && y>0");
    	    
    }	
    	
    if(x<0 || y<0){  //x<0 eller y<0
    	
        	System.out.println(" ");
    	    System.out.println("Geller vilkor: x<0 || y<0");	
    	
    }
    
        if((x<0 && y>0)||(x>0 && y<0)){ //(x<0 och y>0)eller(x>0 och y<0)...dvs inte båda
    									//samtidligt större av 0
        	System.out.println(" ");
    	    System.out.println("Geller vilkor: (x<0 && y>0)||(x>0 && y<0)");	
    	
    }
    	
    System.out.println(" ");
      	
    }
    


}
 


