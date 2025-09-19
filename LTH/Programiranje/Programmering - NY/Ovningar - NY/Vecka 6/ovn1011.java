import se.lth.cs.pt.random.*;
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.window.*;
import se.lth.cs.pt.turtle.*;
import se.lth.cs.pt.window.Color;


public class ovn1011{
	
	public static void main(String[]arg){
		
    DotWindow dotw= new DotWindow(50,50,10);
    Color blue = Color.BLUE;
    dotw.fillWith(blue);
    boolean finish=false;

    int p1=Keyboard.nextInt("Set fergen (sifra mellan 0-255): ");
    int p2=Keyboard.nextInt("och andra sifra: ");
    int p3=Keyboard.nextInt("och tredje sifra: ");
    int x=Keyboard.nextInt("Set X: ");
    int y=Keyboard.nextInt("Set Y: ");
    
 
    Color fg = new Color(p1,p2,p3);
    
   
    drawBlueSquare(dotw,x,y,fg);    


//UNDER PROGRAM
 
}


   static void drawBlueSquare(DotWindow dotw, int xLeft, int yTop,Color color){ 
 
         
   	
   		for (int x=xLeft;x<xLeft+10;x++){

			for(int y=yTop;y<yTop+10;y++){
           
			  dotw.setDot(x,y,color);
			  

		    }
		    
		 }   

	}
		
  
}