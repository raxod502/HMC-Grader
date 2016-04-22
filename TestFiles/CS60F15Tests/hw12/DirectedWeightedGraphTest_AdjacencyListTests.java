import static org.junit.Assert.*;
import java.util.Set;
import org.junit.Test;

public class DirectedWeightedGraphTest_AdjacencyListTests { 

  private static boolean TEST_ADJACENCY_LIST = true;
  private static boolean TEST_EDGE_LIST = false;
  private static boolean TEST_ADJACENCY_MATRIX = false;

  @Test
  public void testAdjacent() {
    if (TEST_ADJACENCY_LIST) {
      testAdjacent(new AdjacencyList<String, Integer>());
    }
    if (TEST_EDGE_LIST) {
      testAdjacent(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testAdjacent(new AdjacencyMatrix<String, Integer>());
    }
  }

  public void testAdjacent(DirectedWeightedGraph<String, Integer> myGraph) {
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
    if (TEST_ADJACENCY_LIST) {
      testGetNodes1Node(new AdjacencyList<String, Integer>());
    }
    if (TEST_EDGE_LIST) {
      testGetNodes1Node(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testGetNodes1Node(new AdjacencyMatrix<String, Integer>());
    }
  }

  public void testGetNodes1Node(DirectedWeightedGraph<String, Integer> myGraph) {
    boolean added = myGraph.addNode("A");
    assertTrue(added);
    Set<String> allNodes = myGraph.getNodes();
    assertEquals(1, allNodes.size());
    assertTrue(allNodes.contains("A"));
  }

  @Test
  public void testGetNodes1Edge() {
    if (TEST_ADJACENCY_LIST) {
      testGetNodes1Edge(new AdjacencyList<String, Integer>());
    }
    if (TEST_EDGE_LIST) {
      testGetNodes1Edge(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testGetNodes1Edge(new AdjacencyMatrix<String, Integer>());
    }
  }

  public void testGetNodes1Edge(DirectedWeightedGraph<String, Integer> myGraph) {
    boolean added = myGraph.addEdge("A", "B", new Integer(42));
    assertTrue(added);
    Set<String> allNodes = myGraph.getNodes();
    assertEquals(2, allNodes.size());
    assertTrue(allNodes.contains("A"));
    assertTrue(allNodes.contains("B"));
  }
  @Test
  public void testSelfNode() {
    if (TEST_ADJACENCY_LIST) {
      testSelfNode(new AdjacencyList<String, Integer>());
    }
    if (TEST_EDGE_LIST) {
      testSelfNode(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testSelfNode(new AdjacencyMatrix<String, Integer>());
    }
  }

  public void testSelfNode(DirectedWeightedGraph<String, Integer> myGraph) {
    boolean added = myGraph.addEdge("A", "A", new Integer(42));
    assertFalse(added);
    Set<String> allNodes = myGraph.getNodes();
    assertEquals(0, allNodes.size());
    assertFalse(allNodes.contains("A"));
    assertFalse(allNodes.contains("B"));
  }
}