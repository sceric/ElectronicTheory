import se.lth.cs.pt.ovn.oware.OwareBoard;
//import se.lth.cs.pt.ovn.oware.Oware;
import se.lth.cs.pt.ovn.oware.OwareView;
import se.lth.cs.pt.random.*;

public class OwareTest {
    
    public static void main(String[] args) {
	
	OwareBoard theBoard  = new OwareBoard();
	Oware  theOware = new Oware(theBoard);
	OwareView theView = new OwareView(theOware);
	AbstractPlayer p1 = new HumanPlayer(1,theOware,theView);
	AbstractPlayer p2 = new ComputerPlayer(2,theOware);
	GameController game = new GameController(p1,p2,theOware,theView);
	game.playOneRound();
    }
}
abstract class AbstractPlayer {
    
    protected int nbr;
    protected Oware theOware;
    protected int firstSq, lastSq;
    
    /** beskriver spelare nbr (1 eller 2) som spelar spelet oware */
    public AbstractPlayer(int nbr, Oware oware) {
	this.nbr = nbr;
	this.theOware = oware;
	
	if (nbr == 1) {
	    firstSq = 1;
	    lastSq = 6;
	} else {
	    firstSq = 7;
	    lastSq = 12;
	}
        // ge attributen värden, även firstSq och lastSq
    }
    
    /** tag reda på om spelaren har förlorat (inte har några
        stenar kvar */
    public boolean lost() {
	for (int i=firstSq; i<=lastSq; i++) {
	    theOware.getNbrOfPebbles(i);
	    if  (theOware.getNbrOfPebbles(i)>0) {
		return false;
		
	    }
	    
	}
	return true;
        // implementera själv
    }

    /** låt spelaren göra ett drag */
    public abstract void move();
    
}

class HumanPlayer extends AbstractPlayer {
    
    private OwareView theView;
    
    public HumanPlayer(int nbr, Oware oware, OwareView view) {
	super(nbr,oware);
	this.theView = view;
        // implementera själv
    }
    
    public void move() {
        // implementera själv
	int ruta =0;
	while (ruta<firstSq || ruta>lastSq || ruta==0) {
	    ruta = theView.clickAndGetSquare();
	    while (theOware.getNbrOfPebbles(ruta)==0) {
		ruta = theView.clickAndGetSquare();
		
	    }
	    theOware.movePebbles(ruta);
	}
    }
}

class ComputerPlayer extends AbstractPlayer {
    
    private RandomNumberGenerator rng = new RandomNumberGenerator();
    
    public ComputerPlayer(int nbr, Oware oware) {
	super(nbr,oware);
        // ...
    }

    public void move() {
	int ruta =0;
	ruta = rng.randInt(this.firstSq, this.lastSq);
	while (theOware.getNbrOfPebbles(ruta)==0) {
	    ruta = rng.randInt(this.firstSq, this.lastSq);
	}
	theOware.movePebbles(ruta);
        // implementera själv
    }
}
class GameController {
    
    private AbstractPlayer p1, p2;
    private Oware theOware;
    private OwareView theView;
    
    public GameController(AbstractPlayer p1, AbstractPlayer p2, Oware oware, OwareView view) {
	this.p1 = p1;
	this.p2 = p2;
	this.theOware = oware;
	this.theView = view;
    }
    
    public void playOneRound() {
	theOware.setupStartPosition(2);
	theView.drawPebbles();
	while(p1.lost() !=true && p2.lost() !=true) {
	    p1.move();
	    theView.drawPebbles();
	    if( p2.lost()==false) {
		p2.move();
		theView.drawPebbles();
	    }
	}
    }
}




