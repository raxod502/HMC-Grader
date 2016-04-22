import static org.junit.Assert.*;
import java.util.Set;
import org.junit.Test;

public class DirectedWeightedGraphTest_AddEdge { 

  private static boolean TEST_ADJACENCY_LIST = true;
  private static boolean TEST_EDGE_LIST = false;
  private static boolean TEST_ADJACENCY_MATRIX = false;

  @Test
  public void testAddEdgeTwice() {
    if (TEST_ADJACENCY_LIST) {
      testAddEdgeTwice(new AdjacencyList<String, Integer>());
    }
    if (TEST_EDGE_LIST) {
      testAddEdgeTwice(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testAddEdgeTwice(new AdjacencyMatrix<String, Integer>());
    }
  }

  public void testAddEdgeTwice(DirectedWeightedGraph<String, Integer> myGraph) {
    boolean added = myGraph.addEdge("A", "B", new Integer(5));
    assertTrue(added);
    added = myGraph.addEdge("A", "B", new Integer(5));
    assertFalse(added);
    assertEquals(new Integer(5), myGraph.getEdge("A", "B"));
  }

  @Test
  public void testNeighbors() {
    if (TEST_ADJACENCY_LIST) {
      testNeighbors(new AdjacencyList<String, Integer>());
    }
    if (TEST_EDGE_LIST) {
      testNeighbors(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testNeighbors(new AdjacencyMatrix<String, Integer>());
    }
  }

  public void testNeighbors(DirectedWeightedGraph<String, Integer> myGraph) {
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
}