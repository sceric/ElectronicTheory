import se.lth.cs.pt.io.*;

public class Pvolym{

public static void main(String[] args){
 
        
	ConsoleReader r = new ConsoleReader();
	ConsoleWriter w = new ConsoleWriter();
	
//	int volym=0,hight=0,wight=0,lenght=0;
//	
//	
//	hight=r.readInt("Skriv hur mycket är högt: ");
//	wight=r.readInt("Skriv breden: ");
//	lenght=r.readInt("Skriv lengden: ");
//	
	
     String str1= r.readChar("Ange en mening:");
     
     for(int i=str1.length();i>=0;i--){
     	
     w.println(str1.charAt(i));	
     	
     }
	
	}
}