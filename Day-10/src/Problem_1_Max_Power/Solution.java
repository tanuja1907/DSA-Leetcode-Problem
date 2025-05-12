package Problem_1_Max_Power;


class Solution {
//   solution with the use of inbuilt function
//   T.C.-O(logn)
//   S.C.-O(1)
//    public double myPow(double x, int n) {
//        return Math.pow(x, n);
//    }

    public double myPow(double x, int n) {
        return calc_pow(x, (long) n);

    }

    //  recursive approach
    double calc_pow(double base, long pow) {

        if (base == 0) return 0;
        if (pow == 0) return 1;
        if (pow < 0) {
            return 1.0 / calc_pow(base, -pow);
        }
        if (pow % 2 == 1) {
            return base * calc_pow(base * base, (pow - 1) / 2);
        } else return calc_pow(base * base, pow / 2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(2.00000, 10));
    }
}