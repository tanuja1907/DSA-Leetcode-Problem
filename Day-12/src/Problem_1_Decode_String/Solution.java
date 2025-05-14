package Problem_1_Decode_String;

import java.util.Stack;

/**
 * Here are two stacks used which store digistack for all the digits to repeat string k times
 * StringStack for all the strings inside []
 * while iterationg ] doesnot occur keep pushing in stack and then pop from stack previous string in "curr" string,
 * and add n times in "currString"
 * T.C.-O(n*k)
 * S.C.-O(n)
 */
class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> StringStack = new Stack<>();
        Stack<Integer> digitStack = new Stack<>();
        int n = 0;
        StringBuilder currString = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {// if the num has more than one digit
                n = n * 10 + (ch - '0');
            } else if (ch == '[') {
                digitStack.push(n);
                StringStack.push(currString);
                n = 0;
                currString = new StringBuilder();
            } else if (ch == ']') {
                int k = digitStack.pop();
                StringBuilder curr = StringStack.pop();
                for (int i = 0; i < k; i++) { // repeat k times in the curr string
                    curr.append(currString);
                }
                currString = curr;
            } else currString.append(ch);
        }
        return currString.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeString("3[a]2[bc]"));
    }
}