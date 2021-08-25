/**
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Notice that you should not modify the linked list.

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: tail connects to node index 1
Explanation: There is a cycle in the linked list, where tail connects to the second node.

Example 2:

Input: head = [1,2], pos = 0
Output: tail connects to node index 0
Explanation: There is a cycle in the linked list, where tail connects to the first node.

Example 3:

Input: head = [1], pos = -1
Output: no cycle
Explanation: There is no cycle in the linked list.
 
**/

#Solution

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
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode slower = head;
        ListNode faster = head;
        while(faster.next != null && faster.next.next != null) {
            faster = faster.next.next;
            slower = slower.next;
            if(faster == slower) {
                while(head != slower){
                    head = head.next;
                    slower = slower.next;
                }
                return slower;
            }
        }
        return null;
    }
}

#Approach
/**
* Here we will first find out the node where both the slower and faster references meet.
* Let the distance between the head node and the node where cycle starts be A.
* Let the distance travelled by slower from the point where cycle begins in order to reach the point where it meets with faster be B. then the total distance travelled by slower before it meets with be is ---- A + B + cN where c is the length of cycle and N is the number of cycles it takes to meet with faster.
* therefore the distance travelled by faster will be --- 2A + 2B
* Equating them together we'll get --- 2A + 2B = A + B + cN
* => A + B = cN
* => A = cN - B
* This shows that the distance from the head to the point where cycle begins (A) is the same as the distance that slower can move in order to reach the same point.
* Therefore we move the head forward one step at a time and on the other hand we also move the slower one step to reach a point where both of them meet.
* This point will always indicate the node where the cycle begins,,,
**/
