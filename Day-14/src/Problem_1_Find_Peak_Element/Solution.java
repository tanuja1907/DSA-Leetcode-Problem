package Problem_1_Find_Peak_Element;

/**
 * This class provides a method to find a peak element in an array.
 * A peak element is an element that is strictly greater than its neighbors.
 * T.C.-O(n) for iterative approach
 * T.C.-O(n log n) binary search approach
 * S.C.-O(1)
 */
public class Solution {

//     iterative approach
//     public int findPeakElement(int[] nums) {
//        int n = nums.length;
//        if (nums.length == 1) return 0;
//        if (nums[0] > nums[1]) return 0;
//        if (nums[n - 1] > nums[n - 2]) return n - 1;
//        for (int i = 1; i < nums.length - 1; i++) {
//            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
//                return i;
//            }
//        }
//        return 0;
//    }

    /**
     * finds peak element by binary search
     *
     * @param nums array of elements
     * @return this method returns the index of peak element.
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        Solution solution = new Solution();
        int index = solution.findPeakElement(arr);
        System.out.println("The peak element is " + arr[index]);
    }
}
