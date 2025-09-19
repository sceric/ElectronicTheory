import se.lth.cs.pt.random.*;
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.window.*;
import se.lth.cs.pt.turtle.*;

public class Kast{
	
	public static void main(String[]arg){
		
		
		TurtleWindow win = new TurtleWindow(1000,600);             

		Turtle xaxel = new Turtle(win,10,550);
		Turtle yaxel = new Turtle(win,10,550);
	    Turtle bol= new Turtle(win,10,550);
	   
        xaxel.penDown();               //x axel
        xaxel.right(90);
        xaxel.forward(970);
       
        yaxel.penDown();                // y axel
        yaxel.forward(530);

        bol.penDown();
        bol.right(90);                // rytta bol
       
		
		double n,v0;
		double k=550;
        double t=0;
        double g=9.82;
        double x,y;
    	boolean finish=false;
        
        
        do{
        v0=Keyboard.nextDouble("Skrev utgongshastighet mindre eller lika med 42m/s: ");
        }while (v0>42);
       



        double q=Keyboard.nextDouble("Skrev utgongs vinkel i grader: ");
         
		double qr=q/57.296;
		
		
	
		
		
		  while(!(finish)){

                x =Math.abs(5.0*(double)t*v0*Math.cos(qr)+10.0);
                y =550.0-((double)t*v0*Math.sin(qr) - 0.5*(g*(double)t*(double)t))*5.0;
              
                
                x= (int)Math.round(x); //int x=(int)Math.round(double x)
                y= (int)Math.round(y);
 
                System.out.println("Hejd :" +y +"   Avstond :" +((double)x/5.0-10.0));            
                

                
                bol.jumpTo((int)x,(int)y);   //double x = (int)x
                bol.forward (1);
                bol.penDown();              
				t=t+0.001;

				if(k>=y){
					
					k=(double)bol.getY();   
					
				}else{
					
					k=k;
				}
      
				
				if(y>=551){
					
					double p=(double)bol.getX()/5.0- 10.0; //avstånd
				           
					double s=(double)(550.0-k)/5.0; //störrsta höjden
					
					System.out.println(" ");
					System.out.println("Bolen ramlade po marken " +p +" m borta!");
					System.out.println(" ");
					System.out.println("Bolen node stersta hejden " + s +" m !");
									
				finish=true;          
				
				}
  
       }
       
     

	}
}