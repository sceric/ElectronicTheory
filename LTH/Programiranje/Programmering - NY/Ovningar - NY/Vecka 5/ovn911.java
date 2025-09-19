import se.lth.cs.pt.random.*;
import se.lth.cs.pt.io.*;


public class ovn911{
	
	public static void main(String[]arg){
		
		RandomNumberGenerator rng = new RandomNumberGenerator();

        int[] v=new int[5];
        
        for(int i=0;i<5;i++){
        	
          v[i]=2*i+1;
          
          System.out.println("Värde ["+i+"] = "+v[i]);	
        }

       
	}
}