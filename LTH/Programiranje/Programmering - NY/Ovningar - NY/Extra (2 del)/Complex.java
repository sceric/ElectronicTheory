

class Complex{
	
	
	    private double re;
	    private double im;
	
		public Complex(double re,double im){
			
			 this.re=re;
			 this.im=im;
			
			
				
		}
	  
	    public Complex plus(Complex other){
	    	
	    	Complex sumPlus = new Complex(this.re+other.re,this.im+other.im);
	    	
	    	return sumPlus;
	    	
	    	
	    }
	    	
//-------------------------------------------------------------------

//Vi kan också istället skriva så:
//
//	    public Complex plus(Complex other){
//	    	
//	    	return new Complex(this.re+other.re;this.im+other.im);
//	    	    	
//	    }
//	    
//var vi returnera värde sum dvs "Complex sumPlus" ersätts med "return"
	    
//-------------------------------------------------------------------	    	
	
	
		public Complex minus(Complex other){
			
			
			Complex sumMinus = new Complex(this.re-other.re,this.im-other.re);
			
			return sumMinus;
			
			
	   }
	   
	   
	   
	   public Complex divideBy(Complex other){
	   	
	   	   Complex sumDivide = new Complex(((this.re*other.re)+(this.im*other.im))/(other.re*other.re+other.im*other.im),
	   	                                   ((this.im*other.re)-(this.re*other.im))/(other.re*other.re+other.im*other.im));
	   	    
	   	    return sumDivide;
	   	
	   }
	   
	   
	   public Complex times(Complex other){
	   	
	   	   Complex sumTimes = new Complex(this.re*other.re-this.im*other.im,this.im*other.re+this.re*other.im);
	   	     
	   	     return sumTimes;
	   	
	   	
	   }
	
	   
	   public Complex times(double value){
	   	
	   	          return this.times(new Complex(value,0));
	   	          
	   	       //eller return new Complex(this.re*value,this.im*value)
	   	
	   }
	   
	   
	
	  public double getRe(){
	  	
	  	     return this.re;
	  	
	  	
	  }
	
	  
	  public double getIm(){
	  	
	  	    return this.im;
	  	    
	  }
	
	
	  public double getMagnitude() {
	  	
            return Math.sqrt(this.re*this.re + this.im*this.im);
      }

      
      public double getArgument() {
      	
            return Math.atan2(this.im,this.re);
        
    }
	
	
	
}