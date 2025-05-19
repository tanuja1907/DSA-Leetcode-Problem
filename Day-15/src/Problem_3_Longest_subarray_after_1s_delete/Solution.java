package Problem_3_Longest_subarray_after_1s_delete;

/**
 * this is classic sliding window approach where tracking zeroes count and window grows and shrink accordingly
 * T.C.-O(n)
 * S.C.-O(1)
 */
class Solution {
    /**
     *
     * sliding window approach is used and every time zero occurs {no_of_zeroes} tracking the record ,
     * Max zero count could be any window size is one and if it exceeds than it start increases and window size shrinks
     * @param nums array consist of zeroes and ones
     * @return longest subarray after changing one zero with one
     */
    public int longestSubarray(int[] nums) {
        int no_of_zeroes = 0;
        int maxOnes = 0;
        int start = 0;
        for (int end = 0; end < nums.length; end++) {
            if (nums[end] == 0) no_of_zeroes++;
            while (no_of_zeroes > 1) {
                if (nums[start] == 0) {
                    no_of_zeroes--;
                }
                start++;
            }
            maxOnes = Math.max(maxOnes, end - start);
        }
        return maxOnes;
    }

    public static void main(String[] args) {
        int[] arr={0,1,1,1,0,1,1,0,1};
        Solution solution=new Solution();
        System.out.println(solution.longestSubarray(arr));
    }
}