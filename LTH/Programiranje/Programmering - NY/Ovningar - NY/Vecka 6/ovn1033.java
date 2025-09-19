import se.lth.cs.pt.random.*;
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.window.*;
import se.lth.cs.pt.turtle.*;
import se.lth.cs.pt.window.Color;


public class ovn1033{
	
	public static void main(String[]arg){
		
 
    
    int n=Keyboard.nextInt("Andje antal elementer som du vill tilldela slumpmesigt till vektor: ");

    int []s= new int[n];
    int []w= new int[n];
      
      System.out.println();
      System.out.println();

      
    vektorVerde(s,n); // vektor och antal elementer bestäms...
     
      System.out.println();
      System.out.println();
      System.out.println("Vi kopierar vektor s till vektor w och resultat bilr då: ");
      System.out.println();


    copy(s,w,n); // här kopiera vi vektor s till vektor w

      System.out.println();
      System.out.println();


//UNDER PROGRAM: TILDELA VERDE PÅ VEKTOR
 
}

 	
		static void vektorVerde(int []s,int n){  //här vi kopla med en vektor som är utanför
												 //underprogramet	
		 RandomNumberGenerator rng = new RandomNumberGenerator();
           
           for(int i=0;i<=n-1;i++){
           
           int value=rng.randInt(1,6);
               s[i]=value;
               
               System.out.println("s["+i+"]= "+s[i]);
      	
			    }
			
		}
  
       static void copy(int[]s,int[]w,int n){
       	
       	  for(int i=0;i<=n-1;i++){
       	  	
       	  	w[i]=s[i];
       	  	
       	  	System.out.println("w["+i+"]= "+w[i]);
       	  }
       	      	
       	
       }
       
       
 } 