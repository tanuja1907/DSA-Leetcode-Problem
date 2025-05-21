package Package_1_House_robbery;

import java.util.Arrays;

/**
 * This problem has used Dp for memoization (Top-down approach)
 * getting maximum amount after robbing and without getting noticed
 * T.C.-O(n)
 * S.C.-O(n)
 */
class Solution {
    /**
     *
     * solve() has parameter nums(money in different house) , index, n(length of nums)
     * steal when choosing that house and skip when not robbing
     * return max between steal , skip
     * to avoid overlapping problem dp is used
     */
    private final int[] dp = new int[100 + 1];

    public int rob(int[] nums) {
        int n = nums.length;
        Arrays.fill(dp, -1);
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        return solve(nums, 0, n);
    }

    int solve(int[] nums, int idx, int n) {
        if (idx >= n) return 0;
        if (dp[idx] != -1) {
            return dp[idx];
        }
        int steal = nums[idx] + solve(nums, idx + 2, n);
        int skip = solve(nums, idx + 1, n);
        return dp[idx] = Math.max(steal, skip);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 7, 9, 3, 1};
        System.out.println(solution.rob(arr)+" , is the maximum amount robber can rob at one tine without getting caught");
    }
}

