package leetcode;
import java.util.*;

public class findMissingAndDuplicate645 {
    public static void main(String[] args) {
        int[] arr= {1,2,2,4};
        int[] ans= new int[2];
        ans= findMissingAndDuplicateNumber(arr);
        System.out.println(Arrays.toString(ans));
    }

    static void swap(int[] arr, int first, int second) {
        int temp= arr[first];
        arr[first]= arr[second];
        arr[second]= temp;
    }

    public static int[] findMissingAndDuplicateNumber(int[] arr){
        int[] ans= new int[2];
        int i=0, N= arr.length;
        //cyclic sort
        while(i< N) {
            int correctIndex= arr[i] - 1;
            if(arr[i] != arr[correctIndex])
                swap(arr, i, correctIndex);             
            else 
                i++;
        }
        //loop for the missing number & duplicate
        for (int j = 0; j < N; j++) {
            if(arr[j] != (j+1)){
                /**
                 * Since the Qn has said about ONLY ONE NUMBER BEING REPEATED AT THE EXPENDSE OF 
                 * ONE MISSING NUMBER, SO WHEN arr[j] != (j+1),
                j+1 is the missing number BUT ALSO arr[j] is DEFINITELY the duplicate no. bcz
                 * all others must be in correct postitions, therefore
                no need to check for correct index & if it's repeating. 

                 int correct= arr[j]-1;
                 if(arr[j] == arr[correct])
                    ans[0]= arr[j];//adding duplicate first as per Qn
                 */
                ans[0]= arr[j];//adding duplicate first as per Qn
                ans[1]= (j+1);//adding missing number
            }       
        }
        return ans;        
    }

}

