import se.lth.cs.pt.random.*;
import se.lth.cs.pt.io.*;
import se.lth.cs.pt.window.*;
import se.lth.cs.pt.turtle.*;

public class PTurtleV{
	
	public static void main(String[]arg){
		
		
		TurtleWindow win = new TurtleWindow(500,300);             
        Turtle[] t = new Turtle[200];//skapas en vektor med 10000 ref.//
	

		Turtle start = new Turtle(win,50,50);
		Turtle end = new Turtle(win,450,50);
		
		RandomNumberGenerator rng = new RandomNumberGenerator();
	   
        start.penDown();               //start linjen
        start.right(180);
        start.forward(200);
       
        end.penDown();                // finish linjen
        end.right(180);
        end.forward(200);
       
	  
	    int n=Keyboard.nextInt("Ange antal skäldpador (max 199): ");
	   for(int i=1;i<=n;i++){                     //skapas Sjöldpador med 
		    t[i]= new Turtle(win,53,50+i*(200/n));//start pozition
		   	t[i].penDown();
		   	t[i].right(90);
	}
	  
	  boolean finish=false;
	  int count=0; 
	  while(!finish){                       //finish är false...tills inte blir
	   										// finish false dvs tills finish är
		  for(int k=1; k<=n;k++){			// true kär man
		   	
		   	t[k].forward(rng.randInt(1,6));//skölpadda får värde
	      	//t[k].right(rng.randInt(0,1));
	      	//t[k].left(rng.randInt(0,1));  	
		   	
		   	  if(t[k].getX()>=445){          //när sjölpadda nå 445 är i mål då
		   	                             // finish är true och avbrits tävling
		   	  	t[k].forward(5);
		   	    System.out.println("Sjölpadda nummer  " +k +"  kommer färst");
		   	  	finish=true;
		   	  }
		   		
		   }
		count=count+1;
					
		}
		
		System.out.println("Antal stegg tills sköldpadda når mål är: " +count);
	}
}