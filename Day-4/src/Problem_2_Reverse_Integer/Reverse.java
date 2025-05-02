package Problem_2_Reverse_Integer;

public class Reverse {
        public int reverse(int x) {
            int rev=0;
            while(x!=0){
                int num=x%10;
                x/=10;
                if(rev>Integer.MAX_VALUE/10 ||rev==Integer.MAX_VALUE/10  && num>7)return 0;
                if(rev<Integer.MIN_VALUE/10 ||rev==Integer.MIN_VALUE/10 && num<-8 )return 0;
                rev=rev*10+num;
            }
            return rev;
        }

    public static void main(String[] args) {
        Reverse reverse=new Reverse();
        System.out.println(reverse.reverse(1234567));
    }
}
