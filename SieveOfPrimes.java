import java.util.*;

public class SieveOfPrimes {
    
    public static void main(String[] args) {
        //pass the N to check how many are primes till N
        List<Integer> ans = new ArrayList<Integer>();
        ans= SieveOfPrimes(40);
        //System.out.println((ans).toArray(new Integer[ans.size()]));
        System.out.println(ans.toString());

    }

    static boolean isPrime(int num){
        for (int i = 2; i < num; i++) {
            if(num % i == 0)
                return false;
        }
        return true;
    }

    static void removePrimeMultiples(boolean[] primes, int counter) {
        int n= primes.length/counter;
        for (int i = 2; i <= n; i++) 
            primes[(counter * i) - 1] = true; //int valueToBeRemoved= counter * i;
    }

    
    static List<Integer> SieveOfPrimes(int N){
        //first make a boolean array
        boolean[] primes= new boolean[N];// all are intialized to 'false' by default
        int counter= 2;
        List<Integer> answer = new ArrayList<Integer>();
        while(counter <= N){
            if(isPrime(counter)){
                answer.add(counter);
                removePrimeMultiples(primes, counter);
            }              
            counter++;
    }
    return answer;

   }
}


