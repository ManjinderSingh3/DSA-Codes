package ifPathExist;

import java.util.*;

public class AdjacencyList_and_BFS {
    public boolean validPath(int n, int[][] edges, int source, int destination){
        // Step-1 : Create Adjacency List
        Map<Integer, List<Integer>> adjList =new HashMap<>();
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            if(!adjList.containsKey(u))
                adjList.put(u, new ArrayList<>());
            adjList.get(u).add(v);

            if(!adjList.containsKey(v))
                adjList.put(v, new ArrayList<>());
            adjList.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while(!queue.isEmpty()){
            int current = queue.remove();
            vis[current] = true;
            if(current == destination)
                return true;
            for(int neighbor : adjList.get(current)){
                if(!vis[neighbor]){
                    queue.add(neighbor);
                    vis[neighbor] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AdjacencyList_and_BFS solution = new AdjacencyList_and_BFS();

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
