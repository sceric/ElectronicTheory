import se.lth.cs.pt.ovn.oware.*;
import se.lth.cs.pt.random.*;
import se.lth.cs.pt.ovn.oware.OwareBoard;
import se.lth.cs.pt.ovn.oware.Oware;
import se.lth.cs.pt.ovn.oware.OwareView;

public class GameController {

    private Player p1, p2;
    private Oware theOware;
    private OwareView theView;
    
    public GameController(Player p1, Player p2, Oware oware, OwareView view) {
	this.p1=p1;
	this.p2=p2;
	this.theOware = oware;
	this.theView = view;
    }

    public void playOneRound(){
	theOware.setupStartPosition(2);
	theView.drawPebbles();
	Player current=p1;
	while(current.lost()==false){
	    current.move();
	    theView.drawPebbles();
	    if(current==p1){
	        current=p2;
	    }else{
		current=p1;
	    }
	}
	//	theView.drawPebbles();
	
    }
}


