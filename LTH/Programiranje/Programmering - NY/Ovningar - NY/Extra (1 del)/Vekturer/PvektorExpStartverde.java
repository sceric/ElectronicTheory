import se.lth.cs.pt.io.*;

public class PvektorExpStartverde{

public static void main(String[] args){


     int [] smallPrimes = {2,3,5,7,11};
     String [] firstName = {"Artur","Bertil","Sefik","Cristian"};
 
 
     for(int i=0;i<smallPrimes.length;i++){               //skriver utt vektor
     													 //smallPrimes
     	System.out.println(smallPrimes[i] + " ");
     	
     }
     	
     		System.out.println(" ");
     		
     for(int k=4;k>=0;k--){                           //skriver utt vektor
     	 											//samllPrimes i omvänd ord.
     	System.out.println(smallPrimes[k] + " ");
     	
     }
  
 
 
 
 
            
     		System.out.println(" ");
     		
 
     for(int s=0;s<firstName.length;s++){             //skiver utt vektor
     												  //firstNime
     	System.out.println(firstName[s] + " ");
     	
     }


           	System.out.println(" ");

 
     for(int p=3;p<=0;p--){                           //skiver utt vektor
     												  //firstNime i omvänd ord.
     	System.out.println(firstName[p] + " ");
     	
     }


System.out.println(" ");
   }

}