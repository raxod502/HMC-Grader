import static org.junit.Assert.*;
import java.util.Set;
import org.junit.Test;

public class DirectedWeightedGraphTest_RemoveEdge { 

  private static boolean TEST_ADJACENCY_LIST = true;
  private static boolean TEST_EDGE_LIST = false;
  private static boolean TEST_ADJACENCY_MATRIX = false;

  @Test
  public void testRemoveEdge() {
    if (TEST_ADJACENCY_LIST) {
      testRemoveEdge(new AdjacencyList<String, Integer>());
    }
    if (TEST_EDGE_LIST) {
      testRemoveEdge(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testRemoveEdge(new AdjacencyMatrix<String, Integer>());
    }
  }

  public void testRemoveEdge(DirectedWeightedGraph<String, Integer> myGraph) {
    boolean added = myGraph.addEdge("A", "B", new Integer(42));
    assertTrue(added);
    assertTrue(myGraph.adjacent("A", "B"));
    Integer edgeRemoved = myGraph.removeEdge("A", "B");
    assertEquals(new Integer(42), edgeRemoved);
    assertFalse(myGraph.adjacent("A", "B"));
  }

  @Test
  public void testRemoveEdgeFromEmptyGraph() {
    if (TEST_ADJACENCY_LIST) {
      testRemoveEdgeFromEmptyGraph(new AdjacencyList<String, Integer>());
    }
    if (TEST_EDGE_LIST) {
      testRemoveEdgeFromEmptyGraph(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testRemoveEdgeFromEmptyGraph(new AdjacencyMatrix<String, Integer>());
    }
  }

  public void testRemoveEdgeFromEmptyGraph(
      DirectedWeightedGraph<String, Integer> myGraph) {
    Integer removed = myGraph.removeEdge("A", "B");
    assertEquals(null, removed);
  }

  @Test
  public void testContainsWithRemoveEdge() {
    if (TEST_ADJACENCY_LIST) {
      testContainsWithRemoveEdge(new AdjacencyList<String, Integer>());
    }
    if (TEST_EDGE_LIST) {
      testContainsWithRemoveEdge(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testContainsWithRemoveEdge(new AdjacencyMatrix<String, Integer>());
    }
  }

  public void testContainsWithRemoveEdge(DirectedWeightedGraph<String, Integer> myGraph) {
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
}