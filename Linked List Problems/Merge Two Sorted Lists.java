/**

Problem :-You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:

Input: list1 = [], list2 = []
Output: []

Example 3:

Input: list1 = [], list2 = [0]
Output: [0]

**/

// Solution :-

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode head = dummy;
         while(l1 != null && l2 != null) {
             if(l2.val > l1.val) {
                 dummy.next = l1;
                 l1 = l1.next;
             }
             else {
                 dummy.next = l2;
                 l2 = l2.next;
             }
             dummy = dummy.next;
         }
        if(l1 == null) {
            while(l2 != null) {
                dummy.next = l2;
                l2 = l2.next;
                dummy = dummy.next;
            }
        }
        if(l2 == null) {
            while(l1 != null) {
                dummy.next = l1;
                l1 = l1.next;
                dummy = dummy.next;
            }
        }
        return head.next;
    }
}

