package Problem_2_Kth_Largest_Element;

import java.util.PriorityQueue;

/**
 * This class provides a method to find the Kth largest element in an unsorted array.
 * T.C.-O(n log n)
 * S.C.-O(n)
 */
public class Solution {
    /**
     * here priority queue used as min-heap to get the kth largest element
     * whenever the size of queue increases than k element pop from the queue
     *
     * @param nums is the array of elements
     * @param k    kth element to be found
     * @return return the kth largest element in an array
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) minHeap.poll();

        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        Solution solution = new Solution();
        System.out.println(solution.findKthLargest(arr, 2));
    }
}
