package sort;

import heap.MaxHeap;

public class HeapSort {
    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    private static <T extends Comparable<T>> void perDown(T[] a, int i, int n) {
        int child = 0;
        T temp;
        for (temp = a[i]; leftChild(i) < n; i = child) {
            child = leftChild(i);
            if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0) {
                child++;
            }
            if (temp.compareTo(a[child]) < 0) {
                a[i] = a[child];
            } else {
                break;
            }
        }
        a[i] = temp;
    }
public static<T extends Comparable<T>> void heapSort(T[] a){
        for (int i=a.length/2-1;i>=0;i--){
            perDown(a,i,a.length);
        }
        for (int i = a.length-1;i>0;i--){
            T temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            perDown(a,0,i);
        }
}
    public static void main(String[] args) {
        Integer[] A = {3, 7, 2, 11, 3, 4, 9, 2, 18, 0};
        heapSort(A);
        System.out.println(A.toString());
    }
}
