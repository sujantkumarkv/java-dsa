//https://leetcode.com/problems/find-in-mountain-array/

package leetcode;
public class findInMountainArray1095 {
    
    public int findMinIndex(int[] arr, int target) {
        int s=0, e= arr.length-1;
        while(s!=e){ // searching in mountain array
            int middle= s+ (e-s)/2;
            if(arr[middle] > arr[middle+1]) 
                e= middle;
            else
                s= middle+1;
        }
        int peak= s;
        int minIndex= BS(arr, 0, peak, target);
        if (minIndex== -1) 
            minIndex= BS(arr, peak, arr.length-1, target);
        
        return minIndex;
    }

    public int BS(int start, int end, int target, MountainArray mountainArr){
        boolean isAsc= MountainArray.get(start) < MountainArray.get(end);
        while(start<=end){
            int middle= start + (end-start) /2;
            
            if (MountainArray.get(middle) == target)
                return middle;
            if(isAsc){ //ascending
                if (MountainArray.get(middle)>target)
                    end=middle-1;
                else
                    start= middle+1;
            }
            else { //descending
                if (MountainArray.get(middle)<target)
                    end=middle-1;
                else
                    start= middle+1;
            }     
        }// while ends
        return -1;
    }
}
