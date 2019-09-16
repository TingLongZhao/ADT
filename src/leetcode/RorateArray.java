package leetcode;

public class RorateArray {
    public static void rotate(int[] nums, int k) {
            int[] array = new int[nums.length];
            for (int i =0;i<nums.length;i++){
                if(i+k>=nums.length){
                    array[(i+k)%nums.length] = nums[i];
                }else{
                    array[i+k] = nums[i];
                }
            }
        for (int i =0;i<array.length;i++){
            nums[i] = array[i];
            System.out.println(nums[i]);
        }
    }
    public static void rotate2(int[] nums, int k) {
        k=k%nums.length;
        reverse(nums);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }
    public static void reverse(int[] arr,int start,int end){
        int half=(end-start+1)/2;
        int tar;
        for(int i=0;i<half;i++){
            tar=arr[start];
            arr[start]=arr[end];
            arr[end]=tar;
            start++;
            end--;
        }

    }
    public static void reverse(int[] arr){
        reverse(arr,0,arr.length-1);
    }
    public static void main(String[] args) {
        int[] array = {-1,-100,3,99};
        rotate(array,2);
    }
}
