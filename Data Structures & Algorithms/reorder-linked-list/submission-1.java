/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        ListNode fast, slow;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        slow = dummy;
        fast = dummy;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            fast = fast.next;            
        }
        System.out.println(slow.val);
        ListNode current = slow.next, previous = null;

        while(current != null) {
            ListNode next = current.next;
            current.next = previous;

            previous = current;
            current = next;
        }

        ListNode last = previous;
        ListNode start = dummy.next;
        while(last!=null) {
            ListNode startNext = start.next;
            start.next = last;
            ListNode lastNext = last.next;
            last.next = startNext;
            start = startNext;
            last = lastNext;
        }
        start.next = null;
    }
}
