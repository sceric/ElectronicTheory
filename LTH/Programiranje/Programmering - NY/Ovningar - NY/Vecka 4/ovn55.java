
import se.lth.cs.pt.io.*;



public class ovn55{
	
	
	public static void main (String[] args){
 
    
     
     
     double sum=0;
     double sqSum=0;
     double m=0;          //här man deklarera m men varför man sätter start värde..hm ingen anning
     int n=Keyboard.nextInt("Skrev antal ellementer: ");

     System.out.println(" ");
     System.out.println("Skriv nu alla tal: ");
     
     for(int i=1;i<=n;i++){
     	
     	double x=Keyboard.nextInt();
     	sum += x;
     	sqSum += x*x;
     	
     	
     }

     if(n==0){
        
        System.out.println(" ");
        System.out.println("Inga tal!");
     	
     	
     }else{
     	
     	m=sum/n;                    //fel i lösningsförslag...sätt ej dobule
     	System.out.println(" ");
     	System.out.println("Medelvärde är" +m);
     	
     }
     
     
     if(n>1){
     	
     	double stdDev=Math.sqrt((sqSum-n*m*m)/(n-1));
     	System.out.println(" ");
     	System.out.println("Standardavikelse är: "+stdDev);
     	
         	
     }else{
     	
        System.out.println(" ");
     	System.out.println("Vi måste ha minst två tal för standardavikelse!");	
     	
     }


    
  System.out.println(" ");
  
 } 

}
 


