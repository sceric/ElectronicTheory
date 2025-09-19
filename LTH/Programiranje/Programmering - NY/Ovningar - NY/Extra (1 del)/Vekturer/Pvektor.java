import se.lth.cs.pt.io.*;

public class Pvektor{

public static void main(String[] args){

	ConsoleReader r = new ConsoleReader();
	ConsoleWriter w = new ConsoleWriter();
	
	int []v= new int[11];
	
	/*man kan skriva ochså           int[]v; (deklarera vektorn)
	  och sen ger vektor 
	  värde dvs antal placer med     v= new int[11]*/

 	for(int i=0; i<=10; i++){
 		
 	   v[i]=r.readInt("Upisi broj u vektor: ");	
 	   w.println("["+i +"] = " +v[i]);
     
 		}
    
    int k=r.readInt("Upisi broj vektora : ");	
	w.println("Vektor ["+k+"]" +"ima vrijednost" +v[k]);
		
 
 
 
   }

}