package Practice.d_SubsetSubsequenceStringQuestions;

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

    public static void main(String[] args) {
        subSequence("", "abc");
    }
}
