import se.lth.cs.pt.io.*;

public class Pmath1{

public static void main(String[] args){


	
	double a;
	double b,c;
	
	a=Keyboard.nextDouble("Upisi broj a: ");
	b=Keyboard.nextDouble("Upisi broj b: ");
	
	c=a/b;
	         double k1=Math.sqrt(c);
	         double k2=Math.exp(c);
	         double k3=Math.log(c);
	         double k4=Math.cos(c);
	         double k5=Math.sin(c);
	         double k6=Math.tan(c);
	         double k7=Math.PI;
	         
	         double k8=Math.sqrt(k2); /*varijabel k2 får värde av 
	                                    double k3=Math.log(c);*/
	                                    
	         double k9=Math.sqrt(Math.exp(c));/* ingen varijabel utan 
	                                             direkt implementerat*/
	
	
	           long k10=Math.round(k9); /*omvandling 1,7777 omvandlas till 2*/
	           double k11=Math.floor(k9);/* omvandling 1.7777 omvandlas till 1 
	                                        dvs decimaler strycks! */

	
	System.out.println( "Sqrt: " +k1);
	System.out.println( "Exp:  " +k2);
	System.out.println( "Log:  " +k3);
	System.out.println( "Cos:  " +k4);
	System.out.println( "Sin:  " +k5);
	System.out.println( "Tan:  " +k6);
	System.out.println( "Pi:   " +k7);
	System.out.println( "Sqrt(exp)1:   " +k8);
	System.out.println( "Sqrt(exp)2:   " +k9);
	System.out.println( "Omvandling med round:   " +k10);
	System.out.println( "Omvandling med floor:   " +k11);


   }

}