package leetcode.math;

public class CountPrimes {
    /**
     * 判断是否为素数/质数的常规方法
     * @param num
     * @return
     */
    public static boolean isPrimeNormal(int num) {
        if(num<2){
            return false;
        }
        for(int i=2; i<num; i++) {
            if(num%i == 0) {
                return false;
            }
        }
        return true;
    }
    public static int countPrimes(int n) {
        int count = 0;
        boolean[] signs = new boolean[n];
        for (int i = 2; i < n; i++)
        {
            if (!signs[i])
            {
                count++;
                for (int j = i + i; j < n; j += i)
                {
                    //排除不是质数的数
                    signs[j] = true;
                }
            }
        }
        return count;
    }
    public static boolean isPowerOfThree(int n) {
        while(n/3>=1&&(n%3>3||n%3==0)){
            n = n/3;

        }
        return n==1;
    }
    public static boolean isPowerOfThree2(int n) {
        return Integer.toString(n, 3).matches("^10*$");
    }
    public int romanToInt(String s) {

        int n = s.length();
        int r_int = 0;
        for(int i=0; i<n; i++)
        {
            switch(s.charAt(i))
            {
                case 'I' :r_int += 1; break;
                case 'V' :r_int += 5; break;
                case 'X' :r_int += 10; break;
                case 'L' :r_int += 50; break;
                case 'C' :r_int += 100; break;
                case 'D' :r_int += 500; break;
                case 'M' :r_int += 1000; break;
                default: System.out.println("default"); break;
            }

            //特殊条件
            if(i!=0)
            {
                if(((s.charAt(i) == 'V') || (s.charAt(i) == 'X')) && (s.charAt(i-1) == 'I'))
                    r_int = r_int-1*2; //因为之前+1,所以后面要减2倍

                if(((s.charAt(i) == 'L') || (s.charAt(i) == 'C')) && (s.charAt(i-1) == 'X'))
                    r_int = r_int-10*2;

                if(((s.charAt(i) == 'D') || (s.charAt(i) == 'M')) && (s.charAt(i-1) == 'C'))
                    r_int = r_int-100*2;
            }
        }

        return r_int;
    }
    public static void main(String[] args) {
        System.out.println(isPowerOfThree2(45));
    }
}
