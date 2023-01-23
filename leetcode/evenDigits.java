package leetcode;
class evenDigits{
    public static void main(String[] args) {
        int[] nums= {12, 345, 2, 6, 7896, 78};
        checkEven(nums);
    }
    static void checkEven (int[] nums) {
        int count= 0;
        for(int num: nums){
            int len= Integer.toString(num).length();
            if (len%2==0) count++;
        }
        System.out.println(count);
    }
}