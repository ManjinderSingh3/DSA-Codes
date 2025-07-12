package main.java;

public class a_Number_Of_Provinces {
    private void dfs(int[][] isConnected, int current, boolean[] vis, int n){
        vis[current] = true;
        for(int i= 0; i<n; i++){
            if(isConnected[current][i] == 1 && !vis[i])
                dfs(isConnected, i, vis, n);
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        int numberOfProvinces = 0;

        for(int i=0; i<n; i++){
            if(!vis[i]){
                numberOfProvinces++;
                dfs(isConnected, i, vis, n);
            }
        }
        return numberOfProvinces;
    }

    public static void main(String[] args) {
        a_Number_Of_Provinces obj = new a_Number_Of_Provinces();

        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

        int result = obj.findCircleNum(isConnected);
        System.out.println("Number of Provinces: " + result); // Expected output:
    }
}
