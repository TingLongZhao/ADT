package leetcode;


import java.util.*;

public class ContainsDuplicateArray {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap(nums.length);
        for (int i = 0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return true;
            }else {
                map.put(nums[i], i);
            }
        }
        return false;
    }
    public boolean containsDuplicate2(int[] nums) {
        return Arrays.stream(nums).distinct().count()!=nums.length;
    }
    public boolean containsDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }else {
                set.add(nums[i]);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(new ContainsDuplicateArray().containsDuplicate2(arr));
        System.out.println(1<<4);
        System.out.println(3<<1);
        System.out.println(16>>2);
    }
}
