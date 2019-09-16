package leetcode;

import java.util.HashMap;
import java.util.Map;
/*给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。*/
public class RemoveNthFromEnd {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode deleteNode(ListNode head, int n) {
        if(head==null){
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        //         p先移动n个位置
        for (int i = 0; i < n; i ++){
            p = p.next;
            if(p==null){
                break;
            }
        }
        if( p == null){
            head = head.next;
            return head;
        }
//         当p达到尾部
        while(p.next != null){
            p = p.next;
            q = q.next;
        }

        q.next = q.next.next;

        return head;
    }
    /*反转链表*/

    /**
     * 方法1 循环
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode newNode = null;
        ListNode p = head;
        while(p!=null){
            ListNode tmp = p.next;
            p.next = newNode;
            newNode = p;
            p = tmp;
        }
        return newNode;
    }
    /**
     * 方法2 递归
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newNode = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        ListNode result = p;
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                p.next = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1==null){
            p.next = l2;
        }else{
            p.next = l1;
        }
        return result.next;
    }
    public static ListNode middleList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static boolean isPalindrome(ListNode head) {
        ListNode middleList = middleList(head);
        ListNode reverseList = reverseList(middleList);
        while(reverseList!=null){
            if(head.val!=reverseList.val){
                return false;
            }
            reverseList =reverseList.next;
            head = head.next;
        }
        return true;
    }
    public static boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(6);
        ListNode node8 = new ListNode(4);
        ListNode node9 = new ListNode(2);
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        /*ListNode node =  deleteNode(node1,2);*/
        /*ListNode node = reverseList2(node1);*/
        /*boolean bool = isPalindrome(node5);*/
        boolean bool = hasCycle(node1);
        System.out.println(bool);
        ListNode node = middleList(node5);
        while(node!=null){
            System.out.println(node.val);
            node = node.next;
        }
    }
}
