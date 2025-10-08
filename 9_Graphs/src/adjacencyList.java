import java.util.*;

public class adjacencyList {
    public static void validPath(int n, int[][] edges, int source, int destination){
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjList.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adjList.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        System.out.println(adjList);
    }

    public static void main(String[] args) {
        int[][] edges = new int[][] {{0,1},{1,2},{2,0}};
        validPath(3, edges, 0, 2);
    }
}
