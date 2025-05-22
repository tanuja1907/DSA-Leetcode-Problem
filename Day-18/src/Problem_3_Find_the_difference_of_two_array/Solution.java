package Problem_3_Find_the_difference_of_two_array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * here we have two set where all distinct elements stored of nums1 and nums2
 * then checking which element present in set1 not in set 2 add in result[0] and ,
 * same check for set2 and add in result[1]
 * T.C.-O(n+m)
 * S.C.-O(n+m)
 */
class Solution {

    /**
     * @param nums1 an 0-indexed array
     * @param nums2 an 0-indexed array
     * @return return a list answer of size 2 where,answer[0] has element of nums1 not present in nums2 and in answer[1] vice versa
     */
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }

        for (int num : nums2) {
            set2.add(num);
        }
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());

        for (int i : set1) {
            if (!set2.contains(i)) {
                result.getFirst().add(i);
            }
        }
        for (int i : set2) {
            if (!set1.contains(i)) {
                result.get(1).add(i);
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        Solution solution = new Solution();
        System.out.println("Difference in both array -> "+solution.findDifference(nums1, nums2));

    }
}