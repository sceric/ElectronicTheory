import se.lth.cs.pt.io.*;

public class Pmath{

public static void main(String[] args){

	ConsoleReader r = new ConsoleReader();
	ConsoleWriter w = new ConsoleWriter();
	
	double a;
	double b,c;
	
	a=r.readInt("Upisi broj a: ");
	b=r.readInt("Upisi broj b: ");
	
	//c=a/b;  /* a delat med b i den här fal är heltal tex 4/3=1 pga a är int*/
	
		       /*a=(int)a; double omvandlas till int
		         int k=(int)Math.round(double a); double a omvandlas till int
		         long k=Math.round(double a); avrunda a till närmaste heltal
		         double k=Math.floor(double a);strycks decimalerna;
		         double k=Math.sqrt(double x);
		         double k=Math.exp(double x);
		         double k=Math.log(double x);
		         double k=Math.cos(double x);
		         double k=Math.sin(double x);
		         double k=Math.tan(double x);
		         double k=Math.PI; (OBS! Pi je utan parameter)*/
		
	c=a/b; /* a delat med b är rell tal tex 4/3=1,333333 (a omvandlas
	          till double dvs int till double)*/
	       /* i fall att vi vill omvandla int till double eller double till int 
	          vi får ej deklarera som int a; och sen skriva c=(double) a/b. Utan
	          moste vi deklarera från början att kompilator vet vilken är
	          deklaration.dvs 
	          double a=(int)a, GÅR! 
	          int a=(double)a, GÅR EJ! (OBS! om a är int deklarerat ska skrivas
	                                     a=r.readInt() om det är dobule
	                                     deklarerat från början ska skrivas
	                                     a=r.readDouble().*/
	                  
	//c=a%b; /* a delat med be i den här fal är heltal (resten efter 
	         /*delningen)tex 5/3=2 dvse om det är c=a/b=5/3=1...*/
	
	
	w.println( "a delat med b är: " +c);


   }

}