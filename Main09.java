package December;

import July.ListNode;

public class Main09 {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode pre = null,cur = head,tmp = null;
        while (cur != null) {
            tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
