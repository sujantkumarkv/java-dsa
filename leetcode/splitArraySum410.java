package leetcode;

public class splitArraySum410 {
    public int splitArray(int[] nums, int m) {
        int start=0, end=0;
        
        for(int num: nums){
            start= Math.max(start, num); //lower end
            end+= num; //upper end
        }
        //[start, end] is the sorted ascending array
        //applied BS logic on potential answers
        while(start< end){
            int mid= start+ (end-start)/2;
            int subArrSum=0; //needs to be renewed for each new iteration
            int pieces=1;
            for(int num:nums)
            {
                if(subArrSum+num <= mid)
                    subArrSum+= num;
                else{
                    pieces++;
                    subArrSum=num;
                }
            }
            
            if(pieces<=m)
                end= mid;
            else
                start= mid+1;
        }
        return end; //or end
    }
}
