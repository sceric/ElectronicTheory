import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;


public class UnderprogramSortV{
	
	public static void main(String[]arg){
		
		
       RandomNumberGenerator rng = new RandomNumberGenerator();
	   
	   int n=Keyboard.nextInt("Skriv antal elementer för vektorn: ");
	   
	   int []v= new int[n+1]; //måste man skriva n+1 om i lupen i=0 till n
	   int []s= new int[n+1]; // ej tillåt v.lenght och varijabel n,p,k....//
	 
 // om vi int []s= new int[n+1]; sätter istället int []s= new int[n]--vid sortering blir problem
 //JÄTTE VIKTIG: om antal ellement är n så i loopen måste vara n-1 max ele om första
 //              första ellement har index 0 dvs om i=0
 
 
 
 //OSORTERAT VEKTOR
  
       for(int i=0; i<=n;i++){                    
     
       	v[i]=rng.randInt(1,100);       //sätta värde i vektor	
 
       }
	  
	  
	   for(int k=0; k<=n-1;k++){           //skriva ut värde i vektor
	  	
	  	  System.out.println("Vektor [" +k +"]" +" = " +v[k]); 
	   }
 
   
   System.out.println();
   System.out.println("SORTERAD VEKTOR MED HJALP AV UNDERPROGRAM FOR SORTERING");
   System.out.println();
   
   System.out.println("SORTERAD VEKTOR FRAN MINSTA TILL STORSTA VARDE:");
   System.out.println();
   
   sortering(v,n);
 
   System.out.println();
   System.out.println("SORTERAD VEKTOR FRAN STORSTA TILL MINSTA VARDE:");
   System.out.println();
   
   sortering1(v,n);
   
   System.out.println();
  
}
 
 
//UNDERPROGRAM FÖR SORTERING (från minsta till störrsta värde i vektor):
 
	  static void sortering(int []s, int k){
	  	   

	  	    
	  	    for(int p=1;p<k;p++){              //här händer själva sortering
	       	
	       	int value=s[p];
	       	int pos=p;
	       	
	       	while(pos>0 && s[pos-1]>value){
	       		
	       		s[pos]=s[pos-1];
	       		pos--;
	       		
	       	}
	  
	            s[pos]=value;
	     

	        }
	  	
	  	for(int j=0;j<s.length-1;j++){
	  		
	        System.out.println("s[" +j +"]" +" = " +s[j]);  
	  	}
	  	
	  	
	
	  }
	  
  
  
  //UNDERPROGRAM FÖR SORTERING (från störrsta till minsta värde i vektor):
 
	  static void sortering1(int []s, int k){
	  	
	  	  
	  	    for(int p=1;p<k;p++){              //här händer själva sortering
	       	
	       	int value=s[p];
	       	int pos=p;
	       	
	       	while(pos>0 && s[pos-1]<value){
	       		
	       		s[pos]=s[pos-1];
	       		pos--;
	       		
	       	}
	  
	            s[pos]=value;
	     

	        }
	  	
	  	for(int j=0;j<s.length-1;j++){
	  		
	        System.out.println("s[" +j +"]" +" = " +s[j]);  
	  	}
	  	
	  	
	
	  }
  
  
  
  
}