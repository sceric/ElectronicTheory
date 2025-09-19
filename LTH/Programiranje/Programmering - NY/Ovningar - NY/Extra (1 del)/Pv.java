import se.lth.cs.pt.io.*;

public class Pz{

public static void main(String[] args){

	ConsoleReader r = new ConsoleReader();
	ConsoleWriter w = new ConsoleWriter();
	
	int a=0,c=0,n=0,medel=0;
	
	a=r.readInt("Skrev start värde : ");
	n=r.readInt("Skrev anal cifror: ");
	
	
	
 		for(int i=1;i<=n;i++){
 			i++;
 			a=a+i;
 		}
 		
 		
 		medel=a/n;
 		w.println("Medelvärde är: " +medel);
 		

   }

}