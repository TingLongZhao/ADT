package sort;

import java.util.Arrays;

public class ShellSort {

    public static void shellSort(int[] arr) {
        int i, j, r, tmp;
        // 划组排序
        for (r = arr.length / 2; r >= 1; r = r / 2) {
            for (i = r; i < arr.length; i++) {
                tmp = arr[i];
                j = i - r;
                // 一轮排序
                while (j >= 0 && tmp < arr[j]) {
                    arr[j + r] = arr[j];
                    j -= r;
                }
                arr[j + r] = tmp;
            }
            System.out.println(i + ":" + Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int[] array = {38,65,97,76,13,27,49,50};
        ShellSort ShellSort = new ShellSort();
        sort.ShellSort.shellSort(array);
    }
}
