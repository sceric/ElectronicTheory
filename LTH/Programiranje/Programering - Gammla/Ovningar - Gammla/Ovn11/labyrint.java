import se.lth.cs.pt.window.SimpleWindow;
import se.lth.cs.pt.ovn.maze.Maze;
import se.lth.cs.pt.turtle.Turtle;
import se.lth.cs.pt.clock.Clock;
import se.lth.cs.pt.io.*;

public class labyrint {
    public static void main (String[] args) {
    	
	ConsoleReader reader = new ConsoleReader();
	int nbr  = reader.readInt("Välj labyrint (1..4) ");
	SimpleWindow w = new SimpleWindow ( 500, 500, "Fönster");
	Maze maze = new Maze(w,nbr);
	MazeTurtle mt1 = new MazeTurtle(w,maze);
	mt1.walk();
    }
}

class MazeTurtle extends Turtle {

    private int n;
    private Maze maze;
    public MazeTurtle ( SimpleWindow w, Maze maze ) {
	super ( w, maze.getXEntry(), maze.getYEntry());
	this.maze = maze;
	this.penDown();
	this.n = 0;
    }

    public void walk() {
	//Maze maze = new Maze (w,1);
	ConsoleWriter writer = new ConsoleWriter();
	Clock clk = new Clock();
	while (!maze.atExit ( getX(), getY())) {
	    if (maze.wallAtLeft ( dir, getX(), getY()) && !maze.wallInFront ( dir, getX(), getY())) {
		this.forward(1);
		this.n = this.n + 1;
		clk.pause((2));
	    }
	    if (maze.wallAtLeft ( dir, getX(), getY()) && maze.wallInFront ( dir, getX(), getY())) {
		this.right(90);
		if ( maze.wallInFront ( dir, getX(), getY())) {
		    this.right(90);
		}
		this.forward(1);
		this.n= this.n + 1;
	    }
	    if ( !maze.wallAtLeft ( dir, getX(), getY())) {
		this.left(90);
		this.forward(1);
		this.n = this.n + 1;
	    }
	}
	writer.println ("Antal steg "+ n );
    }
}
	    


