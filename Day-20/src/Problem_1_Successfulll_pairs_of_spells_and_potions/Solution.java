package Problem_1_Successfulll_pairs_of_spells_and_potions;

import java.util.Arrays;

/**
 *  Uses binary to find the successful number of potions that will form a successful pair with the ith spell.
 *  T.C.-O((n+m) log m)
 *  S.C.-O(n)
 */
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n=spells.length;
        int m=potions.length;
        int[] result=new int[n];

        for(int i=0;i<n;i++){
            int spell=spells[i];
            long minPotion=(success+spell-1)/spell;

            int left=0;
            int right=m-1,idx=m;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(potions[mid]>=minPotion){
                    idx=mid;
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
            result[i]=m-idx;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sp=new Solution();
        int[] spells = {5, 1, 3};
        int[] potions = {1, 2, 3, 4, 5};
        int success = 7;

        System.out.println(Arrays.toString(sp.successfulPairs(spells, potions, success))); // Output: [4, 0, 3]

    }
}