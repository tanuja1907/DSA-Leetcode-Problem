package Problem_1_First_And_Last_Position;

import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start=-1;
        int last=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                if(start==-1){
                    start=i;
                }
                last=i;
            }
        }
        return new int[]{start,last};
    }

    public static void main(String[] args) {
        int[] arr={5,7,7,8,8,10};
        Solution solution=new Solution();
        int[] result=solution.searchRange(arr,8);
        System.out.println(Arrays.toString(result));
    }
}
