package leetcode;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }else if(strs.length==1){
            return strs[0];
        }
        int i = 1;
        String s = strs[i-1];
        while(i<strs.length){
            s = longestCommonPrefixOfTwoString(s,strs[i]);
            i++;
        }
        return s;
    }
    public static String longestCommonPrefixOfTwoString(String s1,String s2){
        String s = "";
        int k = 0;
        while(k<s1.length()&&k<s2.length()){
            if(s1.charAt(k)==s2.charAt(k)){
                s += s1.charAt(k);
                k++;
            }else{
                break;
            }
        }
        return s;
    }
    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String min = strs[0] ;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].isEmpty()) {
                return "";
            }
            if (strs[0].charAt(0) != strs[i].charAt(0)) {
                return "";
            }
            if (strs[i].length() <= min.length()) {
                min = strs[i];
            }
        }
        for (int i = 0; i < strs.length; i++) {
            if (min.equals(strs[i])) {
                continue;
            }
            for (int j = min.length()-1; j > 0 ; j--) {
                if (min.charAt(j) != strs[i].charAt(j)) {
                    min = min.substring(0, j);
                }
            }
        }
        return min;
    }
    public static void main(String[] args) {
        String s1 = "flower";
        String s2 = "flow";
        String[] arr = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix2(arr));
    }
}
