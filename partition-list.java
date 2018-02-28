/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);
        ListNode c1 = dummy1, c2 = dummy2, cur = head;
        while (cur != null) {
            if (cur.val < x) {
                c1.next = cur;
                c1 = c1.next;
            }
            else {
                c2.next = cur;
                c2 = c2.next;
            }
            cur = cur.next;
        }
        c1.next = dummy2.next;
        c2.next = null;
        return dummy1.next;
    }
}
​
