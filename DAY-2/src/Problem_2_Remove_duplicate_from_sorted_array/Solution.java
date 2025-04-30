package Problem_2_Remove_duplicate_from_sorted_array;


public class Solution {
    public int removeDuplicates(int[] nums) {
        int curr=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[curr]){
                curr++;
                nums[curr]=nums[i];
            }

        }
        return curr+1;
    }
    public static void main(String[] args) {
        int[] nums={0,0,1,1,1,2,2,3,3,3,4,5,6};
        Solution solution=new Solution();
        System.out.println(solution.removeDuplicates(nums));

    }
}
