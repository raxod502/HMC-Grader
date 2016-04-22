import java.util.Set;

/**
 * An interface that describes operations provided by a directed, weighted graph
 * @param <NodeDataType> The type of values to store in nodes
 * @param <EdgeDataType> The type of values to associate with edges
 */
public interface DirectedWeightedGraph<NodeDataType, EdgeDataType> {

    /**
     * Returns the data associated with an edge
     * @param srcNode the data associated with the edge's source node 
     * @param dstNode the data associated with the edge's destination node
     * @return the data associated with the corresponding edge
     *         (or null, if the edge is not in the graph)
     */
    public EdgeDataType getEdge(NodeDataType srcNode, NodeDataType dstNode);

    /**
     * Returns true if there is an edge from one node to another
     * @param srcNode the data associated with the edge's source node 
     * @param dstNode the data associated with the edge's destination node
     * @return true if there is an edge from srcNode to dstNode
     */
    public boolean adjacent(NodeDataType srcNode, NodeDataType dstNode);
    
    /**
     * Modify the graph to add a new edge. Note: the method will not
     * add an edge from a node to itself
     * @param srcNode the data associated with the edge's source node 
     * @param dstNode the data associated with the edge's destination node
     * @param edge the data associated with the edge
     * @return true if the edge was added to the graph
     */
    public boolean addEdge(NodeDataType srcNode, NodeDataType dstNode, EdgeDataType edge);
    
    /**
     * Modify the graph to remove an edge
     * @param srcNode the data associated with the edge's source node 
     * @param dstNode the data associated with the edge's destination node
     * @param edge the data associated with the edge
     * @return true if the edge was removed from the graph
     */
    public EdgeDataType removeEdge(NodeDataType srcNode, NodeDataType dstNode);

    
    /**
     * @return a set that contains all the nodes in the graph
     */
    public Set<NodeDataType> getNodes();    

    /**
     * Returns true if the graph contains a node with the specified data
     * @param nodeData the data to search for
     */
    public boolean containsNode(NodeDataType nodeData);
    
    /**
     * Computes a set of nodes that are adjacent to the given node
     * @param srcNode the node whose neighbors we want
     * @return all the nodes attached to this node via an edge
     */
    public Set<NodeDataType> neighbors(NodeDataType srcNode);

    /**
     * Modify the graph to add a new node
     * @param nodeData the data to place in the new node
     * @return true if the node was added to the graph, false if the node
     *         was already in the graph
     */
    public boolean addNode(NodeDataType nodeData);

    /**
     * Modify the graph to remove a node that contains the data
     * @param nodeData the data to search for, then remove
     * @return true if the node was removed to the graph
     */
    public boolean removeNode(NodeDataType nodeData);
    
}
