

import se.lth.cs.pt.random.*;



	class Card{
		
       public int color;
       public int value;
       

        public Card(int color,int value){
        
          this.color=color;
          this.value=value;	
        	
        	
        }
        
        
        public int getColor(){
        
           return this.color;	
        	
        	
        }
        
        
        public int getValue(){
        
        	return this.value;	
        	
        }
        
       	
	
 }
 
 


 class CardDeck{
 	
 	 private Card[] cards; 
 	 private int nbrOfCards;
 	 private RandomNumberGenerator rng;
 	 private int color;
 	 private int value;
 	
		public CardDeck(){
			
			this.cards=new Card[52];
			this.nbrOfCards=0;
			this.rng= new RandomNumberGenerator();
			
			for(int value=1;value<=13;value++){
				
			this.cards[this.nbrOfCards++]=new Card(color,value);
		
				
			}
			
		}
		
		
		public void shuffle(){
			
		  for(int k=0;k<=50;k++){
		  	
		  	this.cards[k]=this.rng.random(1,51);
		  	
		  	}	
			
			
		}
		
		
		public Card getCard(){
			
			return this.cards;
			
		}
		
		
		public boolean cardsLeft(){
			
			
			
			
		}
 	
 	
 	
 	
 	
 	
 }