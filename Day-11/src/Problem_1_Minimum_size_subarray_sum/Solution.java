package Problem_1_Minimum_size_subarray_sum;

/**
 *this is sliding window problem to find minimum size of subarray sum greater or equal to target
 * it takes T.C.-O(n)
 * S.C.-O(1)
 */
public class Solution {
    public int minSubArrayLen(int target, int[] nums) {

//       brute force -O(n^2)
//        int minLength=Integer.MAX_VALUE;
//        int left=0;
//        for(int i=0;i<nums.length-1;i++){
//            int sum=0;
//            for(int j=i;j<nums.length;j++){
//                sum+=nums[j];
//                if(sum>=target){
//                    minLength=Math.min(minLength,j-i+1);
//                    break;
//                }
//            }
//        }
//        return minLength==Integer.MAX_VALUE?0:minLength;

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        int n = nums.length;
        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 3, 1, 2, 4, 3};
        System.out.println(solution.minSubArrayLen(7, arr));
    }
}
