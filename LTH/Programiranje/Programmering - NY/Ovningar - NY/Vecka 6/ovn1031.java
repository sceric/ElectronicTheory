import se.lth.cs.pt.random.*;
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.window.*;
import se.lth.cs.pt.turtle.*;
import se.lth.cs.pt.window.Color;


public class ovn1031{
	
	public static void main(String[]arg){
		
 
    
    int n=Keyboard.nextInt("Andje antal elementer som du vill tilldela slumpmesigt till vektor: ");

    int []t= new int[1000];
      
      System.out.println();
      System.out.println();

 
    
    vektorVerde(n);  //bara antal elementer bestäms...vilken vektor,står i underprogramet
     
      System.out.println();
      System.out.println();
      
    vektorVerde1(t,n); // vektor och antal elementer bestäms...
     
      System.out.println();
      System.out.println();




//UNDER PROGRAM
 
}


        static void vektorVerde(int n){   //OBS!!! i under programet impoteras
        								  //objekt som ska utnytjas
        int []v= new int[1000];
        RandomNumberGenerator rng = new RandomNumberGenerator();
           
           for(int i=0;i<=n-1;i++){
           
           int value=rng.randInt(1,6);
               v[i]=value;
               
               System.out.println("v["+i+"]= "+v[i]);
      	
			    }

		}
	
		static void vektorVerde1(int []t,int n){  //här vi kopla med en vektor som är utanför
												  //underprogramet	
		 RandomNumberGenerator rng = new RandomNumberGenerator();
           
           for(int i=0;i<=n-1;i++){
           
           int value=rng.randInt(1,6);
               t[i]=value;
               
               System.out.println("t["+i+"]= "+t[i]);
      	
			    }
			
		}
  
 } 