package Problem_3_permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        permutations(nums,new ArrayList<>(),result);
        return result;
    }

    void permutations(int[] nums,List<Integer> temp,List<List<Integer>> result){
        if(temp.size()==nums.length){
            result.add(new ArrayList<>(temp));
            return ;
        }
        for (int num : nums) {
            if (temp.contains(num)) continue;
            temp.add(num);
            permutations(nums, temp, result);
            temp.removeLast();
        }
    }
    public static void main(String[] args) {
        Solution sol=new Solution();
        int[] nums={1,2,3};
        List<List<Integer>> result=sol.permute(nums);
        System.out.println(result);
    }
}
