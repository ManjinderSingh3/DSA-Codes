package ifPathExist;

import java.util.Arrays;

public class AdjacencyMatrix_And_DFS {
    private boolean dfs(boolean[][] adjMatrix, int n, int current, int destination, boolean[] vis){
        if(current == destination)
            return true;
        vis[current] = true;
        for(int i=0; i<n; i++){
            if(adjMatrix[current][i] == true && !vis[i]){
                if(dfs(adjMatrix, n, i, destination, vis))
                    return true;
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[][] adjMatrix = new boolean[n][n];
        for(boolean[] row : adjMatrix){
            Arrays.fill(row, false);
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adjMatrix[u][v] = true;
            adjMatrix[v][u] = true;
        }
        boolean[] vis = new boolean[n];
        return dfs(adjMatrix, n, source, destination, vis);

    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = new int[][]{{0,1}, {1,2}, {2,0}};
        int source = 0, destination = 2;

        AdjacencyMatrix_And_DFS graph = new AdjacencyMatrix_And_DFS();
        boolean result = graph.validPath(n, edges, source, destination);
        System.out.println("Is there a valid path from " + source + " to " + destination + "? " + result);

    }
}
