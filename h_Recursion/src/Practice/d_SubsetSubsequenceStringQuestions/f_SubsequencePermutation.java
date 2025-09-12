package Practice.d_SubsetSubsequenceStringQuestions;

import java.util.ArrayList;
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

    public static void main(String[] args) {
        permutation("","abc");
        ArrayList<String> res = permutationsInList("", "abc");
        System.out.println(res);
    }
}
