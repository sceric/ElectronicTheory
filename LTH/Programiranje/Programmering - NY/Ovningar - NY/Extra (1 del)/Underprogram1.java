import se.lth.cs.pt.io.*;
import se.lth.cs.pt.window.*;



public class Underprogram1{
	
	public static void main(String[]arg){
		
		
		DotWindow dw=new DotWindow(50,50,10);
		
		Color yellow = new Color(255,255,0);
		Color green = new Color(200,255,0);
		Color red = new Color(255,100,0);
		Color brun = new Color(100,100,0);
		
	    Color black = Color.BLACK;
	    dw.fillWith(yellow);
	    
  
  
       int x=Keyboard.nextInt("Ange x axel: ");
       int y=Keyboard.nextInt("Ange y axel: ");
	   
	   drawBlueSquare(dw,x,y); 
	    
	 }
  

//UNDERPROGRAM (ATT SLIPA UPPREPA PROGRAMRADER FLERA GÅNGER)
//
//istället:
//		for (int x=5;x<15;x++){
//
//			for(int y=5;y<15;y++){
//           
//			dw.setDot(x,y,blue);
//			 }
//man skirver så:

   static void drawBlueSquare(DotWindow dw, int xLeft, int yTop){ 
 
   	     Color blue = new Color (0,0,255);
   	
   		for (int x=xLeft;x<xLeft+10;x++){

			for(int y=yTop;y<yTop+10;y++){
           
			  dw.setDot(x,y,blue);
			  

			 }
 // sedan i huvudprogram man leger till drawBlueSquare(w,x(värde på x).y(värde på y) 	
   	
   }

}		
		
		
		
	
}