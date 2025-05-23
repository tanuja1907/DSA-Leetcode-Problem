package Problem_3_Max_Consecutive_Ones;

/**
 * T.C.-O(n)
 * S.C.-O(n)
 */
class Solution {
    /**
     *
     * @param nums  0-index array contains 0 & 1
     * @return     maximum count of subarray contains 1
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOnes = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 1) count++;
            else {
                maxOnes = Math.max(maxOnes, count);
                count = 0;
            }
        }
        maxOnes = Math.max(maxOnes, count);
        return maxOnes;
    }

    public static void main(String[] args) {
        int[] nums={1,1,0,1,1,1};
        Solution solution=new Solution();
        System.out.println("Maximum number of Ones are -> "+solution.findMaxConsecutiveOnes(nums));
    }
}