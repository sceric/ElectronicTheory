import se.lth.cs.pt.random.*;
import se.lth.cs.pt.io.*;


public class ovn917{
	
	public static void main(String[]arg){
		
		RandomNumberGenerator rng = new RandomNumberGenerator();

        int[] v=new int[1000];

        int n=0;
        
        System.out.println("Skrev en följd av tal melan 1 och 100 - avlsuta med 'noll': ");
        
        int nbr=Keyboard.nextInt();
       
        while(nbr!=0){
        	              	
          v[n]=nbr;
          
          nbr=Keyboard.nextInt();
          
          n++;
         
        }

       //JÄMNA TAL:
       
       System.out.println(" ");
       System.out.println("JEMNA TAL: ");
       System.out.println(" ");
       
       
       for(int i=0;i<n;i++){
       	
	       	if(v[i]%2==0){
	       	
	       	System.out.println("v["+i+"] = "+ v[i]);	
	       		
	       	}
	       	
       	
       }
       
       //UDDA TAL:
       
       System.out.println(" ");
       System.out.println("UDDA TAL: ");
       System.out.println(" ");
       
       
       for(int i=0;i<n;i++){
       	
	       	if(v[i]%2!=0){        //som vilkor kan vi använda också if(v[i]%2==1)
	       	
	       	System.out.println("v[" +i +"] = "+ v[i]);	
	       		
	       	}
	       	
       	
       }






	}
}