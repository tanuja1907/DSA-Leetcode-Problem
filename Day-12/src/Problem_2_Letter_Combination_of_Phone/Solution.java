package Problem_2_Letter_Combination_of_Phone;

import java.util.ArrayList;
import java.util.List;

/**
 * keypad is string array which contains all the string of alphabet combination
 * calculateCombinations calculates all combinations recursively
 * T.C.-O(n*4^n)
 * S.C.-O(n*4^n)
 */
class Solution {
    String[] keypad = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        List<String> result = new ArrayList<>();
        calculateCombinations(result, "", 0, digits);
        return result;
    }

    void calculateCombinations(List<String> result, String curr, int idx, String digits) {
        if (idx == digits.length()) {
            result.add(curr);
            return;
        }
        char ch = digits.charAt(idx);
        String mappings = keypad[ch - '2'];
        for (int i = 0; i < mappings.length(); i++) {
            calculateCombinations(result, curr + mappings.charAt(i), idx + 1, digits);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.letterCombinations("23");
        System.out.println("Combinations are-> " + result);
    }
}