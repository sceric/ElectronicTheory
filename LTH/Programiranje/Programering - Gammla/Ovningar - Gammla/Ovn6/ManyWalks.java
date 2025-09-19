import se.lth.cs.pt.io.*;
import se.lth.cs.pt.random.*;
import se.lth.cs.pt.ovn.walk.*;

    public class ManyWalks {
	public static void main(String [] args) {
	    RandomNumberGenerator rng = new RandomNumberGenerator ();
	    ConsoleWriter writer = new ConsoleWriter();
	    int last = 0;
	    int steps = 0;
	    int[] nbrSteps = new int[31];
	    int nbrFalls = 0;
	    int blugg = 0;

	    for(int i =0 ; i < 10000 ; i++){
		last = 0;
	        steps  = 0;
		while(last < 10) {
		    if (last==0)
			last ++;
		    else{
			int guess = rng.randInt(1,100);
			
			if (guess <= 70) {
			    last++;
			} else if (guess > 75) {
			    if (last > 0) {
				last--;
			    }
			} else {
			    last = 12;
			}
		    }

		    steps++;
		 
		    if (last == 12){
			blugg ++;
			    
		    }
		}
		if (steps > 30) {
		    steps = 30;
		}
		if(last==10){
		    nbrSteps[steps]++;
		}
	    }
		
            writer.println ("Antalet gånger Fred trillade i vattnet var " + blugg);
	    writer.println ("Antalet gånger Fred lyckades passera med så många steg:");
	    for (int i = 10; i <= 30; i++){
		writer.println (nbrSteps[i]+" gånger med "+ i + " steg");
	    }
	    writer.println("Sista värdet är för försök med 30 steg eller fler");
	}
    }




