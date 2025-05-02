package Problem_3_Minimum_Operations;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> set=new HashSet<>();
        for(int num:nums){
            if(num>k){
                set.add(num);
            }else if(num<k)return -1;
        }
        return set.size();
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] arr={5,2,5,4,5};
        System.out.println(solution.minOperations(arr,2));
    }
}