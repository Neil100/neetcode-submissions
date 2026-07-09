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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode l1Reverse = (l1);
        ListNode l2Reverse = (l2);

        ListNode dummy = new ListNode(0);
        ListNode sum = dummy;
        int carry = 0;
        while(l1Reverse != null || l2Reverse != null) {
            ListNode node = new ListNode(0);

            if(l1Reverse != null && l2Reverse != null) {
                node.val = l1Reverse.val + l2Reverse.val + carry;
                l1Reverse = l1Reverse.next;
                l2Reverse = l2Reverse.next;
            } else if(l1Reverse != null) {
                node.val = l1Reverse.val + carry;
                l1Reverse = l1Reverse.next;
            } else {
                node.val = l2Reverse.val + carry;
                l2Reverse = l2Reverse.next;
            }
            carry = node.val / 10;
            node.val = node.val % 10;
            

            sum.next = node;
            sum = sum.next;
        }

        if(carry==1) {
            ListNode node = new ListNode(1);
            sum.next = node;
            sum = sum.next;
        }

        return (dummy.next);
    }

    ListNode reverseNumber(ListNode l1) {
        ListNode prev = null;
        while(l1 != null) {
            ListNode temp = l1.next;
            l1.next = prev;

            prev = l1;
            l1 = temp;
        }

        return prev;
    }
}
