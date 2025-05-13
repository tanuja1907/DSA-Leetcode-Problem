package Problem_2_Max_consecutive_ones;

/**
 * this programs counts subarray by fliping k times 0 to get all ones of max length
 * it uses sliding window approach when in particular window the zeroes count exceeds than k window shrinks
 * it takes S.C.-O(1)
 * T.C. -O(n)
 */
class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLength = 0;
        int zeroes_count = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroes_count++;
            while (zeroes_count > k) {
                if (nums[left] == 0) zeroes_count--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println("The longest subarray with ones :" + solution.longestOnes(arr, 2));
    }
}
