package leetcode;

import java.util.*;

public class IntersectArray {
    public int[] intersect(int[] nums1, int[] nums2) {
        boolean[] arr = new boolean[nums2.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]&&arr[j]==false) {
                    list.add(nums2[j]);
                    arr[j] = true;
                    break;
                }
            }
        }
        int [] arrResult = new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            arrResult[i] = list.get(i);
        }
        return arrResult;
    }
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0,j=0; i< nums1.length && j<nums2.length;) {
            if(nums1[i]==nums2[j]){
                list.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                i++;
            }
        }
        int [] arrResult = new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            arrResult[i] = list.get(i);
        }
        return arrResult;
    }
    public int[] intersect3(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums1.length; i++) {
            Integer val = map.get(nums1[i]);
            map.put(nums1[i],map.get(nums1[i] )== null?1:++val);
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i <nums2.length ; i++) {
            Integer val = map.get(nums2[i]);
            if(map.containsKey(nums2[i])&&val>0){
                list.add(nums2[i]);
                map.put(nums2[i],--val);
            }
        }
        int [] arrResult = new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            arrResult[i] = list.get(i);
        }
        return arrResult;
    }
    public static void main(String[] args) {
        int[] arr1 = {4,9,5};
        int[] arr2 = {9,4,9,8,4};
        int [] arr3 = new IntersectArray().intersect3(arr1,arr2);
    }
}
