import java.util.Arrays;
import static org.junit.Assert.*;

import org.junit.Test;

/*
 * tests for the Maze class...
 */


public class MazeTest
{
	private String[] smallMaze = { "******", "*S  D*", "******" };
	private String[] fullMaze = { "***", "* *", "***" };

	@Test
	public void testGetNorth() {
		Maze m = new Maze(fullMaze);
		MazeCell center = m.getCell(1, 1);
		MazeCell cell = m.getNorthNeighbor(center);
		assertEquals("[0,1,*]", cell.toString());
	}
	
	@Test
	public void testGetNorth_2() {
		Maze m = new Maze(smallMaze);
		MazeCell center = m.getCell(2, 1);
		MazeCell cell = m.getNorthNeighbor(center);
		assertEquals("[1,1,S]", cell.toString());
	}

	@Test
	public void testGetSouth() {
		Maze m = new Maze(fullMaze);
		MazeCell center = m.getCell(1, 1);
		MazeCell cell = m.getSouthNeighbor(center);
		assertEquals("[2,1,*]", cell.toString());
	}

	@Test
	public void testGetEast() {
		Maze m = new Maze(fullMaze);
		MazeCell center = m.getCell(1, 1);
		MazeCell cell = m.getEastNeighbor(center);
		assertEquals("[1,2,*]", cell.toString());
	}

	@Test
	public void testGetWest() {
		Maze m = new Maze(fullMaze);
		MazeCell center = m.getCell(1, 1);
		MazeCell cell = m.getWestNeighbor(center);
		assertEquals("[1,0,*]", cell.toString());
	}

	@Test
	public void testGetNeighbors() {
		Maze m = new Maze(fullMaze);
		MazeCell center = m.getCell(1, 1);
		MazeCell[] neighbors = m.getNeighbors(center);
		assertEquals("[[0,1,*], [1,2,*], [1,0,*], [2,1,*]]",
				Arrays.toString(neighbors));
	}

	@Test
	public void testRandomNeighboringCellWithNoEmptySpaces() {
		Maze m = new Maze(fullMaze);
		MazeCell center = m.getCell(1, 1);
		MazeCell any = m.getRandomNeighboringCell(center);
		// Check that the random cell returned is one of the possible cells.
		boolean possibleCell = false;
		possibleCell = possibleCell || "[0,1,*]".equals(any.toString());
		possibleCell = possibleCell || "[1,2,*]".equals(any.toString());
		possibleCell = possibleCell || "[1,0,*]".equals(any.toString());
		possibleCell = possibleCell || "[2,1,*]".equals(any.toString());
		assertTrue(possibleCell);
	}
}
