package tree;

public class AVLTree<T extends Comparable> {
    private AvlNode<T> mRoot;

    // 构造函数
    public AVLTree() {
        mRoot = null;
    }

    private int height(AvlNode<T> node) {
        return node == null ? -1 : node.height;
    }

    private AvlNode<T> insert(T x, AvlNode<T> node) {
        if (node == null) {
            return new AvlNode<T>(x, null, null);
        }
        int compareResult = x.compareTo(node.t);
        if (compareResult < 0) {
            node.left = insert(x, node.left);
        } else if (compareResult > 0) {
            node.right = insert(x, node.right);
        }
        return balance(node);
    }

    public void insert(T key) {
        mRoot = insert(key, mRoot);
    }

    private static final int ALLOED_IMBALANCE = 1;

    private AvlNode<T> balance(AvlNode<T> node) {
        if (node == null) {
            return node;
        }
        if (height(node.left) - height(node.right) > ALLOED_IMBALANCE) {
            if (height(node.left.left) >= height(node.left.right)) {
                node = rotateWithLeftChild(node);
            } else {
                node = doubleWithLeftChild(node);
            }
        } else if (height(node.right) - height(node.left) > ALLOED_IMBALANCE) {
            if (height(node.right.right) >= height(node.right.left)) {
                node = rotateWithRightChild(node);
            } else {
                node = doubleWithRightChild(node);
            }
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private AvlNode<T> rotateWithRightChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.right;
        k2.right = k1.left;
        k1.left = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    private AvlNode<T> doubleWithRightChild(AvlNode<T> k3) {
        k3.right = rotateWithLeftChild(k3.right);
        return rotateWithRightChild(k3);
    }

    private AvlNode<T> findMin(AvlNode<T> node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    private AvlNode<T> remove(T x, AvlNode<T> node) {
        int compareResult = x.compareTo(node.t);
        if (compareResult < 0) {
            node.left = remove(x, node.left);
        } else if (compareResult > 0) {
            node.right = remove(x, node.right);
        } else if (node.left != null && node.right != null) {
            node.t = findMin(node.right).t;
            node.right = remove(node.t, node.right);
        } else {
            node = (node.left != null) ? node.left : node.right;
        }
        return balance(node);
    }

    public AvlNode<T> get(T x, AvlNode<T> node) {
        int compareResult = x.compareTo(node.t);
        AvlNode<T> newNode = node;
        if (compareResult < 0) {
            newNode = get(x, node.left);
        } else if (compareResult > 0) {
            newNode = get(x, node.right);
        } else {
            return newNode;
        }
        return newNode;
    }

    public AvlNode<T> get(T x) {
       return get(x, mRoot);
    }

    public void remove(T x) {
        remove(x, mRoot);
    }

    /*
     * 中序遍历"AVL树"
     */
    private void inOrder(AvlNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.println(tree.t + " ");
            inOrder(tree.right);
        }
    }

    public void inOrder() {
        inOrder(mRoot);
    }

    private static int arr[] = {3, 2, 1, 4, 5, 6, 7, 16, 15, 14, 13, 12, 11, 10, 8, 9};

    public static void main(String[] args) {
        int i;
        AVLTree<Integer> tree = new AVLTree<Integer>();

        System.out.printf("== 依次添加: ");
        for (i = 0; i < arr.length; i++) {
            System.out.printf("%d ", arr[i]);
            tree.insert(arr[i]);
        }
        System.out.printf("\n== 中序遍历: ");
        tree.inOrder();
        tree.remove(11);
        System.out.println("\n== 中序遍历: ");
        tree.inOrder();
        System.out.println(tree.get(3).t);
    }
}
