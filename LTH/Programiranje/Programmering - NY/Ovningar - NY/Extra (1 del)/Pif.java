import se.lth.cs.pt.io.*;

public class Pif{

public static void main(String[] args){

	ConsoleReader r = new ConsoleReader();
	ConsoleWriter w = new ConsoleWriter();
	
	int a,b,c;

	a=r.readInt("Skrev en tal A: ");
	b=r.readInt("Skrev en tal B: ");
	c=r.readInt("Skrev en tal C: ");
	
	if(a==b && b==c){
		w.println("Alla tal är lika!");
	}else if(a<b || a>c){
		w.println("A är större av B eller av C!");
	}else if(!(a<b)){                       //OBS! Altid !(....)...INTE// 
		w.println("A är INTE mindre av B!"); //  if (!(...)){..om det är INTE!//
	}else{
		w.println("Alla tal är INTE lika!");
	}   
  }
}