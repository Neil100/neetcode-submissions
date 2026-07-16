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
    public ListNode reverseKGroup(ListNode head, int k) {

        if(k==1)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode start, end, prev, next;

        prev = dummy;
        start = dummy.next;
        end = start;
        int counter = 1;

        while(end != null) {

            if(counter==k) {
                next = end.next;
                end.next = null;

                reverseList(start);

                start.next = next;
                prev.next = end;

                prev = start;
                start = next;
                end = next;
                counter = 1;
            } else {
                counter++;
                end = end.next;
            }
        }

        return dummy.next;
    }

    void reverseList(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        while(head!=null) {
            ListNode next = head.next;
            head.next = dummy;
            dummy = head;
            head = next;
        }
    }
}
