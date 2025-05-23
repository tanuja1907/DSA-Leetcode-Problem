package Problem_2_Can_place_flowers;

/**
 * Iterate all flowers and checking there is not flower at left (@checkLeft),and at right (@checkRight) if both are true new flower is planted
 * T.C.-O(n)
 * S.C.-O(1)
 */
class Solution {
    /**
     *
     * @param flowerbed     containing 0's and 1's, where 0 means empty and 1 means not empty,
     * @param n             is the number of flowers need to be planted
     * @return              true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                boolean checkLeft = (i == 0) || (flowerbed[i - 1] == 0);
                boolean checkRight = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);
                if (checkLeft && checkRight) {
                    flowerbed[i] = 1;
                    n--;
                    if (n == 0) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] flowers = {1, 0, 0, 0, 1};
        Solution solution = new Solution();
        System.out.println(solution.canPlaceFlowers(flowers, 2));
    }
}