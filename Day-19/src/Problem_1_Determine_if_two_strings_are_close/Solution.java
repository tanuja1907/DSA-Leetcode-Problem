package Problem_1_Determine_if_two_strings_are_close;

import java.util.Arrays;

/**
 * T.C.-O(n + 26 log 26)
 * S.C.-O(1)
 */
class Solution {
    /**
     * Two strings are considered close if you can attain one from the other
     * @param word1   string1
     * @param word2   string2
     * @return        true if word1 and word2 are close, and false otherwise.
     * Storing frequency of characters of both string in freq1 and freq2 ,
     * then comparing each frequency if char present on one string and not in other it returns false
     */
    public boolean closeStrings(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        if (m != n) return false;
        for (int i = 0; i < m; i++) {
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);

            int idx1 = ch1 - 'a';
            int idx2 = ch2 - 'a';

            freq1[idx1]++;
            freq2[idx2]++;
        }
        for (int i = 0; i < 26; i++) {
            if (freq1[i] != 0 && freq2[i] == 0 || freq1[i] == 0 && freq2[i] != 0) return false;

        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(freq1, freq2);

    }

    public static void main(String[] args) {
        String word1 = "cabbba";
        String word2 = "abbccc";
        Solution solution = new Solution();
        System.out.println(solution.closeStrings(word1, word2));
    }
}