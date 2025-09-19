import se.lth.cs.pt.random.*;
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.window.*;
import se.lth.cs.pt.turtle.*;

public class ovn94a{
	
	public static void main(String[]arg){
		
		String [] t= new String[2000];
		
		int pers=Keyboard.nextInt("Ange antal personer: ");
		System.out.println(" ");
		System.out.println("I borjan blir: ");
		System.out.println(" ");


		boolean [] open = new boolean[pers+1];
		
		for(int i=1;i<=pers;i++){
			
		 t[i]="Stengd";     //OBS!!!! använd inte tecken ' ----istället använd "
		 
		 System.out.println("["+i+"]= "+t[i]);

			
		}
		
		
	     System.out.println(" ");
		 System.out.println(" ");

       	
       	   for(int i=2;i<=pers;i++){
       	   	
       	   	     for(int p=i;p<=pers;p+=i){
       	   	     	
   					open[p]=!open[p];
       	         }
       	   	 	
       	  }
  
  
          for(int i=1;i<pers;i++){
	  
	           if(!open[i]){
	           	
	           	
	           System.out.print(i+" ");
	  
	       	   } 

		 }	


	}
}