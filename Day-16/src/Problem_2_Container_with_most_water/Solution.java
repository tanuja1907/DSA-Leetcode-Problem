package Problem_2_Container_with_most_water;

class Solution {
    /**
     *
     * @param height is the arr of n vertical lines such that two endpoints of the ith line are (i,0) and (i,height[i]).
     * @return  it returns max amount of water a container can store.
     * T.C.-O(n)
     * S.C.-O(1)
     */
    public int maxArea(int[] height) {
        int maxWater=0;
        int left=0;
        int right=height.length-1;
        while(left<right){
            int area =(right-left)*Math.min(height[left],height[right]);
            maxWater=Math.max(maxWater,area);
            if(height[left]<height[right])left++;
            else right--;
        }
        return maxWater;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] arr={1,8,6,2,5,4,8,3,7};
        System.out.println("Area with max water: "+solution.maxArea(arr));
    }
}