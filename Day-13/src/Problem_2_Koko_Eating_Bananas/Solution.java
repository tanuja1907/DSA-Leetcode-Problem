package Problem_2_Koko_Eating_Bananas;

import java.util.Arrays;

/**
 * this problem uses binary search as here koko has to decide if value of k increases she finishes sooner,
 * if she eats slower it can increase more than h hours
 * T.C.-O(n*log m)
 * S.C.-O(1)
 */
public class Solution {
    /**
     *
     * @param piles  total piles of bananas
     * @param h      hours koko can finish all bananas of every pile
     * @return       min value of banana koko should eat per hour
     */
    public int minEatingSpeed(int[] piles, int h) {
        if (h < piles.length) {
            System.out.println("Error!,piles.length <= h <= 10^9");
            return -1;
        }
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEatAll(piles, mid, h)) {
                right = mid;            // can try slower speed also
            } else {
                left = mid + 1;         // need to fasten up speed
            }
        }
        return left;

    }

    /**
     *
     * @param piles     total piles of bananas
     * @param mid       value of banana koko eats per hour
     * @param h         hours koko can finish all bananas of every pile
     * @return          this function if the mid which is banana count koko should eat per hours if koko can finish all piles within time h it returns true
     */

    private boolean canEatAll(int[] piles, int mid, int h) {
        int actualHours = 0;
        for (int pile : piles) {
            actualHours += pile / mid;
            if (pile % mid != 0) {
                actualHours++;          // handle remainder like 11/4 =2 but needed 3 hours
            }
        }
        return actualHours <= h;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 7, 11};
        Solution solution = new Solution();
        System.out.println(solution.minEatingSpeed(arr, 4));
    }
}
