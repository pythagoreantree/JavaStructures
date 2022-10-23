package util.collections.implementations.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph<T> {

    List<GraphNode<T>> graphNodes;

    int size;

    public List<GraphNode<T>> getGraphNodes() {
        return graphNodes;
    }

    public void addNode(GraphNode<T> graphNode) {
        if (graphNodes == null)
            graphNodes = new ArrayList<>();
        //check how value equality
        graphNodes.add(graphNode);
        size++;
    }

    public void addNodes(List<GraphNode<T>> nodes) {
        if (nodes == null || nodes.isEmpty())
            return;
        if (graphNodes == null)
            graphNodes = new ArrayList<>();
        //check how value equality
        graphNodes.addAll(nodes);
        size += nodes.size();
    }

    public GraphNode<T> getNodeByValue(T value) {
        if (graphNodes == null) {
            throw new RuntimeException("No nodes in the graph!");
        }

        for (GraphNode<T> graphNode: graphNodes) {
            if (graphNode.getValue().equals(value)) {
                return graphNode;
            }
        }
        throw new RuntimeException("No node with value " + value + " in the graph!");
    }
}
