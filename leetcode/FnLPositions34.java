/*
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */

package leetcode;

public class FnLPositions34 {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int startIndex, endIndex;
            startIndex= LS(true, nums, target);
            endIndex= LS(false, nums, target);
            int[] ans= {startIndex, endIndex};
            return ans;
        }

        public int LS(boolean startingOccurence, int[] arr, int target){
            int start=0, end= arr.length-1, ans= -1;
            while(start<=end){
            int middle= start + (end-start) /2;
            
            if (arr[middle]>target)
                end=middle-1;
            else if (arr[middle]<target) 
                start= middle+1;
            else {
                //potential answer found
                ans= middle;
                
                if(startingOccurence)
                    end= middle-1;
                else 
                    //Last occurence being searched
                    start= middle+1;            
            }
            
        }
        return ans;
        }
    }
}
