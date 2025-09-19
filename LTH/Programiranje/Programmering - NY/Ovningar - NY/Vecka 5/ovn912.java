import se.lth.cs.pt.random.*;
import se.lth.cs.pt.io.*;


public class ovn912{
	
	public static void main(String[]arg){
		
		RandomNumberGenerator rng = new RandomNumberGenerator();

        int[] v=new int[5];
        
        for(int i=0;i<5;i++){
        	
          v[i]=2*i+1;
          
          System.out.println("Värde ["+i+"] = "+v[i]);	
        }

         System.out.println("Värde v[0] = "+v[0]);        //v[0]=1
         System.out.println("Värde v[v[0]] = "+v[v[0]]);  //v[0]=v[1]=3
         System.out.println("Värde v[v[v[0]]] = "+v[v[v[0]]]);//v[0]=v[1]=v[3]=7
         System.out.println("Värde v[v[v[v[0]]]] = "+v[v[v[v[0]]]]);//exekveringsfel...finns inte

	}
}