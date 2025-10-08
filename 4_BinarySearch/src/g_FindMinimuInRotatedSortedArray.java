/*
    Time Complexity : O(logN)
    Space Complexity : O(1)
    Author : Manjinder Singh
*/

public class g_FindMinimuInRotatedSortedArray {
    public int findMin(int[] nums) {
        int left=0, right=nums.length-1, min = Integer.MAX_VALUE;
        while(left<=right){
            int mid = left + (right-left)/2;
            min = Math.min(min, nums[mid]);
            //Right half is unsorted
            if(nums[right]<nums[mid]){
                left = mid+1;
            }
            //Left half is unsorted
            else{
                right = mid-1;
            }
        }
    return min;
    }

    public static void main(String[] args) {
        g_FindMinimuInRotatedSortedArray solver = new g_FindMinimuInRotatedSortedArray();

        int[] nums1 = {3, 4, 5, 1, 2};   // rotated, min = 1
        int[] nums2 = {4, 5, 6, 7, 0, 1, 2}; // rotated, min = 0
        int[] nums3 = {11, 13, 15, 17};  // not rotated, min = 11
        int[] nums4 = {2, 3, 4, 5, 1};   // rotated, min = 1

        System.out.println("Min of nums1: " + solver.findMin(nums1));
        System.out.println("Min of nums2: " + solver.findMin(nums2));
        System.out.println("Min of nums3: " + solver.findMin(nums3));
        System.out.println("Min of nums4: " + solver.findMin(nums4));
    }
}
