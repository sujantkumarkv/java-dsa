package leetcode;
//https://leetcode.com/problems/find-the-duplicate-number/
/*
 * Given an array of integers arr containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in arr, return this repeated number.
 * Input: arr = [1,3,4,2,2]
   Output: 2
 */

public class findDuplicate287 {

  public static void main(String[] args) {
    int[] arr= {1,3,4,2,2};
    int ans= findDuplicate(arr);
    System.out.println(ans);
  }

  public static int findDuplicate(int[] arr) {
    int i=0, N= arr.length;
    while(i< N) {
      if(arr[i] != i+1){
            int correctIndex= arr[i] - 1;
            if(arr[i] != arr[correctIndex])
                swap(arr, i, correctIndex);
            else
                //arr[i] == arr[correctIndex] i.e. duplicate found
                return arr[i];
        }
        else
            i++;
    }
    return -1;
  }


  static void swap(int[] arr, int first, int second) {
    int temp= arr[first];
    arr[first]= arr[second];
    arr[second]= temp;
  }

}
