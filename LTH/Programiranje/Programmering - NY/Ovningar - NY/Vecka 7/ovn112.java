import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;

public class ovn112{
	
	public static void main(String[]arg){
		
		RandomNumberGenerator rng = new RandomNumberGenerator();
        int n=rng.randInt(1,100);
		int []v= new int[n];
	
        for(int i=0;i<=n-1;i++){
        	
        v[i]=rng.randInt(1,1000);
        
        System.out.println("v["+i+"] = "+v[i]);	
        }
        
        System.out.println();	
        System.out.println();	
        System.out.println();	


//OBS! EJ SORTERAT VEKTOR(OM DU VILL KOLA HUR DET FUNKA MED SORTERAT KOLLA DÅ UPPGIFT 11.3    

 
  
  //Finns summa av två tal i vektor som är lika med den som du vill ha
  

  int value=Keyboard.nextInt("Sätt värde (vi vill hitta två ellementer med den summa): ");
  

        System.out.println();	
        System.out.println();	
        System.out.println();
  

  mainLoop: 
  
      for(int i=0;i<=n-1;i++){
      	
      	for(int j=i+1;j<n;j++){
      	
      	if(v[i]+v[j]==value){
      		
      		System.out.println("v["+i+"] + v["+j+"] = "+v[i]+" + "+v[j]);
      		
      		}	
      		
      	}
      	
      	
      }
  
	
 	
    System.out.println();
    
    
    
    }   
 } 
 


