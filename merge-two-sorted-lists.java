/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /*
    // dummy
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                node.next = l1;    
                l1 = l1.next;
            }
            else {
                node.next = l2;    
                l2 = l2.next;
            }
            node = node.next;
        }
        node.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
    */
    
    // non-dummy, first determine head then do while
    /*
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            ListNode head = null, cur1 = l1, cur2 = l2;
            if (l1.val < l2.val) {
                head = l1;
                cur1 = cur1.next;
            }
            else {
                head = l2;
                cur2 = cur2.next;
            } 
            ListNode cur = head;
            while (cur1 != null && cur2 != null) {
                //System.out.print(cur.val + " ");
                if (cur1.val < cur2.val) {
                    cur.next = cur1;
                    cur1 = cur1.next;
                }
                else {
                    cur.next = cur2;
                    cur2 = cur2.next;
                }
                cur = cur.next;
            }
            cur.next = (cur1 == null ? cur2 : cur1);
            return head;
    }
    */
    
    // recursive
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
​
