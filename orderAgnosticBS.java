public class orderAgnosticBS {
    public int orderAgnosticBinarySearch(int start, int end, int target, int[] ar ){
        boolean isAsc= ar[start] < ar[end];
        while(start<=end){
            int middle= start + (end-start) /2;
            
            if (ar[end] == target)
                return middle;
            if(isAsc){ //ascending
                if (ar[end]>target)
                    end=middle-1;
                else
                    start= middle+1;
            }
            else { //descending
                if (ar[end]<target)
                    end=middle-1;
                else
                    start= middle+1;
            }     
        }// while ends
        return -1;
    }
}
