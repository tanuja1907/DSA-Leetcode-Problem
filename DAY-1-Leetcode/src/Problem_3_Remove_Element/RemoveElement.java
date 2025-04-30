package Problem_3_Remove_Element;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }

        }
        return index;
    }

    public static void main(String[] args) {
        RemoveElement removeElement=new RemoveElement();
        int[] arr={1,3,2,2,};
        int val=1;
        int result=removeElement.removeElement(arr,val);
        for(int i=0;i<result;i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
