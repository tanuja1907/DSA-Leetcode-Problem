package Problem_3_search_insert_position;

class Solution {
    //T.C.-O(log n)
    //S.C.-O(1)
    public int searchInsert(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        if(target>nums[end])return end+1;
        while(start<end){
            int mid=start+(end-start)/2;
            if(nums[mid]<target){
                start=mid+1;
            }else if(nums[mid]>target){
                end=mid;
            }else{
                return mid;
            }
        }
        return start;
    }

    public static void main(String[] args) {

        int[] arr={1,3,5,6};
        int target=5;
        Solution solution=new Solution();
        System.out.println(solution.searchInsert(arr,target));
    }
}
