/*
    Time Complexity : O(N)
    Space Complexity : O(1)
    Author : Manjinder Singh
*/

public class a_TrappingRainWater {

    public int trap(int[] height) {
        int left=0;
        int right = height.length-1;
        int leftMax =0, rightMax = 0, ans=0;
        while(left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if(leftMax<rightMax){
                ans+= leftMax - height[left];
                left++;
            }else{
                ans+= rightMax-height[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        a_TrappingRainWater solver = new a_TrappingRainWater();

        int[] height = {0, 2, 0, 3, 1, 0, 1, 3, 2, 1};
        int trappedWater = solver.trap(height);

        System.out.println("Total trapped rain water: " + trappedWater);
    }

}
