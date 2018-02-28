/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;
        ListNode mid = findMid(head);
        ListNode leftHead = head, rightHead = mid.next;
        mid.next = null;
        merge(leftHead, reverse(rightHead));
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        /*
        // recursive may cause stackoverflow
        ListNode newHead = reverse(head.next);
        head.next.next = head; // 1
        head.next = null; //2
        return newHead;
        */
        ListNode pre = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    
    private void merge(ListNode l1, ListNode l2) {
        // dummy
        /*
        ListNode dummy = new Node(0);
        ListNode cur = dummy, cur1 = l1, cur2 = l2;
        */
        // no dummy, because return void
        ListNode cur1 = l1, cur2 = l2, next1 = null, next2 = null;
        while (cur1 != null && cur2 != null) {
            next1 = cur1.next; //1 save next node(next1) of cur1
            cur1.next = cur2;  //2 make cur1 point to cur2
            next2 = cur2.next; //3 save next node(next2) of cur2
            cur2.next = next1; //4 make cur2 point to the saved next1
            cur2 = next2;      //5 cur2 move forward
            cur1 = next1;      //6 cur1 move forward
        }
        // cur1 sometimes will have one more but does not matter
    }
​
    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 1 2 3 4 5 6; even
        // 1,1 2,3 3,5 4,null, return 3(pre)
        // 1 2 3 4 5 6 7; odd
        // 1,1 2,3 3,5 4,7, return 4(slow)
        if (fast != null) return slow;
        else return pre;
    }
​
}
​
