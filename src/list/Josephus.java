package list;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Josephus {
    public static void pass(int m, int n)
    {
        int i, j, mPrime, numLeft;
        ArrayList<Integer> L = new ArrayList<Integer>();
        //  为队列中的成员编号：从1~n
        for (i=1; i<=n; i++)
            L.add(i);
        //  初始化各个元素
        ListIterator<Integer> iter = L.listIterator();
        Integer item=0;
        numLeft = n;
        mPrime = m % n;
        //  进行n此循环，每次删除一个成员
        for (i=0; i<n; i++)
        {
            mPrime = m % numLeft;
            if (mPrime <= numLeft/2)    //   当mPrime小于剩余人数的一般时，进行正移。（向后移next）
            {
                if (iter.hasNext())
                    item = iter.next();
                for (j=0; j<mPrime; j++)
                {
                    if (!iter.hasNext())
                        iter = L.listIterator();
                    item = iter.next();
                }
            }
            else
            {
                for (j=0; j<numLeft-mPrime; j++)    // 当mPrime大于剩余的一般人数时，进行反移。（向前移previous）
                {
                    if (!iter.hasPrevious())
                        iter = L.listIterator(L.size());
                    item = iter.previous();
                }
            }
            System.out.print("Removed " + item + " ");
            iter.remove();
            if (!iter.hasNext())
                iter = L.listIterator();
            System.out.println();
            for (Integer x:L)            // 利用增强for循环遍历表
                System.out.print(x + " ");
            System.out.println();
            numLeft--;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n;
        m = sc.nextInt();
        n = sc.nextInt();
        pass(m, n);    //  注意这里的m为传递次数，要与报数次数区分开.即：传递次数 = 报数次数-1.
    }
}
