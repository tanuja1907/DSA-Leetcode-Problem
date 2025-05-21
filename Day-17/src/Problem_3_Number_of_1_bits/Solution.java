package Problem_3_Number_of_1_bits;

/**
 * This program return the number of set bits in its binary representation (also known as the Hamming weight)
 * T.C.-O(1)
 * S.C.-O(1)
 */
class Solution {
    /**
     *
     * @param n is a positive integer to check set bits
     * @return  number of set bits of n
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n > 0) {
            int rem = n % 2;
            if (rem == 1) count++;
            n /= 2;
        }
        return count;
    }

    public static void main(String[] args) {
        int n=27;
        Solution solution=new Solution();
        System.out.println("Total no of bits are: "+solution.hammingWeight(n));
    }
}