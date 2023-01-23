//https://leetcode.com/problems/search-in-rotated-sorted-array/



package leetcode;

//NOT FOR DUPLICATE ELEMENTS IN ARRAY
public class RotatedBinarySearch33 {
        static int search(int[] nums, int target) {
        int pivot= findPivot(nums);//we find pivot
        if(pivot == -1)//pivot not found, do normal BS
            return BS(0, nums.length-1, target, nums);
        //if (target== nums[pivot])
            //return pivot;
        // when above lines used, the targetIndex below searches for *start=0 & end=pivot-1* so this works too
        
        
        int targetIndex= BS(0, pivot, target, nums); //target in the left half
        if(targetIndex != -1) //target not found
            return targetIndex; 
        else//target is then in the right half
            return BS (pivot+1, nums.length-1, target, nums);
       }
       
        static int findPivot(int[] nums) {
           int s=0, e= nums.length-1;
           //finding pivot, can be done in another function too
           while(s<=e){
               int m= s+ (e-s)/2;
               if (m<e && nums[m] > nums[m+1]) //array index OutOfBounds error
                   return m;
               if (m>s && nums[m] < nums[m-1]) //array index OutOfBounds error for m=0, m-1 is -1
                   return m-1;
               
               if (nums[s] > nums[m])
                   e= m-1;
               else s= m+1;
           }
           return -1; //pivot not found but we're considering that it's a pivot
       }
   
        static int BS(int start, int end, int target, int[] ar){
           //considering ascending as in Qn, not using orderAgnostic Binary Search
           while(start<=end){
               int mid= start + (end-start) /2;
               if (ar[mid]>target)
                   end=mid-1;
               else if (ar[mid]<target)
                   start= mid+1;
               else 
                   return mid;
           }
           return -1;
       }
}
