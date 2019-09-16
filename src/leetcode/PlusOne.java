package leetcode;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length-1; i >=0 ; i--) {
            if (carry == 0) {
                return digits;
            }
            int temp = digits[i] + carry;
            carry = temp/10;
            digits[i] = temp%10;
        }
        if(carry !=0){
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            return result;
        }
    return digits;
    }

    public static void main(String[] args) {
        int[] arr = {9,9,9};
        int[] a = new PlusOne().plusOne(arr);
        for (int i = 0; i <a.length; i++) {
            System.out.print(a[i]);
        }
    }
}
