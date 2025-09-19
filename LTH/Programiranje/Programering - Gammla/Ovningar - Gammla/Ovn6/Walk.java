import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;
import se.lth.cs.pt.ovn.walk.StoneWindow;
import se.lth.cs.pt.util.*;
import se.lth.cs.pt.clock.*;

    public class Walk {
	public static void main(String [] args) {
	    Clock clk = new Clock();
	    RandomNumberGenerator rng = new RandomNumberGenerator ();
	    StoneWindow w = new StoneWindow();
	    ConsoleWriter writer = new ConsoleWriter ();
	    int last = 0;
	    int steps = 0;
	    w.setUp();
	    clk. pause (1000);
	    w.drawMan(0);
	    while(last < 10) {

		 clk.pause (1000);
		 w.eraseMan(last);
		 int guess = rng.randInt(1,100);
		 if (guess <= 70 || last == 0) {
		     last++;
		 } else if (guess> 75) {
		     last--;
		 } else {
		     w.drawManInWater(last);
		     last = 12;
		 }
		 if (last != 12) {
		     w.drawMan(last);
		 }
		 steps++;
	    }
	    if (last == 12) {
		writer.print("Fred drunknar");
	    } else {
		writer.print("Fred kom över, med " + steps + " steg. BRA");
	    }
	}
    }
