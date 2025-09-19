import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;

public class ovn116{
	
	public static void main(String[]arg){
		
		RandomNumberGenerator rng = new RandomNumberGenerator();
		System.out.println();
		int n=Keyboard.nextInt("Skrev antal elementer som du vill att vektor ska ha: ");
		int []p= new int[n+1];  //obs måste måste man lägga till +1 annar funka ej ordentligt
		int value=0;
		int temp=0;

//Tilldela värde till vektor: (här kan man utnytja också v[rng.randInt(1,100)]++)
	
					   		

  System.out.println();
  System.out.println();
  
		for(int i=1;i<=n;i++){       
	                                   
		value= rng.randInt(1,100);	

		 p[i]=value;
			
		 System.out.println("p["+i+"] = "+p[i]);	
		}
		
        
//invers:antal efterföljare som har mindre tall,så varje element utom den sista ska man 
//testa efterföljare...pga detta vi behöver två loopar...ena går fron 0 till n-2
//och den andra går från stäget efter den första till n-1:


		int nbrOfInversions=0;
		
		for(int i=1;i<n;i++){
			
			for(int j=i+1;j<n;j++){
			
			  if(p[j]<p[i]){
			  	
			  	nbrOfInversions++;
			  	
			  	}	
				
			}
			
		}

      System.out.println();
      System.out.println();
      System.out.println("Antal inversion är " +nbrOfInversions);
  	  System.out.println();

 	}
 
       
 } 
 
 
//Yttre for loopen stoppar deran före sista elementet,eftersom det sista elementet inte har några efterföljare
//att undersöka,men programet hade fungrerat även om vi gått ett steg längre

