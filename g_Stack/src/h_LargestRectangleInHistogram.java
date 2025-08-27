import java.util.Arrays;
import java.util.Stack;

public class h_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int[] previousLowestValueIndex = new int[heights.length];
        int[] nextLowestValueIndex = new int[heights.length];
        Arrays.fill(previousLowestValueIndex, -1);
        Arrays.fill(nextLowestValueIndex, heights.length);

        Stack<Integer> stack = new Stack<>();

        // Next Smallest
        for(int i=0; i<heights.length;i++){
            while(true){
                if(stack.isEmpty()){
                    stack.push(i);
                    break;
                }
                int index = stack.peek();
                if(heights[i]<heights[index]){
                    nextLowestValueIndex[index]=i;
                    stack.pop();
                }else{
                    stack.push(i);
                    break;
                }
            }
        }
        stack.clear();
        //Previous Smallest
        for(int i=heights.length-1; i>=0; i--){
            while(true){
                if(stack.isEmpty()){
                    stack.push(i);
                    break;
                }
                int index = stack.peek();
                if(heights[i]<heights[index]){
                    previousLowestValueIndex[index]=i;
                    stack.pop();
                }else{
                    stack.push(i);
                    break;
                }
            }
        }

        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            maxArea = Math.max(maxArea, heights[i]* (nextLowestValueIndex[i]-previousLowestValueIndex[i]-1))
            ;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        h_LargestRectangleInHistogram obj = new h_LargestRectangleInHistogram();

        // Sample input: histogram heights
        int[] heights = {2, 1, 5, 6, 2, 3};

        int result = obj.largestRectangleArea(heights);
        System.out.println("Largest rectangle area in histogram: " + result);
    }
}
