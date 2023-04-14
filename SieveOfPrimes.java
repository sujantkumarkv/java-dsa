import java.util.*;
//finds all prime numbers < integer N
public class SieveOfPrimes { 
    public static void main(String[] args) {
        //pass the N to check how many are primes till N
        List<Integer> ans = new ArrayList<Integer>();
        ans= SieveOfPrimes(40);
        System.out.println(ans.toString());
    }


    //APPROACH 1
    ///////////////////////////////////////////////////////////////////////////////////
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
        while(counter <= N){ //O(n) comparisons
            if(isPrime(counter)){
                answer.add(counter);
                removePrimeMultiples(primes, counter);
                /* 
                N/2 + N/3 + N/5 + N/.... comparisons for counter=2, 3, 5...
                so O(n)= N+ the above sum(taylor series sum for primes)
                => N+ N.log(log(N))
                therefore, time complexity: O(N * log(log(N)))
                */ 
            }              
            counter++;
    }
    return answer;

   }

    

}


