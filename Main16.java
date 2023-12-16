package December;

import July.ListNode;

public class Main16 {
    private static final Helper helper = new Helper();
    public static void main(String[] args) {
        Main16 tool = new Main16();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        helper.printListNode(tool.swapPairs(head));
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur != null) {
            if (cur.next == null || cur.next.next == null) break;
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;
            cur.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            cur = node1;
        }
        return dummyHead.next;
    }
}
