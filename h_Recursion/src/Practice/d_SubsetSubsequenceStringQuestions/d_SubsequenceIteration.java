package Practice.d_SubsetSubsequenceStringQuestions;

import java.util.ArrayList;
import java.util.List;

public class d_SubsequenceIteration {

    public static void subSequenceIterativeSolution(int[] nums){
        List<List> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>());
        for(int num : nums){
            int size = outerList.size();
            for(int i=0; i<size; i++){
                ArrayList<Integer> innerList = new ArrayList<>(outerList.get(i));
                innerList.add(num);
                outerList.add(innerList);
            }
        }
        System.out.println(outerList);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        d_SubsequenceIteration.subSequenceIterativeSolution(nums);
    }
}
