package Problem_1_Rotate_Array;

import java.util.Arrays;

public class RotateArray {

        public void rotate(int[] nums, int k) {
            int len=nums.length;
            k=k%len;
            swap(nums,len-k,len-1);
            swap(nums,0,len-k-1);
            swap(nums,0,len-1);

        }
        void swap(int[] nums,int left,int right){
            while(left<right){
                int temp=nums[left];
                nums[left]=nums[right];
                nums[right]=temp;
                left++;
                right--;
            }
        }

    public static void main(String[] args) {
        int[] arr={ -1,-100,3,99};
        RotateArray rotateArray=new RotateArray();
        rotateArray.rotate(arr,2);
        Arrays.stream(arr).forEach(n-> System.out.print(n+" "));
    }
}
