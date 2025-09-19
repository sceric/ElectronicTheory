import se.lth.cs.pt.random.*;
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.window.*;
import se.lth.cs.pt.turtle.*;

public class ovn94{
	
	public static void main(String[]arg){
		
		int [] t= new int[2000];
		
		int pers=Keyboard.nextInt("Ange antal personer: ");
		System.out.println(" ");
		System.out.println("I borjan blir: ");
		System.out.println(" ");
		int p=1;

		
//		for(int i=1;i<=pers;i++){
//			
//		 t[i]="Stengd";     //OBS!!!! använd inte tecken ' ----istället använd "
//		 
//		 System.out.println("["+i+"]= "+t[i]);
//		 System.out.println(" ");
//		 System.out.println(" ");
//			
//		}

       
     
       	   for(int k=2;k<=pers-1;k++){
       	   	
       	   	     for(k=p;k<=pers;k=k+p){
       	   	     	
       	   	     	if(t[k]==1){   //Jämförs två strengar
       	   	     		
       	   	     		t[k]=2;
       	   	     		
       	   	     	}
       	   	     	if(t[k]==2){
       	   	     		
       	   	     		t[k]=1;
       	   	     		
       	   	     	}
       	   	     	
       	   	     	
       	   	  	}   
       	   	     	
       	      System.out.println("["+k+"]= "+t[k]);  		
       	   }
       	   	      

       	
       	
       	  for(int s=1;s<=100;s++){
       	  	
       	       if(t[s]==2){
               System.out.println("["+s+"]= "+t[s]);	
       	  	
       	  	
       	  }
       	     	
       	
       }
       




	}
}