package Problem_3_Find_Kth_Largest_Element;

import java.util.Arrays;

//T.C.-O(n log n)
//S.C.-O(1)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        return nums[n - k];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(solution.findKthLargest(arr, 2));
    }
}
