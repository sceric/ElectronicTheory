import se.lth.cs.pt.ovn.oware.*;
import se.lth.cs.pt.random.*;
import se.lth.cs.pt.ovn.oware.OwareBoard;
import se.lth.cs.pt.ovn.oware.Oware;
import se.lth.cs.pt.ovn.oware.OwareView;

public class kulor {
    public static void main(String[] args){
	OwareBoard board = new OwareBoard(); 
	Oware oware = new Oware(board);
	OwareView view = new OwareView(oware);
	Player p1=new Player(1,'A',oware, view); 
	Player p2=new Player(2,'B',oware, view);
	GameController g1 = new	GameController(p1,p2,oware,view);
	g1.playOneRound();
    }
}
