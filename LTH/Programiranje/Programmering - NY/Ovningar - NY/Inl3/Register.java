class Register{
	
	   
    private int maxSize;
    private Person [] register;
    private int nbr;
    private int poss;
	  
	
	
	
	
    public Register(int maxSize){
			
	this.register=new Person[maxSize];
	this.nbr=0;
			
    }

    public boolean insert(String name,String nummer){
	boolean finished = false;
	this.nbr++;
	int index = 0;

	while (!finished && this.register[index] != null) {
	    if(this.register[index].getName().equals(name)){
		finished = true;
	    }
	    index++;
	}
	if (!finished) {
	    this.register[index] = new Person(name, nummer);
	    return true;
	} else {
	    return false;
	}
    }
	    	
	    
    public boolean remove(String name){
    	
    	
         int index=0;
    
    	
		while(this.register[index]!=null && !this.register[index].getName().equals(name)){
		  
		
		  index++;   	
			
		}
		
	    if(this.register[index]==null){
	    		
			return false;    			
	     		
    	}else{
			
			this.register[index]=null;
			this.nbr--;
			return true;
		
        }
    }  

//this.register[index].getName()=this.register[index+1].getName()...FEL !!!!
//this.register[index].getName()==0...FEL !!!! pga det är stringe inte real tal
    //--------------------------------------------------------------------------	    
    //i operation finName man ska returnera klassen Person (titta på "public Person...")
    //och vi returnera klassen Person om vi hitta "name"
    //vi går genom hella this.register pga det är vår klass Person (vi har deklarerat den så
    //eller hur)...vidare do vi hittar name ska returnera klass Person dvs this.register[index]
    //med index var ligger namnet skall returneras
    //--------------------------------------------------------------------------	    

    public Person findByName (String name){
	boolean finish=false;
	int index=0;
	    	
	while(index<this.register.length && !finish ){
	    
	    		
	    if(this.register[index].getName().equals(name)){
	    
		
		finish=true;
	    }
	    		
	    index++;
	    	 
	}
	  	
	return this.register[index-1];
    }

    //-----------------------------------------------------------------	    
    //pss som operation ovan men nu handlar om personens numer....
    //-----------------------------------------------------------------


    public Person findByNumber (String numer){
	    	
	boolean finish=false;
	int index=0;
	    	
	while(index<this.register.length && !finish ){
		
	    		
	    if(this.register[index].getNumber().equals(numer)){
	    			
		finish=true;
	    }
	    		

	    	 
	}
	    	
	return register[index-1];
    }
	    
    //i den hör metod man ska returnera hela vektor av objekt Persson dvs i vår fall
    //vi har deklarerat objekt Person som register och den ska returneras....
    //klasisk man ska	sortera enligt vad man vill sortera.I den här fal sorterar man 
    //enligt namn och vilkor do blir 
    //while(this.nbr>0 && this.register[this.nbr-1].getName().compareTo(str.getName())>0)
    //dvs man jämföra två strengar med metoden compareTo
    //tex. p1.comareTo(p2)>0 streng p1 kommer förre p2 i bokstav ordningen
    //om det är p1.comareTo(p2)=0 bli de samma
    //och p1.comareTo(p2)<0 blir streng p2 förre p1 dvs jämförs bakåt i bokstavs ordningen

    public Person[] finAll(){
	    	
	for(int i=1;i<this.nbr;i++){
	    		
	    Person str=this.register[i];

	    poss=i;
	    	
	    while(poss>0 && this.register[poss-1].getName().compareTo(this.register[poss].getName())>0){
		    	
		this.register[poss]=this.register[poss-1];
		    	
		poss--;
		    	
	    }
	  
	    this.register[poss]=str;
	    	
	}
	   

	  	 return this.register;
  
    }	    
	    
	    		
}
