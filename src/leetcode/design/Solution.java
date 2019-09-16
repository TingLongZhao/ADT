package leetcode.design;

import java.util.Random;

public class Solution {
/*    打乱一个没有重复元素的数组。

    示例:

    // 以数字集合 1, 2 和 3 初始化数组。
    int[] nums = {1,2,3};
    Solution solution = new Solution(nums);

// 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。
solution.shuffle();

// 重设数组到它的初始状态[1,2,3]。
solution.reset();

// 随机返回数组[1,2,3]打乱后的结果。
solution.shuffle();*/
    private int[] original;
    private int[] current;
    public Solution(int[] nums) {
        original = nums;
        current = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < original.length; i++) {
            int index = random.nextInt(original.length);
            int tmp = current[index];
            current[index] = current[0];
            current[0] = tmp;
        }
        return current;
    }
}
