package leetcode;

public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int i = 0;
        int k = nums.length-1;
        while(i<k){
            if(nums[i]==0){
                for (int j = i+1; j <=k ; j++) {
                    nums[j-1] = nums[j];
                }
                nums[k] = 0;
                k--;
                continue;
            }
                i++;
        }
    }
    public static void moveZeroes2(int[] nums) {
        int k = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        while(k<nums.length){
            nums[k] = 0;
            k++;
        }
    }
    public static void main(String[] args) {
        int [] arr = {0,0,1};
        moveZeroes2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
