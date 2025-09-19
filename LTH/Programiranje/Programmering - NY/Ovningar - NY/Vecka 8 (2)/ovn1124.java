





	class LimitedSet{
		
        
        private boolean[] occurs;
        private int size;
 
       public LimitedSet(int maxValue){
       	
       	 this.occurs= new boolean[maxValue+1];
       	 this.size=0;
       	 
       	 
      }
      
      
      public int size(){
      	
      	return this.size;
      	
      }
      
      
      public void clear(){
      	
      	for(int i=0;i<this.occurs.length;i++){
      		
      		this.occurs[i]=false;
      	}
      	
      	this.size=0;
      }
      
      
      public void add(int value){
      	
      	if(!this.occurs[value]){
      		
      		
      		this.occurs[value]=true;
      		this.size++;
      		
      	}
      	
      }
      
      
      public boolean contains(int value){
      	
      	return this.occurs[value];
      	
      }
      
      
      public void remove(int value){
      	
      	if(this.occurs[value]){
      		
      		this.occurs[value]=false;
      		this.size++;
      		
      	}
      	
      }
       	
	
 }