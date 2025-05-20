package Problem_1_Median_of_two_sorted_array;

import java.util.Arrays;

/**
 * to find median first a new merged array of length nums1+nums2 is created and added all elements
 * then sort merged array and find median
 * T.C.-O(n log n)+O(m+n)
 * S.C.-O(1)
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int k=0;
        int[] merged=new int[m+n];
        for (int value : nums1) {
            merged[k++] = value;
        }
        for (int j : nums2) {
            merged[k++] = j;
        }
        Arrays.sort(merged);
        int len=merged.length;
        if(len%2==1){
            return (double)merged[len/2];
        }else{
            int middle1=merged[len/2-1];
            int middle2=merged[len/2];
            return (double)(middle1+middle2)/2;
        }
    }

    public static void main(String[] args) {
        int[] arr1={1,3};
        int[] arr2={2};
        Solution solution=new Solution();
        System.out.println("Median of two array: "+solution.findMedianSortedArrays(arr1,arr2));
    }
}
