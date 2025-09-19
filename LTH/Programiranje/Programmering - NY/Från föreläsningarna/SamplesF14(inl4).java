
import se.lth.cs.pt.random.*;
import se.lth.cs.pt.window.*;

class SamplesF14 {

    public static void main(String[] args) {
        Community community = new Community(100);
        CommunityView view = new CommunityView(community);
        for (int i = 1; i <= 365; i++) {
            community.think();
            view.update();
        }
    }

    static void ex1() {
        RandomNumberGenerator rng = new RandomNumberGenerator();
        int size = 16;
        int[][] pict = new int[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                pict[x][y] = rng.randInt(0,255);
            }
        }
    }
}

class Community {

    private int[][] voters;
    private int size;

    public Community(int size) {
        RandomNumberGenerator rng = new RandomNumberGenerator();
        this.voters = new int[size][size];
        this.size = size;
        for (int i = 1; i <= size*size/2; i++) {
            int x, y;
            do {
                x = rng.randInt(0,size-1);
                y = rng.randInt(0,size-1);
            } while (this.voters[x][y] == 1);
            this.voters[x][y] = 1;
        }
    }

    public int getSize() {
        return this.size;
    }

    public int getVoter(int x, int y) {
        return this.voters[x][y];
    }

    public void think() {
        RandomNumberGenerator rng = new RandomNumberGenerator();
        int[][] next = new int[this.size][this.size];
        for (int x = 1; x < this.size-1; x++) {
            for (int y = 1; y < this.size-1; y++) {
                int nbrOfReds = this.countRedsAround(x,y);
                if (nbrOfReds < 4) {
                    next[x][y] = 1;
                } else if (nbrOfReds > 4) {
                    next[x][y] = 0;
                } else {
                    if (rng.randInt(0,1) == 0) {
                        next[x][y] = 0;
                    } else {
                        next[x][y] = 1;
                    }
                }
            }
        }
        this.voters = next;
    }

    private int countRedsAround(int xPos, int yPos) {
        int count = 0;
        for (int x = xPos-1; x <= xPos+1; x++) {
            for (int y = yPos-1; y <= yPos+1; y++) {
                if (this.voters[x][y] == 0) {
                    count++;
                }
            }
        }
        if (this.voters[xPos][yPos] == 0) {
            count--;
        }
        return count;
    }
}

class CommunityView {

    private DotWindow w;
    private Community community;

    public CommunityView(Community community) {
        this.community = community;
        this.w = new DotWindow(this.community.getSize(),
                               this.community.getSize(),
                               10);
        this.w.fillWith(Color.GREEN);
    }
    
    public void update() {
        for (int x = 0; x < this.community.getSize(); x++) {
            for (int y = 0; y < this.community.getSize(); y++) {
                if (this.community.getVoter(x,y) == 0) {
                    this.w.setDot(x,y,Color.RED);
                } else {
                    this.w.setDot(x,y,Color.BLUE);
                }
            }
        }
    }
}
                
