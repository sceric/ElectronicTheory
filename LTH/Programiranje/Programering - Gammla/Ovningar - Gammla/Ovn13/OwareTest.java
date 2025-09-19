
    
import se.lth.cs.pt.ovn.oware.*;
import se.lth.cs.pt.random.*;
import se.lth.cs.pt.ovn.oware.OwareBoard;
import se.lth.cs.pt.ovn.oware.Oware;
import se.lth.cs.pt.ovn.oware.OwareView;

public class kuntaKinte {
    public static void main(String[] args){
	OwareBoard oware = new OwareBoard(); 
	Oware OwareBoard = new Oware(board);
	OwareView Oware = new OwareView(oware);
	
    }
	public class Player {

	    private int nbr;                // spelarens nummer (1 eller 2)
	    private char strat;             // spelarens strategi
	    private Oware theOware;         // spelet
	    private OwareView theView;      // vyn p skrmen
	    private int firstSq, lastSq;    // frsta resp. sista ruta
	    private RandomNumberGenerator rng = new RandomNumberGenerator();
	}
    }
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
	for (int i=firstSq; i<=lastAq; i++){
	    if(theOware.getNbrOfPebbles(i)>0){
		return false;
	    }else{
		return true;
	    }
	}
    }

    public void move() {
	int s = 0;
	while ( s==0 || firstSq<s || lastSq>s || theOware.getNbrOfPebbles(s)==0){
	    if( strat =='A'){
		s=theView.clickAndGetSquare();
	    }else{
		s=randInt(firstSq, lastSq);
	    }
	}
	theOware.movePebbles(s);
    }
    public class GameController {

	private Player p1, p2;
	private Oware theOware;
	private OwareView theView;

    public GameController(Player p1, Player p2, Oware oware, OwareView view) {
	this.p1=p1;
	this.p2=p2;
	this.theOware = oware;
	this.theView =view;
    }

    public void playOneRound(){
	theOware.setUpStartPositions(2);
	Player current=p1;
	while(current.Lost()==false){
	    current.move();
	    if(current==p1){
		current=p2;
	    }else{
		current==p1;
	    }
	}theOware.drawPebbles();

    }
}






