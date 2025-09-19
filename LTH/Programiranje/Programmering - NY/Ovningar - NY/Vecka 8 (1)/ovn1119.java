

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
	   
	   
//LÖSNING:
	   	
	 public double distanceTo(Point other){
	 	
	 	double dx=this.getX()-other.getX();       //avstånd mellan punkten this x och other x
	 	double dy=this.getY()-other.getY();       //avstånd mellan punkten this y och other y
	 	
	 	return Math.sqrt(dx*dx+dy*dy);             //gör oss avstånd.
	 	
	 }
	 	
	 	
	 	  	
	   	
	   	

}