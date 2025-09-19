import se.lth.cs.pt.io.*;

public class Psuma2{

public static void main(String[] args){

	ConsoleReader r = new ConsoleReader();
	ConsoleWriter w = new ConsoleWriter();
	
	double degF, degC;
	char ch;
	
	w.println("Skrev vad du vill omvandla");
	w.println(" 'F' (Celsius till Farenhit)");
	w.println(" 'C' (Farenhit till Celsius)");
	
	ch=r.readChar(": ");
	
	if(ch=='f'){
		degC=r.readDouble("Ange Celsius som du vill omvandla till Farenhit: ");
		degF=degC*(double)9/5+32;
		w.println("Det är " +degF +" F");
	}
	
	if(ch=='c'){
		degF=r.readDouble("Ange Farenhit som du vill omvandla till Celsius: ");
		degC=(degF-32)*(double)5/9;
		w.println("Det är " +degC +" C");
	}
 		

   }

}