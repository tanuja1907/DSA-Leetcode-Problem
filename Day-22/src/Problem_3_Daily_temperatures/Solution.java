package Problem_3_Daily_temperatures;

import java.util.Arrays;
import java.util.Stack;

/**
 *  T.C.-O(n)
 *  S.C.-O(n)
 */
class Solution {
    /**
     *
     * @param temperatures    represents the daily temperatures
     * @return                return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIdx = stack.pop();
                result[prevIdx] = i - prevIdx;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        Solution solution = new Solution();
        int[] result = solution.dailyTemperatures(arr);
        System.out.println("Result array: ");
        Arrays.stream(result).forEach(x -> System.out.print(x + " "));
    }
}


