package Problem_3_Longest_Repeating_character_Repeat;

import java.util.HashMap;

/**
 * this programs calculates operation to perform on string to get longest repeating character
 * uses data structure hashmap to store the frequency of character
 * if the window size is greater than k shrink the window
 * it uses T.C.-O(n)
 * S.C.-O(1) as  scope is bounded
 */
class Solution {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0;
        int left = 0;
        int maxLength = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(ch));
            if ((right - left + 1) - maxFreq > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);

        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "ABAB";
        System.out.println("After performing operations we get string of length is " + solution.characterReplacement(str, 2));
    }
}
