import se.lth.cs.pt.ovn.life.*;

public class Life {
    
    public static void main(String[] args) {
        Board newBoard = new Board (20);
	LifeView newLifeView = new LifeView();
	newLifeView.show(newBoard);
	LifePlayer P = new LifePlayer();
	int command = newLifeView.getCommand();
	while (command != 3) {
	    if (command == 1) {
		int xPos = newLifeView.getClickedX();
		int yPos = newLifeView.getClickedY();   
		newBoard.flip( xPos, yPos);
	    } else if ( command ==2 ) {
		newBoard = P.nextGeneration(newBoard);
	    }
	    newLifeView.show(newBoard);
	    command = newLifeView.getCommand();
	}
        System.exit(0);
    }
}

class Board implements LifeBoard {
    
    private int n;
    private boolean [][] sq;
   
    public Board (int size) {
	this.n = size;
	this.sq = new boolean [this.n][this.n];
    }
  
    public int getSize() {
	return this.n;
    }
   
    private boolean validPos (int x, int y) {
	return
	    0 <= x && x < this.n &&
	    0 <= y && y < this.n;
    }
   
    public boolean getValue(int x, int y) {
	if (this.validPos(x,y)) {
	    return this.sq[x] [y];
	} else {
	    return false;
	}
    }
   
    public void setValue(int x, int y, boolean value) {
	if (this.validPos(x,y)) {
	    this.sq[x] [y] = value;
	}
    }
    public void flip(int x, int y) {
	this.setValue(x,y,!this.getValue(x,y));
    }
}

class LifePlayer {

    private int getNeighbours(Board board, int x, int y) {
	int count = 0;
	for (int xpos = x-1 ; xpos <= x+1 ; xpos++) {
	    for (int ypos = y-1 ; ypos <= y+1 ; ypos++) {
		if (board.getValue(xpos,ypos)) {
		    count++;
		}
	    }
	}
	if (board.getValue(x,y)) {
	    count--;
	}
	return count;
    }
    
    public Board nextGeneration(Board board) {
        Board newBoard = new Board(board.getSize());
	for (int i = 0 ; i < board.getSize() ; i++) {
	    for (int j = 0 ; j < board.getSize() ; j++) {
		int count = this.getNeighbours(board, i, j);
		if (count < 2 || count > 3) {
		    newBoard.setValue(i,j,false);
		} else if (count == 3) {
		     newBoard.setValue(i,j,true);
		} else {
		      newBoard.setValue(i,j,board.getValue(i,j));
		}
	    }
	}
	return newBoard;
    }
}
