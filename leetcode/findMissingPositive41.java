package leetcode;
//https://leetcode.com/problems/first-missing-positive/
import java.util.*;

public class findMissingPositive41 {
    public static void main(String[] args) {
        
    }
    public static int firstMissingPositive(int[] nums) {
        int N= nums.length ;

        int[] arr= new int[N+1];
        for(int i=0; i<N; i++){
            /*
             * Instead of having MAX, &  finding the arr.length to initalize for,
             * simply have one more element and shifted the elements in arr by looping in nums, 
             * if, nums[i] > arr.length; say its '7' & length is 5, so skip it bcz it would be 
             * 0 by default & the first element with 0 in arr wld be returned. 
             * IT ALSO HANDLES -VE values as we simply skip it.
             * Eg.
             * [3, 4, -1, 1] expected ans: 2
             * arr= [_, _, _, _, _] & wld loop from arr[1]; we can skip -ve or values > than 4+1.
             * therefore, arr= [_, 1, 0, 3, 4] & looping from arr[1], *2nd* index has count *0* 
             * so, answer found= 2 & return it.
             * 
             * SIMILARLY,
             * nums= [7,8,9,11,12],
             * arr= [_, _, _, _, _, _] & all values > 5+1, so all values are 0 & 
             * the first time we encounter arr[j]==0 is for j=1 (looping from j=1); 
             * therefore, answer found= 1;
             */
            if(nums[i] > 0 && nums[i] < arr.length) //bcz -ve numbers are allowed & else wld break the array
                arr[nums[i]] += 1;
        }
        for(int j=1; j<arr.length; j++){
            if(arr[j] == 0)
                return j; 
        }
        //handling the last element
        /*
         * I misjudged the Qn, if say the nums[] is {0, 1, 2.... 11} then the answer shall be 12.
         * I solved from the context of looking from 1 & missing would be in between 1 & largest no.
         * but if not, the next element which would be then the largest & would be equal to arr.length 
         * IS THE MISSING value & thus is the answer.         
         * */
        //if the last value isn't length's value, then length's value is the missing one.
        if(arr[arr.length -1] != arr.length)
            return arr.length;
        return -1;
    }

    //APPROACH 2: Cyclic sort (kunal's)
    public int findMissingPositive2(int[] arr){
        int i=0, N= arr.length;
        while(i< N) {
            int correctIndex= arr[i];
            //ignore values -> -ve ones, those >N, & those who're already sorted.
            if(arr[i]>0 && arr[i]<=N && arr[i] != arr[correctIndex])
                swap(arr, i, correctIndex);
               
            else 
                i++;
        }

        //search for the missing number
        for (int j = 0; j < N; j++) {
            if(arr[j] != j+1)
                return j+1;
        }
        //case 2: when all is sorted & present but it doesn't return,
        //its when it's completed the loop, so answer is last element.
        return N+1;
    }
    static void swap(int[] arr, int first, int second) {
        int temp= arr[first];
        arr[first]= arr[second];
        arr[second]= temp;
    }
}

