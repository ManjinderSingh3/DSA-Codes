public class b_Number_Of_Islands {
    public int numIslands(char[][] grid) {
        if(grid== null || grid.length==0 || grid[0].length==0){
            return 0;
        }

        int numOfIslands=0;
        for(int i=0; i<grid.length;i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j]=='1'){
                    countIslands(grid, i, j);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    private void countIslands(char[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]!='1'){
            return;
        }
        grid[i][j] = '0';

        countIslands(grid, i+1, j);
        countIslands(grid, i-1, j);
        countIslands(grid, i, j+1);
        countIslands(grid, i, j-1);
    }


    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        b_Number_Of_Islands solution = new b_Number_Of_Islands();
        int numIslands = solution.numIslands(grid);
        System.out.println("Number of Islands: " + numIslands);
    }


}
