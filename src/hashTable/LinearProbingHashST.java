package hashTable;

import java.util.List;

public class LinearProbingHashST {
    private static final int DEFAULT_TABLE_SIZE = 10;
    private Integer [] value;
    public LinearProbingHashST(){
        this(DEFAULT_TABLE_SIZE);
    }
    public LinearProbingHashST(int size){
        value = new Integer[size];
    }
    public boolean contains(Integer x) {
        if(myhash(x)<value.length){
            Integer val = value[myhash(x)];
            if(val!=null){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    public void insert(Integer x) {
        Integer hashVal = myhash(x);
        value[hashVal] = x;

    }
    private int myhash(Integer x) {
        int hashVal = x;//hashCode()方法返回该对象的哈希码值
        hashVal %= 10;//对哈希表长度取余数
        if (hashVal < 0)
            hashVal += value.length;
        int count = 0;
        while(true){
            if(hashVal==value.length){
                hashVal = 0;
            }
            if(value[hashVal]==null&&count>=value.length){
                break;
            }else{
                hashVal++;
            }
            count ++;
        }
        return hashVal;
    }
    //下一个素数
    private static int nextPrime(int n) {
        if (n % 2 == 0)
            n++;

        for (; !isPrime(n); n += 2)
            ;

        return n;
    }

    //判断是否是素数
    private static boolean isPrime(int n) {
        if (n == 2 || n == 3)
            return true;

        if (n == 1 || n % 2 == 0)
            return false;

        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0)
                return false;

        return true;
    }
}
