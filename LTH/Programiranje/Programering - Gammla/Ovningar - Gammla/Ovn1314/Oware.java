
import se.lth.cs.pt.ovn.oware.OwareInterface;
import se.lth.cs.pt.ovn.oware.OwareBoard;

public class Oware implements OwareInterface {

    private OwareBoard theBoard                                                 /** skapa ett Oware-spel som kan spelas på  spelplanen board */
    public Oware(OwareBoard board) {
       this.theBoard = board;
    }
    	// implementera själv
    }

    /** sätt upp startställning (4 stenar i varje ruta) */
    public void setupStartPosition() {
	for
	    
	    // implementera själv
    }

    /** tag reda på antalet stenar i ruta nr s */
    public int getNbrOfPebbles(int s) {
        // implementera själv
    }

    /** gör ett drag: tag stenarna i ruta s,
        fördela dem i andra rutor enligt reglerna  */
    public void movePebbles(int s) {
        // här finns ett antal fel, försök rätta dem!
        int nbr = theBoard.getNbrOfPebbles(s);
        int start = s;
        while (nbr > 0) {
            s++;
            if (s == start) {
                s++;
            }
            nbr--;
            theBoard.putPebbles(s,1);
        }
        int last = s;
        while ((start <= 6 && last >= 7 || start >= 7 && last <= 6) &&
               (theBoard.getNbrOfPebbles(last) == 2 ||
                theBoard.getNbrOfPebbles(last) == 3)) {
            theBoard.takePebbles(last,theBoard.getNbrofPebbles(last));
            last--;
        }
    }
}
