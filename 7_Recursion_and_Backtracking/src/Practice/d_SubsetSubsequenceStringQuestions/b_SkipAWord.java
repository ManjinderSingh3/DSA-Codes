package Practice.d_SubsetSubsequenceStringQuestions;

public class b_SkipAWord {
    static String skipAWord(String str){
        if(str.isEmpty()){
            return str;
        }
        char ch = str.charAt(0);
        if(str.startsWith("apple")){
            return skipAWord(str.substring(5));
        }else{
            return ch + skipAWord(str.substring(1));
        }
    }

    // Part 2 -  Only Skip the 'app' when it's not equal to 'apple'

    public static void main(String[] args) {
        System.out.println(skipAWord("bdfapplebc"));

    }
}
