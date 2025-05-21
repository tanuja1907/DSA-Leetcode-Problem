package Problem_2_Happy_numbers;

import java.util.HashSet;
import java.util.Set;

/**
 * A happy number is defined as positive integer, replace by sum of squares of its digits,
 * repeat until the number equals to 1 ,if process ends with 1 then happy number, otherwise not
 * T.C.-O(log n)
 * S.C.-O(1)
 */
class Solution {
    /**
     *
     * set is used here to store and check whether a number has already occurred to avoid cycle
     * @param n  is a number to check whether happy or not
     * @return  boolean whether a number is happy or not
     */
    public boolean isHappy(int n) {
        Set<Integer> happyNumber = new HashSet<>();
        while (!happyNumber.contains(n)) {
            happyNumber.add(n);
            int newNum = 0;
            while (n > 0) {
                int rem = n % 10;
                newNum += rem * rem;
                n /= 10;
            }
            n = newNum;

        }
        return n == 1;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int n=19;
        System.out.println(solution.isHappy(n)+" , "+ n +" is a happy number.");
    }
}
