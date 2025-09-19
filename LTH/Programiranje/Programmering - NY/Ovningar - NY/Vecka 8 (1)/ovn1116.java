



class Point{
	
	public double x;
	public double y;
	
	
    public Point(double startX,double startY){  //implementeras konstruktor Point
    	                                    
    	this.x=startX;
    	this.y=startY;
    	
    }
	
	
}



//OBS! OBS! OBS! om vi har public Point(double startX,double startY) var deklarerade 
//variable startX och startY som double (värde på de sätter vi när vi anropa den
//i huvudprogram så vi tolka startX och startY som att de är värden) måste vi deklarera
//variabel som double dvs double x och double y och då vi kan sätta this.x=startX annars
//går ej