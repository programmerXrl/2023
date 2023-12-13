package December;

import July.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class Main13 {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head,fast = head;
        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }
        int left = 0,right = list.size() - 1;
        while (left <= right) {
            if (list.get(left) != list.get(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
