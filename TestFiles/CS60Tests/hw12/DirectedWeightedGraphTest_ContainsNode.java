import static org.junit.Assert.*;
import java.util.Set;
import org.junit.Test;

public class DirectedWeightedGraphTest_ContainsNode { 

  private static boolean TEST_ADJACENCY_LIST = true;
  private static boolean TEST_EDGE_LIST = false;
  private static boolean TEST_ADJACENCY_MATRIX = false;

  @Test    
  public void testEmptyContainsNode() { 
    if (TEST_ADJACENCY_LIST) {
      testEmptyContainsNode(new AdjacencyList<String, Integer>());
    } 
    if (TEST_EDGE_LIST) {
      testEmptyContainsNode(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testEmptyContainsNode(new AdjacencyMatrix<String, Integer>());
    }
  }
 
  // Check if an empty graph contains a node
  public void testEmptyContainsNode(DirectedWeightedGraph<String, Integer> myGraph) {
    assertFalse(myGraph.containsNode("B"));
  }

  @Test
  public void testContainsNode() {
    if (TEST_ADJACENCY_LIST) {
      testContainsNode(new AdjacencyList<String, Integer>());
    }
    if (TEST_EDGE_LIST) {
      testContainsNode(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testContainsNode(new AdjacencyMatrix<String, Integer>());
    }
  }

  public void testContainsNode(DirectedWeightedGraph<String, Integer> myGraph) {
    boolean added = myGraph.addNode("B");
    assertTrue(added);
    assertTrue(myGraph.containsNode("B"));
  }
}