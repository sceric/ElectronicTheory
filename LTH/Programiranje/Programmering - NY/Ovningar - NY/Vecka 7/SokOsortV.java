import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;


public class SokOsortV{
	
	public static void main(String[]arg){
		
		
       RandomNumberGenerator rng = new RandomNumberGenerator();
	   
	   int n=Keyboard.nextInt("Skriv antal elementer för vektorn: ");
	   
	   int []v= new int[10000000]; //OBS! i [1000000] måste vara cifra...ej//
	   
  								   //tillåt v.lenght och varijabel n,p,k....//
  
       for(int i=0; i<=n;i++){    
     
       	v[i]=rng.randInt(1,100);       //sätta värde i vektor	
 
       }
	  
	  
	   for(int k=0; k<=n;k++){           //skriva ut värde i vektor
	  	
	  	  System.out.println("Vektor [" +k +"]" +" = " +v[k]); 
	   }

 
 
       int value=Keyboard.nextInt("Skrev värde som du vill söka: ");

       int pos=0;
       
 //SÖKNING I OSORTERAT VEKTOR:
 
 
         while (pos <n && v[pos]!=value && v[pos] !=0 ) {  //v[pos] != null om vi käner ej antal
														   //elementer i vektorer
         pos++;
         
         }

	        if(pos<n){
	
	        	System.out.println(" ");
	        	System.out.println("Värdet fanns i index " + pos);
	        	
	        
	        }else{
	        	
	        	System.out.println("Värdet fanns INTE ");
	        }
	      

  }


}