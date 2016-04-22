import static org.junit.Assert.*;
import java.util.Set;
import org.junit.Test;

public class AdjacencyMatrixTest {

    @Test
	public void testAddNodeBasic() {
        AdjacencyMatrix<String, Integer> myGraph = new AdjacencyMatrix<String, Integer>();
		boolean added = myGraph.addNode("A");
		assertTrue(added);
	}

    @Test
	public void testAddTwoNodes() {
        AdjacencyMatrix<String, Integer> myGraph = new AdjacencyMatrix<String, Integer>();
		boolean added = myGraph.addNode("A");
		assertTrue(added);
		added = myGraph.addNode("B");
		assertTrue(added);
	}

    @Test
	public void testAddNodeTwice() {
        AdjacencyMatrix<String, Integer> myGraph = new AdjacencyMatrix<String, Integer>();
		boolean added = myGraph.addNode("B");
		assertTrue(added);
		added = myGraph.addNode("B");
		assertFalse(added);
	}
}
