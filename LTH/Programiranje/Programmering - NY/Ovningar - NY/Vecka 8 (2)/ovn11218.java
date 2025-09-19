

class Set{
	
	private int[] values;
	private int size;
	
	public Set(int maxSize){
		
		this.values=new int[maxSize];//skappas en mängd OBS!Bara skappas vektor!
		this.size=0;   //ta reda på hur många elemennter har hittils lagrat
		
	}
	
    public void clear(){
    	
    	this.size=0;
    }
    
//undersäker om det finns givet värde i mängden...
//om det finns returnera värde true
//och om det finns inte returnera värde false;

    public boolean contains(int value){  
    	
      for(int i=0;i<this.size;i++){
      	
      	if(this.values[i]==value){
      	
      	  return true;	
      	}
      	
      	}	
    	return false;
    }

//adera en värde om det finns inte i mängden och om det finns plas i vektor

    public void add(int value){
    	
    	if(this.size==this.values.length || this.contains(value)){
    		
    		return;
    		
    	}else{
    		
    	 this.values[this.size]=value;
    	 this.size++;	
    	}
    	
    }

	
	public void remuve(int value){
		
		for(int i=0;i<=this.size;i++){
			
			if(this.values[i]==value){
			
			this.values[i]=this.values[this.size-1];
			this.size--;	
				
			}
			
			
		}
		
	}
			
		
	public int union(Set other){
		
		return this.add(new Set(this.size));
		
		
		}	
		
		
		public int intersection(Set other){
			
			
			
		}	

    
    
            	  
            	       
}

