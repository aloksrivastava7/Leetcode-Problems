/**

Problem : Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:

Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:

Input: head = [1], n = 1
Output: []

Example 3:

Input: head = [1,2], n = 1
Output: [1]

**/

//Solution :-

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
        int count = 0;
        ListNode iter = head;
        while(iter != null) {
            count++;
            iter = iter.next;
        }
        iter = head;
        if(count == 0) {
            return head;
        }
        if(n == 0) {
            while(iter.next.next != null) {
                iter = iter.next;
            }
            iter.next = null;
        }
        else {
            if(n == count) {
                head = head.next;
            }
            else {
                int i = 1;
                while(i != (count-n)) {
                    iter = iter.next;
                    i++;
                }
                iter.next = iter.next.next;
            }
        }
        return head;
    }
}
