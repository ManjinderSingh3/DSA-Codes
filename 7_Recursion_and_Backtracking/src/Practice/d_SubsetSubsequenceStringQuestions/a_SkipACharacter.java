package Practice.d_SubsetSubsequenceStringQuestions;

public class a_SkipACharacter {
    // Approach-1 (Without using extra variable to store answer)
    static String skipACharacter(String str){
        if(str.isEmpty()){
            return str;
        }
        char ch = str.charAt(0);
        if(ch=='a'){
            return skipACharacter(str.substring(1));
        }else{
            return ch + skipACharacter(str.substring(1));
        }
    }

    static String skipACharacter2(String processedStr, String unprocessedStr){
        if(unprocessedStr.isEmpty()){
            return processedStr;
        }
        char ch = unprocessedStr.charAt(0);
        if(ch=='a'){
            return skipACharacter2(processedStr,unprocessedStr.substring(1));
        }else{
            return skipACharacter2(processedStr+ch,unprocessedStr.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(skipACharacter("abccdah"));
        System.out.println(skipACharacter2("","abccdah"));
    }
}
