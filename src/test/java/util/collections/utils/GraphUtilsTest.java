package util.collections.utils;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.Test;
import util.collections.implementations.graph.Graph;
import util.collections.implementations.graph.GraphNode;

import static java.util.List.of;

class GraphUtilsTest {

    public static Graph<Integer> graph = new Graph<>();

    static {
        //Think how to make it easier
        GraphNode<Integer> node1 = new GraphNode<>(1);
        GraphNode<Integer> node2 = new GraphNode<>(2);
        GraphNode<Integer> node3 = new GraphNode<>(3);
        GraphNode<Integer> node4 = new GraphNode<>(4);
        GraphNode<Integer> node5 = new GraphNode<>(5);
        GraphNode<Integer> node6 = new GraphNode<>(6);
        GraphNode<Integer> node7 = new GraphNode<>(7);

        graph.addNodes(List.of(node1, node2, node3, node4, node5, node6, node7));

        graph.getNodeByValue(1).addNeighbors(List.of(node2));
        graph.getNodeByValue(2).addNeighbors(List.of(node1, node3, node4));

        graph.getNodeByValue(3).addNeighbors(
                List.of(node1, node2, node4, node5, node6));

        graph.getNodeByValue(4).addNeighbors(
                List.of(node2, node3, node6));

        graph.getNodeByValue(5).addNeighbor(node3);

        graph.getNodeByValue(6).addNeighbors(List.of(node3, node4));

    }

    @Test
    void generalDFS() {
        GraphUtils.generalDFS(graph);
    }
}