import se.lth.cs.pt.io.*;
import se.lth.cs.pt.window.*;



public class Dotwi{
	
	public static void main(String[]arg){
		
		
		DotWindow dw=new DotWindow(50,50,10);
		Color blue = new Color (0,0,255);
		Color yellow = new Color(255,255,0);
		Color green = new Color(200,255,0);
		Color red = new Color(255,100,0);
		Color brun = new Color(100,100,0);
		
	    Color black = Color.BLACK;
		

        dw.fillWith(black);
  
		for (int x=0;x<50;x++){
			
			dw.setDot(50-1-x,x,brun);
            dw.setDot(x,x,yellow);

		
           
			dw.setDot(4,6,blue);
			dw.setDot(6,5,green);
			dw.setDot(7,7,red);
			

			 
		}
		
		
	}	
	
}