import java.sql.SQLOutput;
import java.util.*;
public class FindAllAnagrams {
    public static  List<Integer> findAnagrams(String s, String p){
        List<Integer> result = new ArrayList<>();
        if(s.length()<p.length()){
            return result;
        }

        int[] sFrequencyArray = new int[26];
        int[] pFrequencyArray = new int[26];

        for(char pChar: p.toCharArray()){
            pFrequencyArray[pChar - 'a']++;
        }

        for(int i=0;i<s.length();i++){
            sFrequencyArray[s.charAt(i)-'a']++;

            if(i>=p.length()){
                sFrequencyArray[s.charAt(i -p.length())-'a']--;
            }

            if(Arrays.equals(pFrequencyArray, sFrequencyArray)){
                result.add(i-p.length()+1);
            }
        }

        return result;
    }
    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s,p));
    }
}

/*

Pattern : Sliding Window
Time Complexity: O(n)
Space Complexity : O(1)

 */