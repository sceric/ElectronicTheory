

class Point{
	
	public double x;
	public double y;
	
	
	public Point(double x,double y){
		
		this.x=x;
		this.y=y;
		
		
	}
	
	public void moveTo(double newX,double newY){
		
		this.x=newX;
		this.y=newY;
		
	}
	
	public void move(double dx,double dy){
		
		this.x+=dx;
		this.y+=dy;	
		
	}


							       //VIKTIGT:
	public double getX(){          //OBS! "public double getX()" pga this.x är double deklarerat
								   // i fall "public int getX()" skule this.x blir int deklarerat
	    return this.x;	
		
	}
	
	
	public double getY(){
		
	   return this.y;
	   
    }
	   
	   

	   	
	 public double distanceTo(Point other){
	 	
	 	double dx=this.getX()-other.getX();       //avstånd mellan punkten this x och other x
	 	double dy=this.getY()-other.getY();       //avstånd mellan punkten this y och other y
	 	
	 	return Math.sqrt(dx*dx+dy*dy);             //gör oss avstånd.
	 	
	 }
	 


     public double distanceToOrigin(){
     	
     	double dxDist=this.x;
     	double dyDist=this.y;
     	
     	return Math.sqrt(dxDist*dxDist+dyDist*dyDist);
     	
     	
     	}	 


//    public double distancetoOrgin(){
//    	
//        return distanceTo(new Point(0,0));  OBS!!! studerar försiktig varför vi kan lösa	
//    }												 den uppgift på så sätt som vi har gjort här!
//	 	
//	 	
	 	  	

//LÖSNING: Man ska implementera operation i klass Point som returnera mittpunkt!


	public Point midpoint(Point other){	
	
	   	return new Point((this.x+other.x)/2,(this.y+other.x)/2);
	   	
	   }

//--------------------------------------------------------------------------	   	

//här används klas Point själv....titta först på operation Point uppe..det står
//"public Point midpoint(Point other)" och vår klass 
//Point "public Point(double x,double y)"
//så andra kordinater är ohter.x och other.y och 
//färsta kordinater är this.x och this.y


//	public Point midpoint(Point other){	
//	
//	   	return new Point((this.x+other.x)/2,(this.y+other.x)/2);
//	   	
//	   }

//i huvud program är p1.midpoint(p2);
//                  Point p1=new Point(double x,double y);
//            	    Point p2=new Point(double x,double y);

//  this.x och this.y kommer från p1
//  other.x och other.y kommer från p2 

//-------------------------------------------------------------------

//	 public double distanceTo(Point other){
//	 	
//	 	double dx=this.getX()-other.getX();        
//	 	double dy=this.getY()-other.getY();       
//	 	
//	 	return Math.sqrt(dx*dx+dy*dy);             
//	 	
//	 }


//vidare  i huvudprogram står p1.midpoint(p2).distanceTo(p2.midpoint(p3))
//
//this.getX() och this.getY() kommer från p1.midpoint(p2)
//other.getX() och other.getY() kommer från p2.midpoint(p3)

//-------------------------------------------------------------------
            	  
            	       
}

