import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;

public class ovn1149{
	
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

//URVALSSORTERING:
        
        for (int i=0;i<n-1;i++){
        	
        	int minIndex =i;
        	
        	for(int j=minIndex+1;j<n;j++){
        		
        	 if(v[j]<v[minIndex]){
        	 	
        	 	minIndex=j;
        	 
        	 }	
        		
        	}
        	
        	int temp=v[i];
        	v[i]=v[minIndex];
        	v[minIndex]=temp;
        	
        	System.out.println("v["+i+"] = "+v[i]);
        }
  
  
  
 	}
 
       
 } 
 
//   Antal jämförelse är altid lika stort...första varvet är n-1, andra n-3 oavset i 
//   vilken ordning talet står.
//   Men man får färre förflyttningar av våra ellement äv vi hade i insättningssorteringen.
//   Här flyttas varje element högst en gång.


