//https://leetcode.com/problems/split-array-largest-sum/

/*
 * The LC410 problem here is solved upon a simpler condition to get the barebones of the code running,
 * m=2 is taken here, then moving towards a more general soln for m>2.
 */
import java.util.Arrays;
import java.util.stream.IntStream;

public class splitArraySum {
    public void main(){
        int[] arr= {7, 2, 5, 8, 10};
        int m=2, count=1, l=0, SIZE= arr.length-1;
        int[] subArr= new int[SIZE]; //the max length of any subarray
        int[] subArrSum= new int[m]; //the max subarray can be 'm' so 'm' sums.
        int[] LargestSums= new int[SIZE];

        while(l< arr.length-1){
    
            while(count<m){
                
                for(int i=0; i<=l; i++)
                    subArr[i]= arr[i];

                subArrSum[count-1]= IntStream.of(subArr).sum();
                Arrays.fill(subArr, 0);
                count++;
                
                for(int i=l+1; i<arr.length; i++)
                    subArr[i]= arr[i];

                subArrSum[count-1]= IntStream.of(subArr).sum();
                Arrays.fill(subArr, 0);
                count++;

                //LargestSums[l]= findMax(subArrSum);

                
                  
            }
            l++;
        }
        //return findMin(LargestSums);
    }

    }
    
