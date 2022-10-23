package util.collections.utils;

import util.collections.implementations.graph.Graph;
import util.collections.implementations.graph.GraphNode;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphUtils {

    /*
     * DFS for a fully connected Graph.
     * */
    public static void dfs(GraphNode<Integer> node, Set<Integer> visited) {
        Integer value = node.getValue();
        if (visited.contains(value)) return;
        visited.add(value);

        System.out.print(node.getValue() + " ");
        List<GraphNode<Integer>> neighbors = node.getNeighbors();

        for (GraphNode neighbor: neighbors) {
            dfs(neighbor, visited);
        }
    }

    /*
     * DFS version of not fully connected Graph.
     * */
    public static void generalDFS(Graph<Integer> graph) {
        Set<Integer> visited = new HashSet<>();
        for (GraphNode node: graph.getGraphNodes()) {
            Integer nodeValue = (Integer) node.getValue();
            if (!visited.contains(nodeValue)) {
                dfs(node, visited);
            }
        }
    }
}
