package leetcode;
import java.util.*;

public class findMissingAndDuplicate645 {
    public static void main(String[] args) {
        int[] arr= {1,2,2,4};
        int[] ans= new int[2];
        ans= findMissingAndDuplicateNumber(arr);
        System.out.println(Arrays.toString(ans));
    }

    static void swap(int[] arr, int first, int second) {
        int temp= arr[first];
        arr[first]= arr[second];
        arr[second]= temp;
    }
    
    //MY APPROACH
    public static int[] findMissingAndDuplicateNumber(int[] arr){
        
        int[] ans= new int[2];
        int i=0, N= arr.length;
        //cyclic sort
        while(i< N) {
            int correctIndex= arr[i] - 1;
            if(arr[i] != arr[correctIndex])
                swap(arr, i, correctIndex);             
            else 
                i++;
        }
        //loop for the missing number & duplicate
        for (int j = 0; j < N; j++) {
            if(arr[j] != (j+1)){
                /**
                 * Since the Qn has said about ONLY ONE NUMBER BEING REPEATED AT THE EXPENDSE OF 
                 * ONE MISSING NUMBER, SO WHEN arr[j] != (j+1),
                j+1 is the missing number BUT ALSO arr[j] is DEFINITELY the duplicate no. bcz
                 * all others must be in correct postitions, therefore
                no need to check for correct index & if it's repeating. 

                 int correct= arr[j]-1;
                 if(arr[j] == arr[correct])
                    ans[0]= arr[j];//adding duplicate first as per Qn
                 */
                ans[0]= arr[j];//adding duplicate first as per Qn
                ans[1]= (j+1);//adding missing number
            }       
        }
        return ans;     
    }

    //ALTERNATE APPROACHES: leetcode's solutions

    /** AlternateApproach1
     * We can reduce this space required to nnn by making use of an array, arr instead. 
     * Now, the indices of arr can be used instead of storing the elements again. 
     * Thus, we make use of arr in such a way that, arr[i]arr[i]arr[i] is used to store 
     * the number of occurences of the element i+1.
     * NOTE: we're able to do this bcs the array is : 1 TO N, with the simple 
     * condition in the Qn of one missing & duplicate element (as given in the Qn).
     */
    public static int[] AlternateApproach1(int[] nums) {
        int[] arr = new int[nums.length + 1];        
        int dup = -1, missing = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] += 1;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0)
                missing = i;
            else if (arr[i] == 2)
                dup = i;
        }
        return new int[]{dup, missing};
    }

    /** AlternateApproach2
     * We can save the space used in the last approach, if we can somehow, include the information regarding
     * the duplicacy of an element or absence of an element in the nums array.
     * We know that all the elements in the given nums array are positive, and lie in the range 1 to n only. 
     * Thus, we can pick up each element i from nums. For every number i picked up, we can invert the element 
     * at the index ∣i∣. By doing so, if one of the elements jjj occurs twice, when this number is encountered the second time,
     * the element nums[∣i∣]nums[\left|i\right|]nums[∣i∣] will be found to be negative. 
     * Thus, while doing the inversions, we can check if a number found is already negative, to find the duplicate number.
     * After the inversions have been done, if all the elements in nums are present correctly, 
     * the resultant nums array will have all the elements as negative now. But, if one of the numbers, j is missing, 
     * the element at the jth index will be positive. This can be used to determine the missing number.
     */
    public int[] AlternateApproach2(int[] nums) {
        int dup = -1, missing = 1;
        for (int n: nums) {
            if (nums[Math.abs(n) - 1] < 0)
                dup = Math.abs(n);
            else
                nums[Math.abs(n) - 1] *= -1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0)
                missing = i + 1;
        }
        return new int[]{dup, missing};
    }

}

