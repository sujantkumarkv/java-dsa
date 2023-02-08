package leetcode;
import java.util.*;

public class findAllDuplicates442 {
    public static void main(String[] args) {
        int[] arr= {4,3,2,7,8,2,3,1};
        List<Integer> answer= main(arr);
        System.out.println(answer);
    }
    public static List<Integer> main(int[] arr) {
    int i=0, N= arr.length;
    List<Integer> ans= new ArrayList<>();
    while(i< N) {
            int correctIndex= arr[i] - 1;
            if(arr[i] != arr[correctIndex])
                swap(arr, i, correctIndex);
            else
                i++;
    }

    for(int j=0; j< N; j++){
        if(arr[j] != j+1)
        //after sorting now above, no need to swap, or see correctIndex, bcz 
        //now which is just in the wrong position is the duplicate ones.
            ans.add(arr[j]);
    }

    return ans;
}

  static void swap(int[] arr, int first, int second) {
    int temp= arr[first];
    arr[first]= arr[second];
    arr[second]= temp;
  }
}
