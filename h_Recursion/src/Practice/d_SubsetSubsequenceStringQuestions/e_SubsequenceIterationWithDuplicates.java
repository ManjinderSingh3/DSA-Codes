package Practice.d_SubsetSubsequenceStringQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class e_SubsequenceIterationWithDuplicates {

    public static void subsequence(int[] arr){
        Arrays.sort(arr);
        List<List<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>());
        int start = 0;
        int end =0;
        for(int i=0; i<arr.length;i++){
            start = 0;
            if(i>0 && arr[i]==arr[i-1]){
                // Start will be previous end+1
                start = end+1;
            }
            end = outerList.size()-1;
            int n = outerList.size();
            for(int j=start; j<n;j++){
                List<Integer> innerList = new ArrayList<>(outerList.get(j));
                innerList.add(arr[i]);
                outerList.add(innerList);
            }
        }
        System.out.println(outerList);
    }


    public static void main(String[] args) {
        int[] arr = {1,2,2};
        subsequence(arr);
    }
}
