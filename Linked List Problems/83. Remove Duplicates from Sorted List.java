/**
Problem :- Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.

Example 1:

Input: head = [1,1,2]
Output: [1,2]

Example 2:

Input: head = [1,1,2,3,3]
Output: [1,2,3]
**/

// Solution :-

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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = head;
        if(head == null) {  // For Empty LinkedList return null
            start = null;
        }
        else {
            while(head.next != null) {
                if(head.val != head.next.val) {  // Compares values at the current index and at the next index
                    head = head.next;  // Disconnecting the second index if both are same
                }
                else 
                   head.next = head.next.next;     
            }
        }
        return start;
    }
}

/**
Approach :- 
* It checks the val at the current node and the next node and if they are same, interchanges references of the current node and the next node such that the next node is deleted 
  (as both of them were having same value -- duplicates). 
**/

