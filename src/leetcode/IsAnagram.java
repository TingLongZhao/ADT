package leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public static boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i <s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                Integer count = map.get(s.charAt(i));
                map.put(s.charAt(i),++count);
            }else{
                map.put(s.charAt(i),1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if(map.containsKey(t.charAt(i))){
                Integer count = map.get(t.charAt(i));
                if(count==1){
                    map.remove(t.charAt(i));
                }else {
                    map.put(t.charAt(i), --count);
                }
            }
        }
        if(map.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
    public  static boolean isAnagram2(String s, String t) {
        int[] sCounts = new int[26];
        int[] tCounts = new int[26];
        for (char ch : s.toCharArray()) {
            sCounts[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            tCounts[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sCounts[i] != tCounts[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String s= "anagram";
        String t= "nagaram";
        System.out.println(isAnagram2(s,t));
    }
}
