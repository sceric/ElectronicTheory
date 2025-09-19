import se.lth.cs.pt.ovn.oware.*;
import se.lth.cs.pt.random.*;
import se.lth.cs.pt.ovn.oware.OwareBoard;
import se.lth.cs.pt.ovn.oware.Oware;
import se.lth.cs.pt.ovn.oware.OwareView;

public class Player {

	 private int nbr;                // spelarens nummer (1 eller 2)
	 private char strat;             // spelarens strategi
	 private Oware theOware;         // spelet
	 private OwareView theView;      // vyn p skrmen
	 private int firstSq, lastSq;    // frsta resp. sista ruta
	 private RandomNumberGenerator rng = new RandomNumberGenerator();

    public Player(int nbr, char strat, Oware oware, OwareView view) {
	this.nbr = nbr;
	this.strat = strat;
	this.theOware = oware;
	this.theView = view;
	if(nbr==1){
	    this.firstSq = 1;
	    this.lastSq = 6;
	}else if(nbr == 2){
	    this.firstSq = 7;
	    this.lastSq = 12;
	}
    }

    public boolean lost() {
	for (int i=firstSq; i<=lastSq; i++){
	    if(theOware.getNbrOfPebbles(i)>0){
		return false;
	    }
	}		
	return true;
       
    }

    public void move() {
	int s = 0;
	while ( s==0 || firstSq>s || lastSq<s || theOware.getNbrOfPebbles(s)==0){
	    if( strat =='A'){
		s=theView.clickAndGetSquare();
	    }else{
		s=rng.randInt(firstSq, lastSq);
	    }
	}
	theOware.movePebbles(s);
    }
}



