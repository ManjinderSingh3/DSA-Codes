package ifPathExist;
import java.util.*;

public class AdjacencyList_and_DFS {

    private boolean dfs(Map<Integer, List<Integer>> adjList, int current, int destination, int n, boolean[] vis){
        if(current == destination)
            return true;
        vis[current] = true;
        for(int neighbor: adjList.get(current)){
            if(!vis[neighbor]){
                if(dfs(adjList, neighbor, destination, n, vis))
                    return true;
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination){
        //Step-1 : Create adjacency list
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            if(!adjList.containsKey(u)){
                adjList.put(u, new ArrayList<>());
            }
            adjList.get(u).add(v);

            if(!adjList.containsKey(v)){
                adjList.put(v, new ArrayList<>());
            }
            adjList.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        return dfs (adjList, source, destination, n, vis);
    }

    public static void main(String[] args) {
        AdjacencyList_and_DFS solution = new AdjacencyList_and_DFS();

        int n = 6;
        int[][] edges = {
                {0, 1},
                {0, 2},
                {3, 5},
                {5, 4},
                {4, 3}
        };
        int source = 0;
        int destination = 5;

        boolean result = solution.validPath(n, edges, source, destination);
        System.out.println("Is there a valid path from " + source + " to " + destination + "? " + result);

    }
}
