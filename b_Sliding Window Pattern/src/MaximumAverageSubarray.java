public class MaximumAverageSubarray {
    public static double findMaxAverage(int[] nums, int k){
        int sum=0;
        for(int i=0; i<k; i++){
            sum+=nums[i];
        }
        int maxSum = sum;
        int startIndex = 0 ;
        int endIndex = k;
        while(endIndex<nums.length){
            sum-=nums[startIndex];
            startIndex++;

            sum+=nums[endIndex];
            endIndex++;

            maxSum = Math.max(maxSum, sum);
        }
        return(double)maxSum/k;
    }

    public static void main(String[] args) {
        int[] arr = {1,12,-5,-6,50,3};
        System.out.println(findMaxAverage(arr,4));
    }
}

/*

1) Pattern Name : Sliding Window

2) Time Complexity :
    - The first loop runs k times to get the initial sum.
    - The while loop runs n - k times to slide the window across the rest of the array
    - So, the total time complexity is: 𝑂(𝑘)+𝑂(𝑛−𝑘)=𝑂(𝑛)

3) Space Complexity :
    - We're only using a few primitive variables: sum, maxSum, startIndex, endIndex, and no extra data structures.
    - So, Space Complexity: O(1)

*/

