package Problem_2_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Subset {

        public List<List<Integer>> findSubsets(int[] nums) {
            List<List<Integer>>  allSubsets =new ArrayList<>();
            solve(nums,0,allSubsets,new ArrayList<>());
            return allSubsets;

        }
        void solve(int[] nums,int idx, List<List<Integer>>  allSubsets,List<Integer> temp){
            if(idx>=nums.length){
                allSubsets.add(new ArrayList<>(temp));
                return;
            }

            temp.add(nums[idx]);
            solve(nums,idx+1,allSubsets,temp);
            temp.removeLast();
            solve(nums,idx+1,allSubsets,temp);
        }

    public static void main(String[] args) {
        Subset subset=new Subset();
        int[] arr={1,2,3,4};
        List<List<Integer>> result=subset.findSubsets(arr);
        for(List<Integer> list:result){
            System.out.println(list);
        }
    }
    }

