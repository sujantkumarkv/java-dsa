/*
 * https://leetcode.com/problems/peak-index-in-a-mountain-array/
 * 
 * Example 1:

Input: arr = [0,1,0]
Output: 1
Example 2:

Input: arr = [0,2,1,0]
Output: 1
 */

package leetcode;
public class peakIndex852 {
    public int peakIndexInMountainArray(int[] arr) {
        int start= 0, end= arr.length;
        while(start!=end){ //bcz at end, start==end and it's only one element i.e., peak value
            int mid= start + (end-start)/2;
            if(arr[mid] > arr[mid+1]) end= mid; //we're in descending part & mid maybe a possible answer.
            else start= mid+1; //we're in ascending part & anyways ar[mid]<ar[mid+1] so value directly skips to mid+1.
        }
        return start; //OR return end; both are same for peak value.
    }
}
