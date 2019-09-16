package leetcode;
/*给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。*/
public class IsPalindrome {
    public static boolean isPalindrome(String s) {
        char[] c = s.toCharArray();
        int start=0;
        int end=c.length-1;
        while(start<end){
            if(!Character.isLetterOrDigit(c[start])){
                start++;
            }else if(!Character.isLetterOrDigit(c[end])){
                end--;
            }else if(Character.toLowerCase(c[start++])!=Character.toLowerCase(c[end--])){
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panamaw";
        System.out.println(isPalindrome(s));
    }
}
