package leetcode.other;


import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;

public class Solution {
    public static int hammingWeight(int n) {
        int result = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((mask & n) != 0) {
                result++;
            }
            mask <<= 1;
        }
        return result;
    }

    public int hammingWeight2(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

    /*   两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。

       给出两个整数 x 和 y，计算它们之间的汉明距离。

       注意：
               0 ≤ x, y < 231.

       示例:

       输入: x = 1, y = 4

       输出: 2

       解释:
               1   (0 0 0 1)
               4   (0 1 0 0)
               ↑   ↑

       上面的箭头指出了对应二进制位不同的位置。*/
    public static int hammingDistance(int x, int y) {
        int n = x ^ y;
        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

    /*    颠倒给定的 32 位无符号整数的二进制位。



        示例 1：

        输入: 00000010100101000001111010011100
        输出: 00111001011110000010100101000000
        解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
        因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000。
        示例 2：

        输入：11111111111111111111111111111101
        输出：10111111111111111111111111111111
        解释：输入的二进制串 11111111111111111111111111111101 表示无符号整数 4294967293，
        因此返回 3221225471 其二进制表示形式为 10101111110010110010011101101001。*/
    public static int reverseBits(int n) {
        int m = 0;
        for (int i = 0; i < 32; i++) {
            m <<= 1;
            m = m + (n & 1);
            n >>= 1;
        }
        return m;
    }

    /*    给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。



        在杨辉三角中，每个数是它左上方和右上方的数的和。

        示例:

        输入: 5
        输出:
                [
                [1],
                [1,1],
                [1,2,1],
                [1,3,3,1],
                [1,4,6,4,1]
                ]*/
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list2 = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list2.add(1);
                } else {
                    list2.add(list.get(i - 1).get(j) + list.get(i - 1).get(j - 1));
                }
            }
            list.add(list2);
        }
        return list;
    }
    public int missingNumber(int[] nums) {
        int res=nums.length;
        for(int i=0;i<nums.length;i++){
            res +=(i-nums[i]);
        }
        return res;
    }
    public static boolean isValid(String s) {
        if (s == null && s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else {
                if (isfill(stack.peek(),s.charAt(i))) {
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
    public static boolean isfill(Character c1,Character c2){
        if((c1=='('&&c2==')')||(c1=='['&&c2==']')||(c1=='{'&&c2=='}')){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(hammingDistance(7, 4));
        System.out.println(reverseBits(43261596));

        generate(4);
        System.out.println(isValid("()]{}"));
    }
}
