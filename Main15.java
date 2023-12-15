package December;

import July.ListNode;

public class Main15 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        head.next = head2; head2.next = head3;
        Main15 tool = new Main15();
        Helper.printListNode(tool.removeNthFromEnd(head,2));
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        int sum = 0;
        ListNode cur = head;
        if (head == null) return null;
        while (cur != null) {
            sum++;
            cur = cur.next;
        }
        System.out.println(sum);
        if (n > sum || n == sum) return head.next;

        cur = head;
        while (count++ < sum - n - 1) {
            cur = cur.next;
        }
        if (cur.next == null || cur.next.next == null) {
            cur.next = null;
        }else {
            cur.next = cur.next.next;
        }
        return head;
    }
}
