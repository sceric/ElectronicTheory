

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
	
}