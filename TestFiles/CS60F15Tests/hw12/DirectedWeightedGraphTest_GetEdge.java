import static org.junit.Assert.*;
import java.util.Set;
import org.junit.Test;

public class DirectedWeightedGraphTest_GetEdge { 

  private static boolean TEST_ADJACENCY_LIST = true;
  private static boolean TEST_EDGE_LIST = false;
  private static boolean TEST_ADJACENCY_MATRIX = false;

  @Test
  public void testEmptyContainsEdge() {
    if (TEST_ADJACENCY_LIST) {
      testEmptyContainsEdge(new AdjacencyList<String, Integer>());
    }
    if (TEST_EDGE_LIST) {
      testEmptyContainsEdge(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testEmptyContainsEdge(new AdjacencyMatrix<String, Integer>());
    }
  }

  // Check if an empty graph contains an edge
  public void testEmptyContainsEdge(
      DirectedWeightedGraph<String, Integer> myGraph) {
    assertEquals(null, myGraph.getEdge("A", "B"));
  }

  @Test
  public void testContainsEdge() {
    if (TEST_ADJACENCY_LIST) {
      testContainsEdge(new AdjacencyList<String, Integer>());
    }
    if (TEST_EDGE_LIST) {
      testContainsEdge(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testContainsEdge(new AdjacencyMatrix<String, Integer>());
    }
  }

  public void testContainsEdge(DirectedWeightedGraph<String, Integer> myGraph) {
    boolean added = myGraph.addEdge("A", "B", new Integer(5));
    assertTrue(added);
    assertEquals(new Integer(5), myGraph.getEdge("A", "B"));
  }
}