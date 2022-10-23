package util.collections.utils;

import org.junit.jupiter.api.Test;
import util.collections.implementations.graph.Graph;
import util.collections.implementations.graph.GraphNode;

import java.util.List;

import static java.util.List.of;

class GraphUtilsTest {

    public static Graph<Integer> graph = new Graph<>();

    static {
        //Think how to make it easier
        //may be add and check if existed?!
        GraphNode<Integer> node1 = new GraphNode<>(1);
        GraphNode<Integer> node2 = new GraphNode<>(2);
        GraphNode<Integer> node3 = new GraphNode<>(3);
        GraphNode<Integer> node4 = new GraphNode<>(4);
        GraphNode<Integer> node5 = new GraphNode<>(5);
        GraphNode<Integer> node6 = new GraphNode<>(6);
        GraphNode<Integer> node7 = new GraphNode<>(7);

//        graph.addNodes(List.of(node1, node2, node3, node4, node5, node6, node7));
//        graph.getNodeByValue(1).addNeighbors(List.of(node2));

        graph.addNode(node1.addNeighbor(node2));
        graph.addNode(node2.addNeighbors(List.of(node1, node3, node4)));
        graph.addNode(node3.addNeighbors(List.of(node1, node2, node4, node5, node6)));
        graph.addNode(node4.addNeighbors(List.of(node2, node3, node6)));
        graph.addNode(node5.addNeighbor(node3));
        graph.addNode(node6.addNeighbors(List.of(node3, node4)));
        graph.addNode(node7);
    }

    @Test
    void generalDFS() {
        GraphUtils.generalDFS(graph);
    }
}