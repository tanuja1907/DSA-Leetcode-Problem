package Problem_2_Max_Num_0f_k_sum_pairs;

import java.util.HashMap;

class Solution {

    // this function calculates the max operation performed to get value of k ,
    // uses data structure map to store the and chexk the value of num-k and
    // it prevent to use same number again by reducing frequency after adding operation count.
    // T.C.-O(n)
    //S.C.-O(n)
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int operations = 0;
        for (int num : nums) {
            int freqMap = k - num;
            if (map.getOrDefault(freqMap, 0) > 0) {
                operations++;
                map.put(freqMap, map.get(freqMap) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

        }
        return operations;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4};
        int k = 5;
        System.out.println("Maximum operations required " + solution.maxOperations(arr, k));
    }
}