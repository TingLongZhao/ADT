package tree;

public class AvlNode<T extends Comparable> {
    T t;
    AvlNode<T> left;
    AvlNode<T> right;
    int height;// 根结点
    AvlNode(T thidT, AvlNode<T> lt, AvlNode<T> rt) {
        t = thidT;
        left = lt;
        right = rt;
        height = 0;
    }

    AvlNode(T thisT) {
        this(thisT, null, null);
    }


}
