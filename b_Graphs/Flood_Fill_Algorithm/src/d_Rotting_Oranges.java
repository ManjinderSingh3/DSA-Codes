import java.util.Arrays;

public class d_Rotting_Oranges {

    private void dfs(int[][] grid, int[][] timeGrid, int i, int j, int currentTime){
        //Boundary conditions
        if(i< 0 || i>=grid.length || j<0 || j>= grid[0].length || grid[i][j] == 0 || currentTime>= timeGrid[i][j]){
            return ;
        }
        timeGrid[i][j] = currentTime;
        dfs(grid, timeGrid, i+1, j, currentTime+1);
        dfs(grid, timeGrid, i-1, j, currentTime+1);
        dfs(grid, timeGrid, i, j+1, currentTime+1);
        dfs(grid, timeGrid, i, j-1, currentTime+1);

    }

    public int orangesRotting(int[][] grid){
        if(grid == null || grid.length==0 || grid[0].length==0 ){
            return -1;
        }
        int[][] timeGrid = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            Arrays.fill(timeGrid[i], Integer.MAX_VALUE);
        }

        for(int i =0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    dfs(grid, timeGrid, i, j , 0);
                }
            }
        }

        int timeRequired=0;
        for(int i= 0;i<grid.length;i++){
            for(int j =0; j<grid[0].length;j++){
                if(grid[i][j]==1){
                    if(timeGrid[i][j] == Integer.MAX_VALUE){
                        return -1;
                    }
                    timeRequired = Math.max(timeRequired, timeGrid[i][j]);
                }
            }
        }
        return timeRequired;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        d_Rotting_Oranges solution = new d_Rotting_Oranges();
        int result = solution.orangesRotting(grid);
        System.out.println("Minimum time required to rot all oranges: " + result);
    }
}
