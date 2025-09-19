



class LifeBoard{
	
    private int width;
    private int height;
    private int n;
    private boolean [][]sq;



         public LifeBoard(int n) {
         	this.n=n;        	
           this.sq = new boolean[n][n];
           
         }


		public int getWidth(){
			
			return this.width;
			
		}
		
		public int getHeight(){
			
			return this.height;
			
		}
		
		
		public boolean isAlive(int x, int y){
			
			return this.sq[x][y];
			
//---------------------------------------			
//OBS! FUNKA OCKSÅ!!!!!!!			
//			if(this.sq[x][y]){
//				
//			   return true;
//			
//			}else{
//				
//			   return false;	
//			}
//--------------------------------------
							
		}
		
     	
     	public void setValue(int x, int y, boolean value){
     		
     			
     			this.sq[x][y]=value;
     			
     	
     		
     	}
     	
     	
     	public void clear(){
      //om vi sätter värde "true" att radera moste vi sätta värde "false"    		
     		  for (int i= 0; i<x; i++) {
	                for (int j=0; j<y;j++) {
		               this.matris[i][j] = false;
  	                }
              }
     		
     		
     	}
	
	
	    public void nextGeneration() {
	    	
	    	int nbrNeighbours=0;
	    	
	    	for(int k=0;k<this.n;k++){
	    		
             for(int i=x-1; i<=x+1; i++){
                 for(int j=y-1; j<=y+1; j++){

                   if(this.matris[i][j] = false){

                    nbrNeighbours++;
                    
                    }
                  }	    		
	    	}
	    	
	    	
	    }	
	    	
	    	
	    }
	
	
}