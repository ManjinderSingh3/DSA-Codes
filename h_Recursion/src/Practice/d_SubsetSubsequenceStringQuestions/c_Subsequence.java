package Practice.d_SubsetSubsequenceStringQuestions;

import java.util.ArrayList;

public class c_Subsequence {
    public static void subSequence(String processedString, String unprocessedString){
        if(unprocessedString.isEmpty()){
            System.out.println(processedString);
            return;
        }
        char ch = unprocessedString.charAt(0);
        subSequence(processedString+ch, unprocessedString.substring(1));
        subSequence(processedString,unprocessedString.substring(1));

    }

    // Return ArrayList by creating a new list inside the function body
    public static ArrayList<String> subSequenceInList(String processed, String unprocessed){
        if(unprocessed.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        ArrayList<String> left = subSequenceInList(processed+ch, unprocessed.substring(1));
        ArrayList<String> right = subSequenceInList(processed, unprocessed.substring(1));
        left.addAll(right);
        return left;
    }


    // Returning Arraylist by passing in each function call. (One object and multiple reference variables)
    static ArrayList<String> alist = new ArrayList<String>();
    public static ArrayList<String> subSequenceInListII(String processed, String unprocessed, ArrayList<String> list){
        if(unprocessed.isEmpty()){
            list.add(processed);
            return list;
        }

        subSequenceInListII(processed+unprocessed.charAt(0), unprocessed.substring(1), alist);
        subSequenceInListII(processed,unprocessed.substring(1), alist);
        return alist;
    }

    public static void main(String[] args) {
        subSequence("", "abc");
        System.out.println(subSequenceInList("","abc"));
        System.out.println(subSequenceInListII("","abc", alist));
    }
}
