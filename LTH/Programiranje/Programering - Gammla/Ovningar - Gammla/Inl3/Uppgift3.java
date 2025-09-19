import se.lth.cs.pt.inl.inl3.*;
import se.lth.cs.jlist.*;

public class Uppgift3 implements Inl3 {

    public static void main(String[] args) {
        // ändra inte i detta huvudprogram!
        new Tester().test(new Uppgift3());
    }

    public void append(CharList list1, CharList list2) {
        // implementera!
	
	int n2 = list2.cardinal();
	CharElement elem1 = (CharElement) list2.first();
	CharElement elem2;

	for(int n = 1; n<=n2; n++){
	    elem2 = (CharElement) elem1.suc();	   
	    elem1.into(list1);    
	    elem1 = elem2;
	}
    }

    public char getPenultimate(CharList list) {
        // implementera!
	
	CharElement elem1 = (CharElement) list.last();
	int n2 = list.cardinal();
	int n3 = 0;
	int n = 1;

	if( n2 > n ){
	    CharElement elem2 = (CharElement) elem1.pred();
	    return elem2.getChar();
	}
	else{
	    return '?';
	}
    }

    public void delete(CharList list, char ch) {
        // implementera!

	CharElement elem1 = (CharElement) list.last();
	CharElement elem2;
	int n2 = list.cardinal();
	
	for(int n = 1; n<=n2; n++){
	    
	    elem2 = (CharElement) elem1.pred();
	    
	    if(elem1.getChar() == ch){
		elem1.out();
	    }
	    elem1 = elem2;
	}

    }

    public void insert(CharList list, char ch, char newChar) {
        // implementera!
	
	CharElement elem1 = (CharElement) list.last();
	CharElement elem2;
	CharElement elem3 = new CharElement(newChar);
	int n2 = list.cardinal();
	
	for(int n = 1; n<=n2; n++){
	    
	    elem2 = (CharElement) elem1.pred();
	    
	    if(elem1.getChar() == ch){
		elem3.follow(elem1);

	    }
	    elem1 = elem2;
	}

    }

    public CharList copy(CharList list) {
        // implementera!

	CharList copy = new CharList();
        CharElement elem1 = (CharElement) list.first();
	
	
	int n2 = list.cardinal();

	for(int n = 1; n<=n2 ;n++){
       
	    CharElement elem2 = new CharElement( elem1.getChar());
	    elem2.into(copy);
	    elem1 = (CharElement) elem1.suc();
	
	}
    
	
	return copy;
    }
    
    public CharList createReversed(CharList list) {
	
	// implementera!

	CharList copy2 = new CharList();
        CharElement elem1 = (CharElement) list.last();
	
	
	int n2 = list.cardinal();

	for(int n = 1; n<=n2 ;n++){
       
	    CharElement elem2 = new CharElement( elem1.getChar());
	    elem2.into(copy2);
	    elem1 = (CharElement) elem1.pred();
	
	}
    
	
	return copy2;
    }

    public void reverse(CharList list) {
	 // implementera!

	CharElement elem1 = (CharElement) list.first();
	CharElement elem2; 
	

	int n2 = list.cardinal();

	for(int n = 1; n<=(n2-1) ;n++){
	    
	    elem2 = (CharElement) elem1.suc();

	    elem2.intoAsFirst(list);
	    
	   
	   
	}  
    }
	    


}
