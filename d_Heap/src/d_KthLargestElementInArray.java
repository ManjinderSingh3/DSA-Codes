/*
    Approach 1:
        T.C = o(nlogn)  For sorting
        S.C = o(1)

     Approach 2:
        T.C = o(nlogk)
        S.C = o(k)
 */

import java.util.*;
public class d_KthLargestElementInArray {

    public static int findKthLargest(int[] nums, int k) {
        // Approach 1 - using sorting
        /*
        Arrays.sort(nums);
        return nums[nums.length - k];
        */

        // Approach 2 - using MinHeap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i =0; i<nums.length; i++){
            if(minHeap.size()<k){
                minHeap.add(nums[i]);
            }else{
                if(nums[i]>minHeap.peek()){
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int result = findKthLargest(nums, k);
        System.out.println("The " + k + "th largest element is: " + result);
    }

}
