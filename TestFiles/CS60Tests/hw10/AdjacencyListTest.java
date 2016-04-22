import static org.junit.Assert.*;
import java.util.Set;
import org.junit.Test;


public class AdjacencyListTest {

	@Test
	public void testContainsNode() {
        AdjacencyList<String, Integer> myGraph = new AdjacencyList<String, Integer>();
        boolean added = myGraph.addNode("B");
        assertTrue(added);
        assertTrue(myGraph.containsNode("B"));
	}

	@Test
	public void testAddNodeTwice() {
        AdjacencyList<String, Integer> myGraph = new AdjacencyList<String, Integer>();
		boolean added = myGraph.addNode("B");
		assertTrue(added);
		added = myGraph.addNode("B");
		assertFalse(added);
		assertTrue(myGraph.containsNode("B"));
	}

	@Test
	public void testContainsEdge() {
        AdjacencyList<String, Integer> myGraph = new AdjacencyList<String, Integer>();
		boolean added = myGraph.addEdge("A", "B", new Integer(5));
		assertTrue(added);
		assertEquals(new Integer(5), myGraph.getEdge("A", "B"));
	}

	@Test
	public void testAddEdgeTwice() {
        AdjacencyList<String, Integer> myGraph = new AdjacencyList<String, Integer>();
		boolean added = myGraph.addEdge("A", "B", new Integer(5));
		assertTrue(added);
		added = myGraph.addEdge("A", "B", new Integer(5));
		assertFalse(added);
		assertEquals(new Integer(5), myGraph.getEdge("A", "B"));
	}

	@Test
	public void testRemoveNode() {
        AdjacencyList<String, Integer> myGraph = new AdjacencyList<String, Integer>();
		boolean added = myGraph.addNode("A");
		assertTrue(added);
		assertTrue(myGraph.containsNode("A"));
		boolean removed = myGraph.removeNode("A");
		assertTrue(removed);
		assertFalse(myGraph.containsNode("A"));
		assertFalse(myGraph.containsNode("B"));
	}

	@Test
	public void testContains2() {
        AdjacencyList<String, Integer> myGraph = new AdjacencyList<String, Integer>();
		// contains nodes A and B after adding edge A->B
		boolean added = myGraph.addEdge("A", "B", new Integer(42));
		assertTrue(added);
		assertTrue(myGraph.containsNode("A"));
		assertTrue(myGraph.containsNode("B"));
		// still contains nodes A and B after removing edge A->B
		Integer edgeRemoved = myGraph.removeEdge("A", "B");
		assertEquals(new Integer(42), edgeRemoved);
		assertTrue(myGraph.containsNode("A"));
		assertTrue(myGraph.containsNode("B"));
	}

	@Test
	public void testContains3() {
        AdjacencyList<String, Integer> myGraph = new AdjacencyList<String, Integer>();
		myGraph.addNode("A");
		assertTrue(myGraph.containsNode("A"));
		assertFalse(myGraph.containsNode("B"));
		myGraph.addNode("B");
		assertTrue(myGraph.containsNode("A"));
		assertTrue(myGraph.containsNode("B"));
		myGraph.removeNode("A");
		assertFalse(myGraph.containsNode("A"));
		assertTrue(myGraph.containsNode("B"));
	}

	@Test
	public void testRemoveEdge() {
        AdjacencyList<String, Integer> myGraph = new AdjacencyList<String, Integer>();
		boolean added = myGraph.addEdge("A", "B", new Integer(42));
		assertTrue(added);
		assertTrue(myGraph.adjacent("A", "B"));
		Integer edgeRemoved = myGraph.removeEdge("A", "B");
		assertEquals(new Integer(42), edgeRemoved);
		assertFalse(myGraph.adjacent("A", "B"));
	}

	@Test
	public void testRemoveConnectedNode() {
        AdjacencyList<String, Integer> myGraph = new AdjacencyList<String, Integer>();
		boolean added = myGraph.addEdge("A", "B", new Integer(42));
		assertTrue(added);
		assertTrue(myGraph.adjacent("A", "B"));
		myGraph.removeNode("A");
		assertFalse(myGraph.adjacent("A", "B"));
	}

	@Test
	public void testNeighborsUnconnected() {
        AdjacencyList<String, Integer> myGraph = new AdjacencyList<String, Integer>();
		boolean added = myGraph.addNode("A");
		assertTrue(added);
		added = myGraph.addNode("B");
		assertTrue(added);
		added = myGraph.addNode("C");
		assertTrue(added);
		Set<String> neighborsOfA = myGraph.neighbors("A");
		assertEquals(0, neighborsOfA.size());
		assertFalse(neighborsOfA.contains("A"));
		assertFalse(neighborsOfA.contains("B"));
		assertFalse(neighborsOfA.contains("C"));
		// Neighbors for a node not in the graph
		Set<String> neighborsOfD = myGraph.neighbors("D");
		assertEquals(0, neighborsOfD.size());
		assertFalse(neighborsOfD.contains("A"));
		assertFalse(neighborsOfD.contains("B"));
		assertFalse(neighborsOfD.contains("C"));

	}

	@Test
	public void testNeighbors() {
        AdjacencyList<String, Integer> myGraph = new AdjacencyList<String, Integer>();
        boolean added = myGraph.addEdge("A", "B", new Integer(42));
		assertTrue(added);
		added = myGraph.addEdge("B", "C", new Integer(18));
		assertTrue(added);
		added = myGraph.addEdge("C", "D", new Integer(52));
		assertTrue(added);
		added = myGraph.addEdge("C", "A", new Integer(18));
		assertTrue(added);

		Set<String> neighborsOfA = myGraph.neighbors("A");
		assertEquals(1, neighborsOfA.size());
		assertFalse(neighborsOfA.contains("A"));
		assertTrue(neighborsOfA.contains("B"));
		assertFalse(neighborsOfA.contains("C"));
		assertFalse(neighborsOfA.contains("D"));

		Set<String> neighborsOfB = myGraph.neighbors("B");
		assertEquals(1, neighborsOfB.size());
		assertFalse(neighborsOfB.contains("A"));
		assertFalse(neighborsOfB.contains("B"));
		assertTrue(neighborsOfB.contains("C"));
		assertFalse(neighborsOfB.contains("D"));

		Set<String> neighborsOfC = myGraph.neighbors("C");
		assertEquals(2, neighborsOfC.size());
		assertTrue(neighborsOfC.contains("A"));
		assertFalse(neighborsOfC.contains("B"));
		assertFalse(neighborsOfC.contains("C"));
		assertTrue(neighborsOfC.contains("D"));

		Set<String> neighborsOfD = myGraph.neighbors("D");
		assertEquals(0, neighborsOfD.size());
		assertFalse(neighborsOfD.contains("A"));
		assertFalse(neighborsOfD.contains("B"));
		assertFalse(neighborsOfD.contains("C"));
		assertFalse(neighborsOfD.contains("D"));

	}

	@Test
	public void testAdjacent() {
        AdjacencyList<String, Integer> myGraph = new AdjacencyList<String, Integer>();
        // A ; B
		myGraph.addNode("A");
		myGraph.addNode("B");
		assertFalse(myGraph.adjacent("A", "B"));
		assertFalse(myGraph.adjacent("B", "A"));
		// A -> B
		myGraph.addEdge("A", "B", new Integer(18));
		assertTrue(myGraph.adjacent("A", "B"));
		assertFalse(myGraph.adjacent("B", "A"));
		// A -> B ; C
		myGraph.addNode("C");
		assertTrue(myGraph.adjacent("A", "B"));
		assertFalse(myGraph.adjacent("A", "C"));
		assertFalse(myGraph.adjacent("B", "A"));
		assertFalse(myGraph.adjacent("B", "C"));
		assertFalse(myGraph.adjacent("C", "A"));
		assertFalse(myGraph.adjacent("C", "B"));
		// C -> A -> B
		myGraph.addEdge("C", "A", new Integer(42));
		assertTrue(myGraph.adjacent("A", "B"));
		assertFalse(myGraph.adjacent("A", "C"));
		assertFalse(myGraph.adjacent("B", "A"));
		assertFalse(myGraph.adjacent("B", "C"));
		assertTrue(myGraph.adjacent("C", "A"));
		assertFalse(myGraph.adjacent("C", "B"));
	}

	@Test
	public void testGetNodes1Node() {
        AdjacencyList<String, Integer> myGraph = new AdjacencyList<String, Integer>();
        boolean added = myGraph.addNode("A");
		assertTrue(added);
		Set<String> allNodes = myGraph.getNodes();
		assertEquals(1, allNodes.size());
		assertTrue(allNodes.contains("A"));
	}

	@Test
	public void testGetNodes1Edge() {
        AdjacencyList<String, Integer> myGraph = new AdjacencyList<String, Integer>();
        boolean added = myGraph.addEdge("A", "B", new Integer(42));
		assertTrue(added);
		Set<String> allNodes = myGraph.getNodes();
		assertEquals(2, allNodes.size());
		assertTrue(allNodes.contains("A"));
		assertTrue(allNodes.contains("B"));
	}
	@Test
	public void testSelfNode() {
        AdjacencyList<String, Integer> myGraph = new AdjacencyList<String, Integer>();
        boolean added = myGraph.addEdge("A", "A", new Integer(42));
		assertFalse(added);
		Set<String> allNodes = myGraph.getNodes();
		assertEquals(0, allNodes.size());
		assertFalse(allNodes.contains("A"));
		assertFalse(allNodes.contains("B"));
	}

}
