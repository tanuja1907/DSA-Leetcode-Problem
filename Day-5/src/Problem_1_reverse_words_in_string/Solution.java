package Problem_1_reverse_words_in_string;

class Solution {
    // T.C. -O(n)
    // S.C. -O(n)
    public String reverseWords(String s) {
        StringBuilder reverseString=new StringBuilder();
        int end=s.length()-1;
        while(end>=0){
            while(end>=0 && s.charAt(end)==' ')end--;
            int start=end;
            while(start>=0 && s.charAt(start)!=' '){
                start--;
            }
            for(int j=start+1;j<=end;j++){
                reverseString.append(s.charAt(j));
            }

            reverseString.append(' ');
            end=start-1;
        }
        while(!reverseString.isEmpty() && reverseString.charAt(reverseString.length()-1)==' ')
            reverseString.setLength(reverseString.length()-1);
        return reverseString.toString();
    }

    public static void main(String[] args) {
        Solution sol=new Solution();
        String str=" Hello   World ";
        System.out.println(sol.reverseWords(str));
    }
}
