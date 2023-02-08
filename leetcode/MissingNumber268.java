package leetcode;
import java.util.Arrays;

public class MissingNumber268 {
    public void main(String[] args) {
        int[] arr= {3, 0, 1};
        findMissingNumber(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int first, int second) {
        int temp= arr[first];
        arr[first]= arr[second];
        arr[second]= temp;
    }

    public int findMissingNumber(int[] arr){
        int i=0, N= arr.length;
        while(i< N) {
            int correctIndex= arr[i];
            if(arr[i]<N && arr[i] != arr[correctIndex])
                swap(arr, i, correctIndex);
               
            else 
                i++;
        }

        //search for the missing number
        for (int j = 0; j < N; j++) {
            if(arr[j] != j)
                return j;
        }
        //case 2: when all is sorted & present but it doesn't return,
        //its when N is the last element.
        return N;
    }
}
