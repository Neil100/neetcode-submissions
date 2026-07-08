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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergeListHead, mergeList;

        if(list1 == null)
            return list2;
        if(list2 == null)
            return list1;
        if(list1.val<=list2.val) {
            mergeListHead = list1;
            mergeList = list1;
            list1 = list1.next;
        } else {
            mergeListHead = list2;
            mergeList = list2;
            list2 = list2.next;
        }

        while(list1 != null && list2 != null) {

            if(list1.val<=list2.val) {
                mergeList.next = list1;
                mergeList = list1;
                list1 = list1.next;
            } else {
                mergeList.next = list2;
                mergeList = list2;
                list2 = list2.next;
            }
        }

        if(list1!=null) {
            mergeList.next = list1;
        } else {
            mergeList.next = list2;
        }

        return mergeListHead;
    }
}