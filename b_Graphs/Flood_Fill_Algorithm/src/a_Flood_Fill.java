public class a_Flood_Fill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length==0 || image[0].length==0){
            return image;
        }
        int currentColor = image[sr][sc];
        if(currentColor!=color){
            helper(image, sr, sc, color, currentColor);
        }
        return image;
    }

    private void helper(int[][] image, int i, int j, int color, int currentColor){
        if(i<0 || i>=image.length || j<0 ||  j>=image[0].length || image[i][j]!=currentColor){
            return;
        }
        image[i][j] = color;

        helper(image, i+1, j, color, currentColor);
        helper(image, i-1, j, color, currentColor);
        helper(image, i, j+1, color, currentColor);
        helper(image, i, j-1, color, currentColor);
    }

    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int sr = 1;
        int sc = 1;
        int color = 2;

        a_Flood_Fill solution = new a_Flood_Fill();
        int[][] result = solution.floodFill(image, sr, sc, color);

        System.out.println("Flood filled image:");
        for (int[] row : result) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }

    }
}
