package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SolutionSum {
    public  static int[] twoSum(int[] nums, int target) {
        int i = 0;
        int j = 0;
        while(i<nums.length){
             j = i+1;
            while(j<nums.length){
                if(nums[j]+nums[i]==target){
                    int[] arr = new int[2];
                    arr[0] = i;
                    arr[1] = j;
                    return arr;

                }else{
                    j++;
                }
            }
            i++;

        }
        int[] arr = new int[2];
        arr[0] = i;
        arr[1] = j;
        return arr;
    }
    public  static int[] twoSum2(int[] nums, int target) {
       int [] arr = new int[2];
        Map hashMap = new HashMap();
        for (int i = 0;i<nums.length;i++){
            int num = target - nums[i];
            if(hashMap.containsKey(nums[i])){
                arr[0] = i;
                arr[1] = (int)hashMap.get(nums[i]);
                return arr;
            }
            hashMap.put(num,i);
        }

       return arr;
    }
    public static void main(String[] args) {
        int[] arr = {3,2,4};
        System.out.printf(twoSum2(arr,6).toString());
    }
}
