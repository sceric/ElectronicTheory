import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;


public class PvektorInsetISort{
	
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
 




 //SORTERING (Insätnings)
 
 
       for(int p=1;p<=n;p++){
       	
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
	   





//INSÄTNINGS I SORTERAD VEKTOR

    
    int invalue=Keyboard.nextInt("Sätt verde i vektor: ");
    n++;
    int pos1=n;

    while(pos1>0 && v[pos1-1]>invalue){
    	
    	v[pos1]=v[pos1-1];
    	pos1--;
    	
    	}	   

    v[pos1]=invalue;
    
 

    System.out.println(" "); 
    System.out.println(" "); 
    System.out.println("Sorterad vektor: "); 
    System.out.println(" "); 
    System.out.println(" "); 
  
  
  	   for(int j=0; j<=n;j++){           //skriva ut sorterade värde i vektor
	  	
	  	  System.out.println("Vektor [" +j +"]" +" = " +v[j]); 
	   }


	   
  }
}