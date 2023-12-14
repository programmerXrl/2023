package December;

import July.ListNode;

public class Main14 {
    public static void main(String[] args) {

    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode nodeP = list1;
        ListNode nodeQ = list2;
        ListNode Head = new ListNode();
        ListNode cur = Head;

        while(nodeP != null && nodeQ != null) {
            if (nodeP.val <= nodeQ.val) {
                cur.next = nodeP;
                cur = cur.next;
                nodeP = nodeP.next;
            }else {
                cur.next = nodeQ;
                cur = cur.next;
                nodeQ = nodeQ.next;
            }
        }

        if (nodeP == null) cur.next = nodeQ;
        if (nodeQ == null) cur.next = nodeP;

        return Head.next;
    }
}
