



class LifeView{
	
	private LifeBoard lifeBoard;
	private DotWindow w;
	
	
	public LifeView(LifeBoard board, int cellSize){
		
		this.lifeBoard=board;
		this.w=new DortWindow(this.lifeBoard.getWidth(),this.lifeBoard.getHeight(),cellSize);
	}	
	
	
	
	
	
	
}