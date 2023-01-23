import java.util.Arrays;
public class BSinSorted2DArray {
    public static void main(String[] args) {
        int[][] matrix= {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {28, 29, 37, 49},
            {33, 34, 38, 50}
        };
        System.out.println(Arrays.toString(Search(matrix, 37)));
    }
    static int BinarySearch(int arr[], int target){
        int start=0, end= arr.length-1;
        while(start<=end){
            int middle= start + (end-start) /2;
            if (arr[middle]>target) end=middle-1;
            else if (arr[middle]<target) start= middle+1;
            else return middle;
        }
        return -1;
    }

    static int[] Search(int[][]matrix, int target) {

        int m= matrix.length, n= matrix[0].length;
        int lowerB= 0, upperB= m-1;
        while(lowerB < upperB){
            int mid= lowerB + (upperB-lowerB)/2;
            if(target > matrix[mid][n-1])
                lowerB= mid+1;
            else if(target < matrix[mid][n-1])
                upperB= mid;
            else 
                return new int[] {mid, m-1};
        }
        System.out.println(lowerB);
        System.out.println(m);
        System.out.println(n);
        System.out.println(upperB);
        System.out.println(Arrays.toString(matrix[lowerB]));
        int columnIndex= BinarySearch (matrix[lowerB], target);
        if(columnIndex != -1)
            return new int[]{lowerB, columnIndex};
        
        return new int[]{-1, -1};
    }  
}

    
