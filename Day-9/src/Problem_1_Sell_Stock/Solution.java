package Problem_1_Sell_Stock;

/**
 * T.C.-O(n)
 * S.C.-O(1)
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            }
            maxProfit = Math.max(maxProfit, prices[i] - buy);
        }
        return maxProfit;

    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] stockPrizes={7,6,4,3,1};
        System.out.println("Max profit earn is "+ solution.maxProfit(stockPrizes));
    }
}