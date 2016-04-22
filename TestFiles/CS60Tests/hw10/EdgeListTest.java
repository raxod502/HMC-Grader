import static org.junit.Assert.*;
import java.util.Set;
import org.junit.Test;

public class EdgeListTest {

	@Test
	public void testRemoveNode1() {
        EdgeList<String, Integer> myGraph = new EdgeList<String, Integer>(); 
		boolean added = myGraph.addNode("A");
		assertTrue(added);
		assertTrue(myGraph.containsNode("A"));
		boolean removed = myGraph.removeNode("A");
		assertTrue(removed);
		assertFalse(myGraph.containsNode("A"));
	}


   @Test
	public void testRemoveNode2() {
        EdgeList<String, Integer> myGraph = new EdgeList<String, Integer>(); 
		boolean addedA = myGraph.addNode("A");
		boolean addedB = myGraph.addNode("B");
		assertTrue(addedA);
		assertTrue(addedB);
		assertTrue(myGraph.containsNode("A"));
		assertTrue(myGraph.containsNode("B"));
		boolean removed = myGraph.removeNode("A");
		assertTrue(removed);
		assertFalse(myGraph.containsNode("A"));
		assertTrue(myGraph.containsNode("B"));
	}

}
