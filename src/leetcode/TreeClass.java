package leetcode;

import java.util.ArrayList;
import java.util.List;

public class TreeClass {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public static int maxDepth(TreeNode root) {
        int max=0;//存储子树的深度
        int leftMax=0;
        int rightMax=0;
        if (root != null) {//如果当前子树不为空,非空树
            max++;//深度加1
            leftMax = maxDepth(root.left);//左子树深度
            rightMax = maxDepth(root.right);//右子树深度
            max += leftMax >= rightMax ? leftMax : rightMax;//当前子树的深度
        }
        return max;//返回当前子树的深度
    }
    public static void minOrder(TreeNode root,List<Integer> list){
        if(root!=null) {
            minOrder(root.left,list);
            list.add(root.val);
            minOrder(root.right,list);
        }

    }
    public static List<Integer> list = new ArrayList<>();
    public static List<Integer> list2 = new ArrayList<>();
    public static boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        minOrder(root,list);
        if(list.size()==1){
            return true;
        }
        for (int i = 0; i < list.size()-1; i++) {
            if(list.get(i)>=list.get(i+1)){
                return false;
            }
        }
        return true;
    }
/*    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        minOrder(root.left,list);
        minOrder(root.right,list2);
        if(list.size()!=list2.size()){
            return false;
        }
        for (int i = 0,j = list2.size()-1; i <list.size()&&j>=0 ; i++,j--) {
            if(list.get(i)!=list2.get(j)){
                return false;
            }
        }
        return true;
    }*/
public static boolean isSymmetric(TreeNode root) {
    if (root == null) return true;
    return isMirror(root.left, root.right);
}

    private static boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null) return right == null;
        if (right == null) return left == null;
        return left.val == right.val
                && isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }
    /*static double last = -Double.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (isValidBST(root.left)) {
            if (last < root.val) {
                last = root.val;
                return isValidBST(root.right);
            }
        }
        return false;
    }*/
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        TreeNode node7 = new TreeNode(3);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(isSymmetric(new TreeNode(1)));
    }
}
