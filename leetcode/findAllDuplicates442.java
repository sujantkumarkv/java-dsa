package leetcode;

public class findAllDuplicates442 {
    public static void main(String[] args) {
        
    }
    public static int main(int[] arr) {
    int i=0, N= arr.length;
    while(i< N) {
      if(arr[i] != i+1){
            int correctIndex= arr[i] - 1;
            if(arr[i] != arr[correctIndex])
                swap(arr, i, correctIndex);
            else
                //arr[i] == arr[correctIndex] i.e. duplicate found
                return arr[i];
        }
        else
            i++;
    }
    return -1;
  }


  static void swap(int[] arr, int first, int second) {
    int temp= arr[first];
    arr[first]= arr[second];
    arr[second]= temp;
  }
}
