package leetcode;
/*给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。*/
public class StrStr {
    public static int strStr(String haystack, String needle) {
        int index = haystack.indexOf(needle);
        return index;
    }

    public static void main(String[] args) {
        String s1 = "hello";
        String s2 = "lls";
        System.out.println(strStr(s1,s2));
    }
}
