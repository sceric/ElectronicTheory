import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;

public class ovn113{
	
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
  
  //Finns summa av två tal i vektor som är lika med den som du vill ha
  
  int left=0;
  int right=n-1;
  int value=Keyboard.nextInt("Sätt värde (vi vill hitta två ellementer med den summa): ");


        System.out.println();	
        System.out.println();	
        System.out.println();
  
  while(left<right){
  	
  	if(v[left]+v[right]<value){
  		
  		left++;
  		
  	}else if(v[left]+v[right]>value){
  		
  		right--;
  		
    }else{
    	
    	System.out.println("v["+left+"] + v["+right+"] = "+v[left]+" + "+v[right]);
  
        break;
    }
  
       	

 	}
 	
 	
    System.out.println();
    
    
    
    }   
 } 
 


