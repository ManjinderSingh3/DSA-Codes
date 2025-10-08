public class c_Max_Area_Of_Island {

    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }
        int maxArea =0;
        for(int i=0; i<grid.length; i++){
            for(int j=0 ; j<grid[0].length; j++){
                if(grid[i][j]==1){
                    int area = areaOfIsland(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int areaOfIsland(int[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!=1){
            return 0;
        }
        grid[i][j] = 0 ;// Mark each grid as visited
        int area = 1 ;

        area += areaOfIsland(grid, i+1, j);
        area += areaOfIsland(grid, i-1, j);
        area += areaOfIsland(grid, i, j+1);
        area += areaOfIsland(grid, i, j-1);

        return area;
    }

    public static void main(String[] args) {
        c_Max_Area_Of_Island solution = new c_Max_Area_Of_Island();

        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 1, 0},
                {1, 1, 0, 0, 0, 0, 0}
        };

        int maxArea = solution.maxAreaOfIsland(grid);
        System.out.println("Maximum area of island: " + maxArea);
    }
}
