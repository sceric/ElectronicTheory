import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;


public class SokSortV{
	
	public static void main(String[]arg){
		
		
       RandomNumberGenerator rng = new RandomNumberGenerator();
	   
	   int n=Keyboard.nextInt("Skriv antal elementer för vektorn: ");
	   
	   int []v= new int[n]; //måste man skriva n+1 om i lupen i=0 till n
	   int []s= new int[n]; // ej tillåt v.lenght och varijabel n,p,k....//
	 
 
 //JÄTTE VIKTIG: om antal ellement är n så i loopen måste vara n-1 max ele om första
 //              första ellement har index 0 dvs om i=0
 
 
 
 //OSORTERAT VEKTOR
  
       for(int i=0; i<=n-1;i++){                    
     
       	v[i]=rng.randInt(1,100);       //sätta värde i vektor	
 
       }
	  
	  
	   for(int k=0; k<=n-1;k++){           //skriva ut värde i vektor
	  	
	  	  System.out.println("Vektor [" +k +"]" +" = " +v[k]); 
	   }



 //SORTERING (Insätnings)
 
 
       for(int p=1;p<=n-1;p++){
       	
       	int value=v[p];
       	int pos=p;
       	
       	while(pos>0 && v[pos-1]>value){
       		
       		v[pos]=v[pos-1];
       		pos--;
       		
       	}
  
     v[pos]=value;
	      
  }

  System.out.println(" "); 
  System.out.println(" "); 
  System.out.println("Sorterad vektor: "); 
  System.out.println(" "); 
  System.out.println(" "); 
  
  
  	   for(int m=0; m<=n;m++){           //skriva ut sorterade värde i vektor
	  	
		  	    System.out.println("Vektor [" +m +"]" +" = " +v[m]); 
		   }
		   
	
//SÖKNING I SORTERAT VEKTOR

	         int value1=Keyboard.nextInt("Sok verde: ");
	         int poss1=0;
	    
	         while(poss1<n && v[poss1]<value1){
	    	
	        	poss1++;
	    	
	      }
	
	      if(poss1<n && v[poss1]==value1){
	    	
	            System.out.println("Vi hitade verde po plac numer " +poss1);	
	 
	      }else{
	
	            System.out.println("Vi hitade INTE verde");
	
	      }	



	   
  }
}