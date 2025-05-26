package Problem_3_Beadt_time_to_buy_and_sell_stock;

/**
 *  T.C.-O(n)
 *  S.C.-O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int firstBuy=Integer.MIN_VALUE;       // for first purchase
        int firstSell=0;                      // for first sell
        int secondBuy=Integer.MIN_VALUE;      // for second purchase
        int secondSell=0;                     // second sell of stock
        for(int price:prices){
            firstBuy=Math.max(firstBuy,-price);
            firstSell=Math.max(firstSell,firstBuy+price);
            secondBuy=Math.max(secondBuy,firstSell-price);
            secondSell=Math.max(secondSell,secondBuy+price);
        }
        return secondSell;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] arr={3,3,5,0,0,3,1,4};
        System.out.println(solution.maxProfit(arr));
    }
}