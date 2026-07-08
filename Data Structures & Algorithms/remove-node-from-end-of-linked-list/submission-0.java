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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int counter = 1;
        ListNode node = new ListNode(0);
        ListNode prevToDelete = node;
        node.next = head;
        head = node;

        while(head!=null) {
            if(counter == n+1) {
                prevToDelete = node;
            } else if (counter > n+1) {
                prevToDelete = prevToDelete.next;
            }
            counter++;
            head = head.next;
        }

        if(counter==2) {
            return null;
        }
        prevToDelete.next = prevToDelete.next.next;

        return node.next;
    }
}
