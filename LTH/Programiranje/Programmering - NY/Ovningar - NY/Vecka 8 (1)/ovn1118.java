

class Point{
	
	public double x;
	public double y;
	
	public void moveTo(double newX,double newY){
		
		this.x=newX;
		this.y=newY;
		
	}
	
	public void move(double dx,double dy){
		
		this.x+=dx;
		this.y+=dy;	
		
	}


//LÖSNING:							VIKTIGT:
	public double getX(){          //OBS! "public double getX()" pga this.x är double deklarerat
								   // i fall "public int getX()" skule this.x blir int deklarerat
	    return this.x;	
		
	}
	
	
	public double getY(){
		
	   return this.y;
	   	
	}
}