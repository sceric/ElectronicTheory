
import se.lth.cs.pt.window.TurtleWindow;
import se.lth.cs.pt.window.Color;
import se.lth.cs.pt.window.SimpleWindow;




 class Turtle{
		
	 public boolean penDown;                         //här man deklarera variabler som ska
	 public int dir;                                 //användas i hela klasen
	 public int x;										
	 public int y;
	 public int x1;
	 public int y1;
	 public TurtleWindow w;
	 public Color color;	
 
 
		 public Turtle(TurtleWindow w, int x,int y){  //implementeras konstruktor Turtle
		 	    
		 	    this.w=w;
                                                       //här man sätter värde på variabel
		 	    this.x=x;                               //OBS! när vi anropa klas Tortle
		 	    this.y=y;								// vi måste sätta värde på x,y...
		 	    this.dir=90;                            //så vi tilldela värderna till variabel
		 	    this.penDown=false;
		 	    this.color=Color.BLUE;
		 	    this.x1=x1;
		 	    this.y1=y1;                  // vi käner ej till de men vi tilldella
         }												//deras variabel till variabel som vi 
         												//har deklarerat ovan
         												//att lega till "this." till vår deklarerat
         public void penDown(){                         //variabel betyder att denna variabel kan
         						
         		                						//vara tilgänligt till andra metoder eller
               this.penDown=true;						//objekter.........	
         	
         }
         
         
         public void penUp(){
         	
         	   this.penDown=false;
         	
         }
         
 
 


         
         
         public void forward(int n){
         	
         	int oldX=this.getX();  //ta reda po x kordinat
         	int oldY=this.getY(); // ta reda på y kordinat
         	
         
            //OBS!!! ett grad är 0,017453 radianer)

         	this.x=this.x+(int)Math.round(n*Math.cos(this.dir*0.017453)); //ny x kordinat efter förflytning
         	this.y=this.y-(int)Math.round(n*Math.sin(this.dir*0.017453)); //ny y kordinat efter förflytning
            
            //nu har vi fal att oldX och oldY är gamla kordinater
            //och nu getX() och getY() tar reda på nya kordinater

            if(this.penDown){
 
            this.w.drawLine(oldX,oldY,this.getX(),this.getY(),this.color,3);
 
        	}
                     
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

       		
	     public int getX(){
	     	
	     	return this.x;
	     	
	     }
	     
	     
	     public int getY(){
	     	
	     	return this.y;
	     	
	     }
	     
	     
	     
	     public int getDirectorion(){
	     	
	     	return this.dir;
	     	
	     }
	
 }