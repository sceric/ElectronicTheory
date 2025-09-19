import se.lth.cs.pt.random.*;
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.window.*;
import se.lth.cs.pt.turtle.*;
import se.lth.cs.pt.window.Color;


public class ovn1021{
	
	public static void main(String[]arg){
		
 

    int n=Keyboard.nextInt("Andje antal elementer som du vill summera: ");
    
    sum(n);
        
      System.out.println();
      System.out.println();

    int p=Keyboard.nextInt("Andje igen antal elementer som du vill summera: ");
    
    sum(p);
     
      System.out.println();
      System.out.println();

//UNDER PROGRAM
 
}


        static int sum(int n){ 
          
          int sum1=0;
  
	   		for (int i=1;i<=n;i++){
	
	          sum1+=i;
				  
	
			    }

		   System.out.println("Summa är: "+sum1);
		   return sum1; 
//		   System.out.println("Summa är: "+sum1);
		 }   

	
		
  
 } 