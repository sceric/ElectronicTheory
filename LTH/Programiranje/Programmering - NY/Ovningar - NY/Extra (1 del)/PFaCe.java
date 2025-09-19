import se.lth.cs.pt.io.*;

public class PFaCe{

public static void main(String[] args){

	ConsoleReader r = new ConsoleReader();
	ConsoleWriter w = new ConsoleWriter();
	
	double degF, degC;
	char ch;
	
	System.out.println("Skrev vad du vill omvandla");
	System.out.println(" 'F' (Celsius till Farenhit) OBS! liten bokstäver ");
	System.out.println(" 'C' (Farenhit till Celsius) OBS! liten bokstäver ");
	
	ch=r.readChar(": ");
	
	if(ch=='f'){
		degC=Keyboard.nextDouble("Ange Celsius som du vill omvandla till Farenhit: ");
		degF=degC*(double)9/5+32;
		System.out.println("Det är " +degF +" F");
	}
	
	if(ch=='c'){
		degF=Keyboard.nextDouble("Ange Farenhit som du vill omvandla till Celsius: ");
		degC=(degF-32)*(double)5/9;
		System.out.println("Det är " +degC +" C");
	}
 		

   }

}