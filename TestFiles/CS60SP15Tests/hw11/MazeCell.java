/**
 * MazeCell class represents a single cell in a Spampede Maze.
 **/

public class MazeCell {
	// the different meanings of various contents:
	public static final char SPAM = 'X';
	public static final char WALL = '*';
	public static final char OPEN = ' ';
	public static final char HEAD = 'H';
	public static final char BODY = 'B';

	// the private data in each MazeCell
	private int row; // The row at which this cell is located
	private int col; // The col at which this cell is located
	private char contents; // Each cell has contents (a char)
	private boolean visited; // A cell can be marked as visited.
	private MazeCell parent; // parent is where we came from!

	/*
	 * Constructor of the MazeElement at row, col, with contents c. 
	 * "visited" is set to false, and "parent" is set to null
	 */
	public MazeCell(int row, int col, char c) {
		this.row = row; // this is required to avoid name confusion!
		this.col = col; // ditto
		this.contents = c;
		this.visited = false; // we haven't been here yet...
		this.parent = null; // ... so we have no parent yet
	}

	// toString returns the string representation of a MazeElement
	public String toString() {
		return "[" + this.row + "," + this.col + "," + this.contents + "]";
	}

	/*
	 * Get basic information about a cell
	 */
	// returns the row of this MazeCell.
	public int getRow() {
		return this.row;
	}
	// returns the column of this MazeCell
	public int getCol() {
		return this.col;
	}
	// check if it is a wall
	public boolean isWall() {
		return this.contents == MazeCell.WALL;
	}
	// check if it is open (not a wall or a pede)
	public boolean isOpen() {
		return this.contents == MazeCell.OPEN || this.isSpam();
	}
	// check if it is spam
	public boolean isSpam() {
		return this.contents == MazeCell.SPAM;
	}
	// check if it is part of the pede (not the head)
	public boolean isBody() {
		return this.contents == MazeCell.BODY;
	}

	// check if it is the head of the pede
	public boolean isHead() {
		return this.contents == MazeCell.HEAD;
	}
	// get the contents of the MazeCell
	public char getContents() {
		return this.contents;
	}
	// set the contents of the MazeCell
	public void setContents(char new_char) {
		this.contents = new_char;
	}

	/*
	 * Modify the MazeCell in common ways...
	 */
	// Make the particular MazeCell be Open
	public void clearContents() {
		this.contents = MazeCell.OPEN;
	}
	// Make the particular MazeCell be Spam
	public void makeSpam() {
		this.contents = MazeCell.SPAM;
	}
	// Make the particular MazeCell the pede head
	public void makeHead() {
		this.contents = MazeCell.HEAD;
	}
	// Make the particular MazeCell the pede body
	public void makeBody() {
		this.contents = MazeCell.BODY;
	}

	/*
	 * Methods for setting, accessing and reseting visited
	 */

	// setting visited to be true
	public void visit() {
		this.visited = true;
	}

	// accessing visited
	public boolean getVisited() {
		return this.visited;
	}

	// setting visisted to be false
	public void resetVisited() {
		this.visited = false;
	}

	/*
	 * Methods for setting, accessing, and reseting parent
	 */

	// set parent
	public void setParent(MazeCell p) {
		this.parent = p;
	}

	// access parent
	public MazeCell getParent() {
		return this.parent;
	}

	// reset parent
	public void resetParent() {
		this.parent = null;
	}
}
