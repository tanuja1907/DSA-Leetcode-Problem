package Problem_2_Longest_Substring_Without_repeating_character;

import java.sql.SQLOutput;
import java.util.HashSet;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int len=s.length();
        HashSet<Character> set=new HashSet<>();
        int maxLen=1;
        int left=0;
        if(len==0)return 0;
        if(len==1)return 1;
        for(int right=0;right<len;right++){
            char ch=s.charAt(right);
            while(set.contains(ch)){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            maxLen=Math.max(maxLen,right-left+1);

        }
        return maxLen;
    }
    public static void main(String[] args) {
        LongestSubstring longestSubstring=new LongestSubstring();
        String s="leetcode";
        int result=longestSubstring.lengthOfLongestSubstring(s);
        System.out.println(result);
    }
}
