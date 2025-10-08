import java.util.Arrays;
import java.util.Stack;

public class i_MaximalRectangle {

    public int largestRectangleArea(int[] heights){
        int[] previousSmallestHeightIndex = new int[heights.length];
        int[] nextSmallestHeightIndex = new int[heights.length];
        Arrays.fill(previousSmallestHeightIndex, -1);
        Arrays.fill(nextSmallestHeightIndex, heights.length);
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        // Find index of next smaller bar
        for(int i=0; i<heights.length; i++){
            while(true){
                if(stack.isEmpty()){
                    stack.push(i);
                    break;
                }
                int index = stack.peek();
                if(heights[i]<heights[index]){
                    nextSmallestHeightIndex[index]=i;
                    stack.pop();
                }else{
                    stack.push(i);
                    break;
                }
            }
        }

        //Find index of previous smaller bar
        for(int i=heights.length-1;i>=0; i--){
            while(true){
                if(stack.isEmpty()){
                    stack.push(i);
                    break;
                }
                int index = stack.peek();
                if(heights[i]<heights[index]){
                    previousSmallestHeightIndex[index]=i;
                    stack.pop();
                }else{
                    stack.push(i);
                    break;
                }
            }
        }
        for(int i=0; i<heights.length;i++){
            maxArea = Math.max(maxArea, heights[i]*(nextSmallestHeightIndex[i]-(previousSmallestHeightIndex[i])-1));
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] intMatrix = new int[rows][cols];
        int maxArea = 0;

        //First Row
        for(int col=0;col<cols;col++){
            intMatrix[0][col] = matrix[0][col]=='1'?1:0;
        }
        maxArea = Math.max(maxArea, largestRectangleArea(intMatrix[0])); //Pass first row as input

        //Remaining Rows
        for(int row=1; row<rows;row++){
            for(int col=0; col<cols; col++){
                intMatrix[row][col] = matrix[row][col]=='1' ? intMatrix[row-1][col]+1:0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(intMatrix[row]));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        i_MaximalRectangle solver = new i_MaximalRectangle();

        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        int maxRectangle = solver.maximalRectangle(matrix);
        System.out.println("The maximal rectangle area is: " + maxRectangle);
    }

}
