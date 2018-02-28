/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head; 
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
             odd.next = odd.next.next;   // 1 next odd node
             even.next = even.next.next; // 2 next even node
             odd = odd.next;             // 3 move forward odd
             even = even.next;           // 4 move forward even
        }
        odd.next = evenHead;            // at last put even after odd
        return head;
    }
}
​
