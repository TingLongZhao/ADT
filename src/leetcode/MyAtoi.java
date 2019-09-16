package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*请你来实现一个 atoi 函数，使其能将字符串转换成整数。*/
public class MyAtoi {
    public static int myAtoi(String str) {
        if(str.isEmpty()) return 0;
        char[] ch = str.toCharArray();
        int len = str.length();
        int num = 0;
        int sign = 1;
        int base=0;
        while(num<len&&ch[num]==' ') num++;
        if(num==len) return 0;
        if(ch[num]=='+'||ch[num]=='-')
            sign = ch[num++]=='+' ? 1:-1;
        while(num<len&&ch[num]>='0'&&ch[num]<='9') {
            if(base>Integer.MAX_VALUE/10 || (base==Integer.MAX_VALUE/10&&ch[num]-'0'>Integer.MAX_VALUE%10))
                return (sign==1) ? Integer.MAX_VALUE:Integer.MIN_VALUE;
            base = 10*base + (ch[num++]-'0');
        }

        return base*sign;
    }
    public static void macthTest(String rex,String str) {

        Pattern p = Pattern.compile(rex); //编译对象
        Matcher m = p.matcher(str); //进行匹配
        while (m.find()) {
            System.out.println(m.group()); //默认是group(0)
        }
    }
    public static void main(String[] args) {
        String s = "  -42m67- ";
        System.out.println(myAtoi(s));
        macthTest("[\\+\\-]?\\d+",s);
    }
}
