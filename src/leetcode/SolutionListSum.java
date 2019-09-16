package leetcode;

public class SolutionListSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = l1;
        while(l1!=null&&l2!=null){
            l1.val = l2.val+l1.val;
            if(l1.val>9){
                if(l1.next==null){
                    l1.next = new ListNode(0);
                }
                l1.next.val = l1.next.val+l1.val/10;
                l1.val = l1.val%10;
            }
            if(l2.next!=null&&l1.next==null){
                l1.next = new ListNode(0);
            }else if(l1.next!=null&&l2.next==null){
                l2.next = new ListNode(0);
            }
            l2 = l2.next;
            l1 = l1.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode l3 = new SolutionListSum().addTwoNumbers(l1,l2);
    }
}
