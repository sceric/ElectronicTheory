import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;

public class ovn919{
	
	public static void main(String[]arg){
		
		RandomNumberGenerator rng = new RandomNumberGenerator();
		int []v= new int[101];
		int value=0;
		int temp=0;

//Tilldela värde till vektor: (här kan man utnytja v[rng.randInt(1,100)]++;
//							   värdet tilldelas och samtidligt registreras		
		for(int i=1;i<=100;i++){       //eller kan man skriva count[v[i]]++
	                                   //men man måste bilda en till vektor count[]	
		value= rng.randInt(1,100);	
		 v[i]=value;
			
			
		}
		
//Registrering:		
       for(int i=1;i<=100;i++){             
        	
        	v[value]++;
        	       	
        }
        

//vanligaste värde:

        int mostCommon=1;
 
        for(int i=2;i<=100;i++){
        	 
        	 if(v[i]>v[mostCommon]){
        	 
        	 mostCommon++;	
        	 	
        	 	
        	 }  
        
       }
       
  System.out.println();
  System.out.println("Den vanligaset värde är " +mostCommon);
  System.out.println();
  
  
  
  //flera värde som är vanliga:
  
  
  boolean tie=false;
  int mostCommon1=1;
  
		  for(int i=2;i<=100;i++){
		  	
		  	if(v[i]>v[mostCommon1]){
		  		
		  		mostCommon=i;

		  		tie=false;
		  		
		  	}else if(v[i]==v[mostCommon1]){
		  		
		  		tie=true;
		  		
		  	}
		  	
		  	
 		 }
  
	  if(tie){
	  	
	  System.out.print("Det minsta vanligaste värderna är ");
	  
	  }else{
	  	
	  	System.out.print("Det vanligaste värden är ");
	  		  	
	  }
     
     System.out.println(mostCommon1);
     System.out.println();
     System.out.println();
     System.out.println();
 
 
 //median värde
     
     int sum=0;
     int value1=0;
     do{
     	
     	sum+=v[++value1];
     	
     }while(sum<(100+1)/2);
     
     System.out.println("Medianvärdet är "+value1);
     System.out.println();
     System.out.println();
  
  
  
 	}
 
       
 } 
 
 


