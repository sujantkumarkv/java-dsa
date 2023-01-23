public class rotationCount {
    public static void main(String[] args) {
        int[] arr= {3, 4, 5, 6, 7, 0, 1, 2};
        rotationInRotatedArray(arr);
    }
    public static void rotationInRotatedArray (int[] arr) {
        int count= findPivot(arr)+1;
        System.out.println(count);
    }

    public static int findPivot(int[] ar){
        int s=0, e= ar.length-1;
        while(s<e){
            int mid= s+ (e-s)/2;
            if(mid<e && ar[mid]> ar[mid+1])
                return mid;
            if(mid>s && ar[mid]< ar[mid-1])
                return mid-1;
            if(ar[s]> ar[mid])
                e= mid-1;
            else
                s= mid+1;
        }
        return -1;
    }
}
