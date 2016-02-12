import java.util.Set;

public interface DirectedWeightedGraph<NodeDataType, EdgeDataType> {
  
  // add, remove & access NODES
  public boolean addNode(NodeDataType nodeData);
  public boolean removeNode(NodeDataType nodeData);
  public boolean containsNode(NodeDataType nodeData);
  
  // add, remove, and access EDGES
  public boolean addEdge(NodeDataType srcNode, NodeDataType dstNode, EdgeDataType edge);
  public EdgeDataType removeEdge(NodeDataType srcNode, NodeDataType dstNode);
  public EdgeDataType getEdge(NodeDataType srcNode, NodeDataType dstNode);
  public boolean adjacent(NodeDataType srcNode, NodeDataType dstNode);

  // get the neighbors for one NODE
  public Set<NodeDataType> neighbors(NodeDataType srcNode);

  // get all nodes
  public Set<NodeDataType> getNodes();  

}


 