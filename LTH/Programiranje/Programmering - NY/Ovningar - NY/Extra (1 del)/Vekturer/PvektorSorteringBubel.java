import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;


public class PvektorSorteringBubel{
	
	public static void main(String[]arg){
		
		
       RandomNumberGenerator rng = new RandomNumberGenerator();
	   
	   int n=Keyboard.nextInt("Skriv antal elementer för vektorn: ");
	   
	   int []v= new int[100]; //OBS! i [1000000] måste vara cifra...ej//
	   int []s= new int[100]; //tillåt v.lenght och varijabel n,p,k....//
	 
 
 
 
 
 
 //OSORTERAT VEKTOR
  
       for(int i=0; i<=n;i++){    
     
       	v[i]=rng.randInt(1,100);       //sätta värde i vektor	
 
       }
	  
	  
	   for(int k=0; k<=n;k++){           //skriva ut värde i vektor
	  	
	  	  System.out.println("Vektor [" +k +"]" +" = " +v[k]); 
	   }






//INSÄTNINGS I OSORTERAT VEKTOR
        n++;
        v[n]=Keyboard.nextInt("Sätt värde i vektor: ");
        
    System.out.println(" "); 
    System.out.println(" ");         
    System.out.println("Nu har vektor värde efter insättnings: "); 
    System.out.println(" "); 
    System.out.println(" "); 
  
  
  	   for(int c=0; c<=n;c++){           //skriva ut sorterade värde i vektor
	  	
	  	  System.out.println("Vektor [" +c +"]" +" = " +v[c]);
	  	}
 




 //BUBLE SORTERING (Insätnings)
 
 boolean sorted = false;
 int top=0;

    while(!sorted){
        
        sorted=true;
        for(int poss=n;poss>top;poss--){     //om vi har inte insättning man skall
        	  								// skriva int poss=n-1 i for sats
        	  if(v[poss]<v[poss-1]){
        	  	
        	  	sorted=false;
        	  	int temp=v[poss-1];
        	  	v[poss-1]=v[poss];
        	  	v[poss]=temp;
        	    
        	  	
        	  }
      
      
      
        	}
        	       		   	
    }
 

  System.out.println(" "); 
  System.out.println(" "); 
  System.out.println("Sorterad vektor: "); 
  System.out.println(" "); 
  System.out.println(" "); 
  
  
  	   for(int m=0; m<=n;m++){           //skriva ut sorterade värde i vektor
	  	
	  	  System.out.println("Vektor [" +m +"]" +" = " +v[m]); 
	   }
	   

	   
  }
}