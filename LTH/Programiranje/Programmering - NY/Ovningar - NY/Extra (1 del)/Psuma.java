import se.lth.cs.pt.io.*;

public class Psuma{

public static void main(String[] args){

	ConsoleReader r = new ConsoleReader();
	ConsoleWriter w = new ConsoleWriter();
	
	int p=0,suma=0,count=0;
	
	while(p<=100){
         suma= suma+p;
 		 p++;
 		System.out.println("Broj je"+ p +" i suma je " + suma);
 		
	}
    
    
  }
}