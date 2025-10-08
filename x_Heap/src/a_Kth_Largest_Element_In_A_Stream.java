import java.util.*;
public class a_Kth_Largest_Element_In_A_Stream {
    int k;
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

    public a_Kth_Largest_Element_In_A_Stream(int k, int[] nums) {
        this.k = k;
        for(int num : nums){
            minHeap.add(num);
            if(minHeap.size()>k)
                minHeap.poll();
        }
    }

    public int add(int val) {
        if(minHeap.size()<k){
            minHeap.add(val);
            return minHeap.peek();
        }

        minHeap.add(val);
        minHeap.poll();
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int k = 3;
        int[] nums = {4, 5, 8, 2};

        a_Kth_Largest_Element_In_A_Stream obj = new a_Kth_Largest_Element_In_A_Stream(k, nums);

        System.out.println(obj.add(3));  // Output: 4
        System.out.println(obj.add(5));  // Output: 5
        System.out.println(obj.add(10)); // Output: 5
        System.out.println(obj.add(9));  // Output: 8
        System.out.println(obj.add(4));  // Output: 8

    }
}
