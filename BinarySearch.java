public class BinarySearch {
    public static void main(String[] args) {
        int[] arr= {-2, -1, 0, 2, 3, 34, 343, 555, 8553}; //ascending
        System.out.println(binarySearch(arr, 34));
    }
    public static int binarySearch(int arr[], int target){
        int start=0, end= arr.length-1;
        while(start<=end){
            int middle= start + (end-start) /2;
            if (arr[middle]>target) end=middle-1;
            else if (arr[middle]<target) start= middle+1;
            else return middle;
        }
        return -1;
    }
}
