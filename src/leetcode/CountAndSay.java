package leetcode;
/*报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：

        1.     1
        2.     11
        3.     21
        4.     1211
        5.     111221
        1 被读作  "one 1"  ("一个一") , 即 11。
        11 被读作 "two 1s" ("两个一"）, 即 21。
        21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。

        给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。

        注意：整数顺序将表示为一个字符串。*/
public class CountAndSay {
    public static String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        //递归调用，然后对字符串处理
        String str = countAndSay(n-1) + "*";//为了str末尾的标记，方便循环读数
        char[] c = str.toCharArray();
        int count = 1;
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < c.length - 1;i++){
            if(c[i] == c[i+1]){
                count++;//计数增加
            }else{
                //s.append(s);
                s.append("" + count + c[i]);//上面的*标记这里方便统一处理
                count = 1;//初始化
            }
        }
        return s.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
