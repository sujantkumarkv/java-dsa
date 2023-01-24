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
                int correct= arr[j]-1;
                if(arr[j] == arr[correct])
                    ans[0]= arr[j];
                
                ans[1]= (j+1);
            }       
        }
        return ans;        
    }

}

