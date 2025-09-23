package Practice.d_SubsetSubsequenceStringQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class f_SubsequencePermutation {

    public static void permutation(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            System.out.println(processed);
            return;
        }
        for(int i=0; i<=processed.length();i++){
            String first = processed.substring(0,i);
            String second = processed.substring(i, processed.length());
            permutation(first+unprocessed.charAt(0)+second, unprocessed.substring(1));
        }
    }

    public static ArrayList<String> permutationsInList(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        ArrayList<String> result = new ArrayList<>();
        for(int i=0;i<=processed.length();i++){
            String first = processed.substring(0,i);
            String second = processed.substring(i,processed.length());
            result.addAll(permutationsInList(first+unprocessed.charAt(0)+second, unprocessed.substring(1)));
        }
        return result;
    }

    public static int permutationCount(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            return 1;
        }
        int count = 0;
        for(int i=0;i<=processed.length();i++){
            String first = processed.substring(0,i);
            String second = processed.substring(i, processed.length());
            count = count + permutationCount(first+unprocessed.charAt(0)+second, unprocessed.substring(1));
        }
        return count;
    }

    public static List<List<Integer>> helper(List<Integer> processed, int[] unprocessed){
        // Base condition
        if(unprocessed.length==0){
            List<List<Integer>> list = new ArrayList<>();
            list.add(new ArrayList<>(processed));
            return list;
        }

        List<List<Integer>> result = new ArrayList<>();
        int firstElement = unprocessed[0];
        int[] remainingElements = Arrays.copyOfRange(unprocessed, 1, unprocessed.length);

        for(int i=0; i<processed.size()+1; i++){
            List<Integer> newProcessed = new ArrayList<>(processed);
            newProcessed.add(i, firstElement);
            result.addAll(helper(newProcessed,remainingElements));
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3};
        /*
        permutation("","abc");
        ArrayList<String> res = permutationsInList("", "abc");
        System.out.println(res);
        System.out.println("Number of permutations : " + res.size());
        System.out.println("Count:"+ permutationCount("","abcd"));
         */
        System.out.println(helper(new ArrayList<>(), nums));
    }
}
