package util.collections.implementations.graph;

import java.util.ArrayList;
import java.util.List;

public class GraphNode<T> {

    T value;

    List<GraphNode<T>> neighbors = new ArrayList<>();

    public GraphNode() {
    }

    public GraphNode(T value) {
        this.value = value;
    }

    public GraphNode(T value, List<GraphNode<T>> neighbors) {
        this.value = value;
        this.neighbors = neighbors; //may be new ArrayyList?
    }

    public T getValue() {
        return value;
    }

    public List<GraphNode<T>> getNeighbors() {
        return neighbors != null? neighbors: new ArrayList<>();
    }

    public void addNeighbor(GraphNode<T> node) {
        //check for equality
        getNeighbors().add(node);
    }

    public void addNeighbors(List<GraphNode<T>> nodes) {
        //check for equality
        getNeighbors().addAll(nodes);
    }
}
