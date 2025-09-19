
import se.lth.cs.pt.window.TurtleWindow;


class Turtle{
	
	public double x;
	public double y;
	public TurtleWindow w;
	public boolean penDown;
	public int dir;
	
	
    public Turtle(TurtleWindow w,double x,double y){  //implementeras konstruktor Turtle
    	  
    	this.w=w;                                   
    	this.x=x;
    	this.y=y;       
    	this.penDown=false;
    	this.dir=90;
    	
    }
	
	
}

//om vi vill använda andra operationer kan vi skriva också:


class Turtle2{  										//läs kommentar näre


	public int x;
	public int y;
	public TurtleWindow w;
	public boolean penDown;
	public int dir;



    public Turtle2(TurtleWindow w1,int x,int y){  //implementeras konstruktor Turtle
    	                                                //konstruktor MÅSTE ha samma namn
   														//som class 	
    	this.w=w;
    	 this.penDown();            
    	this.jumpTo(x,y);

    	this.tornNorth();
    	
    }

         public void penDown(){                        
         												
               this.penDown=true;						
         	
         }
         
         
         public void penUp(){
         	
         	   this.penDown=false;
         	
         }
         
         public void left(int angle){
         	
         	  this.dir+=angle;
         	
         }
         
         
         public void right(int angle){
         	
         	this.dir-=angle;
         }
         
         
         public void jumpTo(int x, int y){
         	
         	  this.x=x;
         	  this.y=y;
         	
         }
         
         
         public void tornNorth(){
         	
         	this.dir=90;
         }




	
	
}
