import static org.junit.Assert.*;
import java.util.Set;
import org.junit.Test;

public class DirectedWeightedGraphTest_AddNode { 

  private static boolean TEST_ADJACENCY_LIST = false;
  private static boolean TEST_EDGE_LIST = false;
  private static boolean TEST_ADJACENCY_MATRIX = true;

  @Test
  public void testAddNodeTwice() {
    if (TEST_ADJACENCY_LIST) {
      testAddNodeTwice(new AdjacencyList<String, Integer>());
    }
    if (TEST_EDGE_LIST) {
      testAddNodeTwice(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testAddNodeTwice(new AdjacencyMatrix<String, Integer>());
    }
  }

  public void testAddNodeTwice(DirectedWeightedGraph<String, Integer> myGraph) {
    boolean added = myGraph.addNode("B");
    assertTrue(added);
    added = myGraph.addNode("B");
    assertFalse(added);
    assertTrue(myGraph.containsNode("B"));
  }

  @Test
  public void testNotAdjacent() {
    if (TEST_ADJACENCY_LIST) {
      testNotAdjacent(new AdjacencyList<String, Integer>());
    }
    if (TEST_EDGE_LIST) {
      testNotAdjacent(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testNotAdjacent(new AdjacencyMatrix<String, Integer>());
    }
  }

  public void testNotAdjacent(DirectedWeightedGraph<String, Integer> myGraph) {
    myGraph.addNode("A");
    assertFalse(myGraph.adjacent("A", "B"));
  }

  @Test
  public void testNeighborsUnconnected() {
    if (TEST_ADJACENCY_LIST) {
      testNeighborsUnconnected(new AdjacencyList<String, Integer>());
    }
    if (TEST_EDGE_LIST) {
      testNeighborsUnconnected(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testNeighborsUnconnected(new AdjacencyMatrix<String, Integer>());
    }
  }

  public void testNeighborsUnconnected(
      DirectedWeightedGraph<String, Integer> myGraph) {
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
}