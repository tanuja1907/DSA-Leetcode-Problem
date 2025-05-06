package Problem_2_Remove_Star_From_String;

class Solution {
    /**
     * this program remove all the stars present in the string ,string builder is used to store result
     * T.C.-O(n)
     * S.C.-O(n)
     */
    public String removeStars(String s) {

        StringBuilder resultString = new StringBuilder();


        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                resultString.deleteCharAt(resultString.length() - 1);
            } else resultString.append(ch);
        }

        return resultString.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = "leet**cod*e";
        System.out.println(sol.removeStars(s));
    }
}
