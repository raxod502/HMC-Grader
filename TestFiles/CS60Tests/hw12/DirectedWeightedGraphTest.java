import static org.junit.Assert.*;
import java.util.Set;
import org.junit.Test;

public class DirectedWeightedGraphTest { 

  private static boolean TEST_ADJACENCY_LIST = false;
  private static boolean TEST_EDGE_LIST = true;
  private static boolean TEST_ADJACENCY_MATRIX = true;

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
  public void testEmptyContainsNode(
      DirectedWeightedGraph<String, Integer> myGraph) {
    assertFalse(myGraph.containsNode("B"));
  }

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

  // Check if an empty graph contains a node
  public void testEmptyContainsEdge(
      DirectedWeightedGraph<String, Integer> myGraph) {
    assertEquals(null, myGraph.getEdge("A", "B"));
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

  // Check if an empty graph contains a node
  public void testContainsEdge(DirectedWeightedGraph<String, Integer> myGraph) {
    boolean added = myGraph.addEdge("A", "B", new Integer(5));
    assertTrue(added);
    assertEquals(new Integer(5), myGraph.getEdge("A", "B"));
  }

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

  // Check if an empty graph contains a node
  public void testAddEdgeTwice(DirectedWeightedGraph<String, Integer> myGraph) {
    boolean added = myGraph.addEdge("A", "B", new Integer(5));
    assertTrue(added);
    added = myGraph.addEdge("A", "B", new Integer(5));
    assertFalse(added);
    assertEquals(new Integer(5), myGraph.getEdge("A", "B"));
  }

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
  public void testContains2() {
    if (TEST_ADJACENCY_LIST) {
      testContains2(new AdjacencyList<String, Integer>());
    }
    if (TEST_EDGE_LIST) {
      testContains2(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testContains2(new AdjacencyMatrix<String, Integer>());
    }
  }

  public void testContains2(DirectedWeightedGraph<String, Integer> myGraph) {
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
  public void testContains3() {
    if (TEST_ADJACENCY_LIST) {
      testContains3(new AdjacencyList<String, Integer>());
    }
    if (TEST_EDGE_LIST) {
      testContains3(new EdgeList<String, Integer>());
    }
    if (TEST_ADJACENCY_MATRIX) {
      testContains3(new AdjacencyMatrix<String, Integer>());
    }
  }

  public void testContains3(DirectedWeightedGraph<String, Integer> myGraph) {
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