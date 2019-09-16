package leetcode;

public class RemoveSortArray {
    public static int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0;i<nums.length;i++){
            if(nums[i]!=nums[index]){
                index++;
                nums[index] = nums[i];
            }
        }
        return ++index;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int len = removeDuplicates(nums);
        for (int i = 0;i<len;i++){
            System.out.println(nums[i]);
        }
    }
}
