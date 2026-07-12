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
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(-1);
        ListNode traversal = dummy;
        boolean endLoop = false;

        while(!endLoop) {
            int small = 10000;
            int index = -1;

            for(int i=0; i<lists.length; i++) {
                if(lists[i] != null && lists[i].val < small) {
                    small = lists[i].val;
                    index = i;
                }
            }

            if(index==-1)
                break;
            traversal.next = lists[index];
            traversal = traversal.next;
            lists[index] = lists[index].next;
        }

        return dummy.next;
    }
}
