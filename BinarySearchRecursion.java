public class BinarySearchRecursion {
    public static void main(String[] args) {
        int[] arr= {23, 34, 3, 2, 4, 52, 234, 64, -21, 45};
        int target= 34234;
        System.out.println(search(arr, target, 0, arr.length-1));
    }

    static int search(int[] arr, int target, int s, int e){
        if(s > e)
            return -1;

        int m= s + (e-s)/2;
        if(arr[m] == target) return m;
        if(arr[m] > target)
            s= m+1;
        else
            e= m-1;

        return search(arr, target, s, e);


    }
}

