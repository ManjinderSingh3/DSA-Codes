/*
    Time Complexity : O(logN)
    Space Complexity : O(1)
    Author : Manjinder Singh
*/

public class e_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0, right =nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            // Right half of array is sorted
            else if(nums[right]>=nums[mid]){
                if(target>nums[mid] && target<=nums[right]){
                    left = mid+1;
                }else{
                    right=mid-1;
                }

            }
            //Left half is sorted
            else{
                if(target>=nums[left] && target<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }

            }
        }
        return -1;
    }

    public static void main(String[] args) {
        e_SearchInRotatedSortedArray obj = new e_SearchInRotatedSortedArray();

        int[] nums = {4,5,6,7,0,1,2};

        System.out.println("Search 0 → index: " + obj.search(nums, 0)); // expected 4
        System.out.println("Search 3 → index: " + obj.search(nums, 3)); // expected -1
        System.out.println("Search 7 → index: " + obj.search(nums, 7)); // expected 3
    }
}
