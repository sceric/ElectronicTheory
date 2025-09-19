
import se.lth.cs.pt.window.TurtleWindow;




	class Turtle{
		
	 public boolean penDown;                         //här man deklarera variabler som ska
	 public int dir;                                 //användas i hela klasen
	 public int x;										
	 public int y;
	 public TurtleWindow w;	
 
 
		 public Turtle(TurtleWindow w, int x,int y){  //implementeras konstruktor Turtle
		 	    
		 	    this.w=w;
		 	    this.w=w;                               //här man sätter värde på variabel
		 	    this.x=x;                               //OBS! när vi anropa klas Tortle
		 	    this.y=y;								// vi måste sätta värde på x,y...
		 	    this.dir=90;                            //så vi tilldela värderna till variabel
		 	    this.penDown=false;                    // vi käner ej till de men vi tilldella
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