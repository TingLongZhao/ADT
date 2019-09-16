package leetcode.sortAndsearch;

public class Mergesort {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] tmp = new int[m+n];
            int k =0;
            int i =0;
            int j=0;
            while(i<m&&j<n){
                if(nums1[i]>nums2[j]){
                    tmp[k++] = nums2[j++];
                }else{
                    tmp[k++] = nums1[i++];
                }
            }
        // 把左边剩余的数移入数组
        while(i<m){
            tmp[k++] = nums1[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<n){
            tmp[k++] = nums2[j++];
        }
        for (int l = 0; l <m+n; l++) {
            nums1[l] = tmp[l];
        }
    }
}
