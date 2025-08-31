import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class f_NextGreaterElement_I {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[nums1.length];

        for(int i=0; i<nums2.length;i++){
            while(true){
                if(stack.isEmpty()){
                    stack.push(i);
                    break;
                }
                int prevIndex = stack.peek();
                if(nums2[i]>nums2[prevIndex]){
                    map.put(nums2[prevIndex], nums2[i]);
                    stack.pop();
                }else{
                    stack.push(i);
                    break;
                }
            }
        }


        for (int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])){
                result[i]= map.get(nums1[i]);
            }else{
                result[i]=-1;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        f_NextGreaterElement_I solution = new f_NextGreaterElement_I();

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] result = solution.nextGreaterElement(nums1, nums2);

        System.out.println("Next Greater Elements: " + Arrays.toString(result));
    }
}