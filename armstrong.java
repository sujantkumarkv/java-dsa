public class armstrong {
    public static void main(String[] args) {
        check_armstrong(153);
    }

    static boolean check_armstrong(int n){
        int sum=0, num=n;
        while(n>0){
            int last_dig= n%10;
            sum+= last_dig ^ 3;
            n/= 10;
        }
        return sum==num;

    }


}
