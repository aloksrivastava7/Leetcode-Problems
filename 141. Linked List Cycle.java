/**
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
*/

// Solution :-

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) {
            return false;
        }
        ListNode slower = head;
        ListNode faster = head;
        while(faster.next != null && faster.next.next != null) {
            faster = faster.next.next;
            slower = slower.next;
            if(slower == faster) {
                return true;
            }
        }
        return false;
    }
}

/**
Key Points :- 
* head == null : List is empty -- therefore no cycles are present inside it
* slower : a pointer which moves one step at a time
* faster : a pointer which moves two steps at a time
* (faster.next == null || faster.next.next != null) : This will mean that we have reached to the last or the second last node of the linkedlist and since we are able to reach the 
   end of the linkedlist, this makes it clear that there are no cycles present.....
* Now, since faster mover two steps in comparison to every single step moved by the slower and if there is a cycle present inside the linkedlist then both of them will definitely 
  meet at a point that's what we'll check for --- whether they are going to meet each other or the faster reference is going to reach the end of the linkedlist.
**/
