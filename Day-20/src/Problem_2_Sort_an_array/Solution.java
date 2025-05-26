package Problem_2_Sort_an_array;

import java.util.Arrays;

/**
 * this program uses merge sort to sort an array uses divide and conquer method
 *  T.C.-O(n log n)
 *  S.C.-O(n)
 */
class Solution {
    public void sortArray(int[] nums) {
        if(nums==null || nums.length<=1)return;
        mergeSort(nums,0,nums.length-1);
    }
    void mergeSort(int[] nums,int left,int right){
        if(left>=right)return;
        int mid=left+(right-left)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);

        merge(nums,left,mid,right);

    }
    void merge(int[] nums,int left,int mid,int right){
        int[] merged=new int[right-left+1];
        int i=left;
        int j=mid+1;
        int k=0;

        while(i<=mid && j<=right){
            if(nums[i]<=nums[j]){
                merged[k++]=nums[i++];
            }else{
                merged[k++]=nums[j++];
            }
        }
        while(i<=mid){
            merged[k++]=nums[i++];
        }
        while(j<=right){
            merged[k++]=nums[j++];
        }
        System.arraycopy(merged, 0, nums, left, merged.length);
    }

    public static void main(String[] args) {
        int[] arr={5,2,3,1};
        Solution solution=new Solution();
        solution.sortArray(arr);
        System.out.println("sorted array using merge sort");
        Arrays.stream(arr).forEach(System.out::println);
    }
}