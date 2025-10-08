package ifPathExist;

import java.util.*;
import java.util.LinkedList;

public class AdjacencyMatrix_And_BFS {

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[][] adjMatrix = new boolean[n][n];
        for(boolean[] row: adjMatrix){
            Arrays.fill(row, false);
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjMatrix[u][v] = true;
            adjMatrix[v][u] = true;
        }
        boolean[] vis = new boolean[n];
        for(int i =0 ; i<n;i++){
            vis[i] = false;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source); // Add first node/vertices

        while(!queue.isEmpty()){
            int current = queue.remove();
            if(current == destination)
                return true;
            for(int i=0; i<n; i++){
                if(adjMatrix[current][i] == true && !vis[i]){
                    queue.add(i);
                    vis[i] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = new int[][]{{0,1}, {1,2}, {2,0}};
        int source = 0, destination = 2;

        AdjacencyMatrix_And_BFS graph = new AdjacencyMatrix_And_BFS();
        boolean result = graph.validPath(n, edges, source, destination);
        System.out.println("Is there a valid path from " + source + " to " + destination + "? " + result);

    }
}
