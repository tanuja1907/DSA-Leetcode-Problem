package Problem_2_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In 3sum problem first we sort the array then take one element and find rest two element with left and right variable
 * T.C.-O(n^2),sorting array-O(n log n) ,iterating each array -O(n)
 * S.C.-O(1)
 */
class Solution {

    /**
     * @param nums 0-index based array
     * @return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        if (n < 3) return result;
        if (n == 3 && nums[0] + nums[1] + nums[2] == 0) {
            result.add(Arrays.asList(nums[0], nums[1], nums[2]));
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == -nums[i]) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < -nums[i]) {
                    left++;
                } else right--;

            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Solution solution = new Solution();
        System.out.println("List of 3Sum -> "+solution.threeSum(nums));
    }
}

