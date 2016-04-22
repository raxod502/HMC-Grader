import static org.junit.Assert.*;
import java.util.Set;
import org.junit.Test;

public class DirectedWeightedGraphTest_RemoveNode { 

  private static boolean TEST_ADJACENCY_LIST = false;
  private static boolean TEST_EDGE_LIST = true;
  private static boolean TEST_ADJACENCY_MATRIX = false;

  @Test
  public void testRemoveNode() {
    if (TEST_ADJACENCY_LIST) {
      testRemoveNode(new AdjacencyList<String, Integer>());
    }
    if (TEST_EDGE_LIST) {
      testRemoveNode(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testRemoveNode(new AdjacencyMatrix<String, Integer>());
    }
  }

  public void testRemoveNode(DirectedWeightedGraph<String, Integer> myGraph) {
    // A
    boolean added = myGraph.addNode("A");
    assertTrue(added);
    assertTrue(myGraph.containsNode("A"));
    boolean removed = myGraph.removeNode("A");
    assertTrue(removed);
    assertFalse(myGraph.containsNode("A"));
    assertFalse(myGraph.containsNode("B"));
  }

  @Test
  public void testRemoveNodeFromEmptyGraph() {
    if (TEST_ADJACENCY_LIST) {
      testRemoveNodeFromEmptyGraph(new AdjacencyList<String, Integer>());
    }
    if (TEST_EDGE_LIST) {
      testRemoveNodeFromEmptyGraph(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testRemoveNodeFromEmptyGraph(new AdjacencyMatrix<String, Integer>());
    }
  }

  public void testRemoveNodeFromEmptyGraph(
      DirectedWeightedGraph<String, Integer> myGraph) {
    boolean removed = myGraph.removeNode("A");
    assertFalse(removed);
  }

  @Test
  public void testContainsWithRemoveNode() {
    if (TEST_ADJACENCY_LIST) {
      testContainsWithRemoveNode(new AdjacencyList<String, Integer>());
    }
    if (TEST_EDGE_LIST) {
      testContainsWithRemoveNode(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testContainsWithRemoveNode(new AdjacencyMatrix<String, Integer>());
    }
  }

  public void testContainsWithRemoveNode(DirectedWeightedGraph<String, Integer> myGraph) {
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
  public void testRemoveConnectedNode() {
    if (TEST_ADJACENCY_LIST) {
      testRemoveConnectedNode(new AdjacencyList<String, Integer>());
    }
    if (TEST_EDGE_LIST) {
      testRemoveConnectedNode(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testRemoveConnectedNode(new AdjacencyMatrix<String, Integer>());
    }
  }

  public void testRemoveConnectedNode(
      DirectedWeightedGraph<String, Integer> myGraph) {
    boolean added = myGraph.addEdge("A", "B", new Integer(42));
    assertTrue(added);
    assertTrue(myGraph.adjacent("A", "B"));
    myGraph.removeNode("A");
    assertFalse(myGraph.adjacent("A", "B"));
  }
}