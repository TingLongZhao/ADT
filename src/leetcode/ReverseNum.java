package leetcode;

/*给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。*/
public class ReverseNum {
    static int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int temp = res * 10 + x % 10;
            if (temp / 10 != res) {
                return 0;
            }
            res = temp;
            x /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.print(reverse(123));
    }
}
