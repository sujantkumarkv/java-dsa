import java.util.Arrays;

public class ArraySorting {
 
    public static void main(String[] args) {
        int[] arr= {5, 4, 3, 1, 2};
        CyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int[] arr, int first, int second) {
        int temp= arr[first];
        arr[first]= arr[second];
        arr[second]= temp;
    }

    static void BubbleSort(int[] arr){
        /*
         * Iterate thru' the array multiple times & compare the adjacent elements to sort them.
         * Continue this to get the sorted array.
         * If it's not sorted in a particular i's iteration, so swapped is false, hence it's now sorted & 
         * we don't need to continue, so break.
         */
        boolean swapped= false;
        for(int i=0; i<arr.length; i++){
            //due to j++, it gives IndexOutOfBoundException so we comparison btwn [j] & [j-1]
            for(int j=1; j<arr.length -i; j++){ 
                if(arr[j-1] > arr[j]){
                    //swap
                    swapped= true;
                    swap(arr, j-1, j);
                    
                }
            }
            if(!swapped) break;
        }
    }

    static void SelectionSort(int[] arr){
        /*
         * select and sort that element, keeping it in its place:-> For ascending,
         * Place the largest element in the last, reduce the array for next iteration since the last element sorted,
         * wont be sorted again; now in the reduced array, place ITS largest element in it's last index(same operation) 
        */
        int maxIndex, lastIndex, max; //the indexes of the largest value in the array, so as to swap them.
        for(int i=0; i< arr.length; i++){
            maxIndex= 0;
            max= arr[maxIndex];
            lastIndex= arr.length-i-1; //-1 bcz index ofc
            for(int j=1; j< arr.length-i; j++){
                if(arr[j] > max){
                    max= arr[j];
                    maxIndex= j;   
                }
            }
            //swap
            swap(arr, maxIndex, lastIndex);
        }
    }

    static void InsertionSort(int[] arr){
        int N= arr.length;
        for(int i=0; i< N-1; i++){
            for(int j= i+1; j>0; j--){
                //ascending
                if(arr[j] < arr[j-1]) 
                    swap(arr, j, j-1);
                //L.H.S would be sorted so if for one j, it doesnt swap, 
                //we break j's loop & continue with i's loop.
                else break;
            }
        }
    }

    static void CyclicSort(int[] arr){
        /**
         * It works for the logic of number range: 1 to N...
         * Simply, in ideal sorted condition, index= value-1; 
         * else we swap it to fulfill that condition
         */
        int i=0, N= arr.length;
        while(i< N) {
            int correctIndex= arr[i] - 1;
            if(arr[i] == arr[correctIndex])
                i++;
            else 
                swap(arr, i, correctIndex);
        }
    }
}
