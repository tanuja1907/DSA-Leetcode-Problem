package Problem_1_merge_sorted_array;
import java.util.Arrays;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result=new int[m+n];
        int i=0;
        int j=0;
        int k=0;
        while(i<m && j<n){
            if(nums1[i]<=nums2[j]){
                result[k++]=nums1[i++];
            }else{
                result[k++]=nums2[j++];
            }
        }
        while(i<m){
            result[k++]=nums1[i++];
        }

        while(j<n){
            result[k++]=nums2[j++];
        }

        System.arraycopy(result, 0, nums1, 0, result.length);
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        solution.merge(nums1,3,nums2,3);
        Arrays.stream(nums1).forEach(n-> System.out.print(n+" "));
    }
}
