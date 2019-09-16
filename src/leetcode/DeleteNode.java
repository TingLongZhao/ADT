package leetcode;
/*请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。*/
public class DeleteNode {
    static class  ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public static void deleteNode(ListNode node) {
        ListNode temp = node.next;
        node.next = temp.next;
        node.val = temp.val;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        deleteNode(node3);
    }
}
