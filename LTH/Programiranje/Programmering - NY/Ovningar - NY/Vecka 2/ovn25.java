
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;



public class ovn25{
	
	
   public static void main (String[] args){
    
   RandomNumberGenerator rng = new RandomNumberGenerator ();
   
   
   int n=Keyboard.nextInt("Skrev antal tal: ");
   
   double nextBiggest=0;
   double biggest=0;
   
   
	   for(int i=0;i<=n;i++){
	   	
	   	double indata=rng.randDouble(1,100);
	   	
		   	if(indata>biggest){
		   		
		   		nextBiggest=biggest;
		   		biggest=indata;
		   		
		   	}else if(indata>nextBiggest){
		   		
		   		nextBiggest=indata;
		   		
		   	}
		   	
		   	System.out.printf("%5.3f: %8.3f\n", biggest, nextBiggest);
		   	
		   	// %8.3f\n ......8=antal placer......3=antal decimaler....f=double
		   	// n= fils fron höger mot venster med cifrorna
		   	// %d=heltal, %2d....tvo placer för heltal
	   		
    	}
	   	
	   	
	   	double medel=(nextBiggest+biggest)/2;
	   	
	   	System.out.println(" ");
	   	System.out.println("Medel mellan största och näststörsta tal är  " +medel);
        System.out.println(" ");
	 



  }
 
}