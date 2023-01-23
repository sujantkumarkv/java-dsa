import java.util.Arrays;
public class BSin2DArray {

    public static void main(String[] args) {
        int[][] matrix= {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {28, 29, 37, 49},
            {33, 34, 38, 50}
        };
        System.out.println(Arrays.toString(search(matrix, 45)));
    }
    static int[] search(int[][] arr, int target) {
        int r=0, c= arr[0].length-1;
        while(r< arr.length && c>=0) {

            if(arr[r][c] == target)
                return new int[]{r, c};
            
            if(arr[r][c] > target)
                c--;
            
            else
                r++;
        }
        return new int[]{-1, -1};

    }
}