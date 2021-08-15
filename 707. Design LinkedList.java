/**
Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement the MyLinkedList class:

* MyLinkedList() Initializes the MyLinkedList object.
* int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
* void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
* void addAtTail(int val) Append a node of value val as the last element of the linked list.
* void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
* void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 

Example 1:

Input
["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
[[], [1], [3], [1, 2], [1], [1], [1]]
Output
[null, null, null, null, 2, null, 3]

Explanation
MyLinkedList myLinkedList = new MyLinkedList();
myLinkedList.addAtHead(1);
myLinkedList.addAtTail(3);
myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
myLinkedList.get(1);              // return 2
myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
myLinkedList.get(1);              // return 3
**/

// Solution :-

class MyLinkedList {
    static class SinglyListNode {
        int val;
        SinglyListNode next;
        public SinglyListNode(int val) {
            this.val = val;
            next = null;
        }
    }
    
    SinglyListNode head;
    int count;
    /** Initialize your data structure here. */
    public MyLinkedList() {
        head = null;
        this.count = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        SinglyListNode current = head; 
        if(index < 0 || index >= count) {
            return -1;
        }
        int c = 0;
        while(c != index) {
            c++;
            current = current.next;
        }
        return current.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        SinglyListNode newNode = new SinglyListNode(val);
        if(count != 0) {
            newNode.next = head;
        }
        head = newNode;
        count++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(count == 0) {
            addAtHead(val);
            return;
        }
        else {
            SinglyListNode newNode = new SinglyListNode(val);
            SinglyListNode current = head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        count++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > count) {
            return;
        }
        if(index == 0) {
            addAtHead(val);
            return;
        }
        else {
            if(index == count) {
                addAtTail(val);
                return;
            }
            else {
                SinglyListNode newNode = new SinglyListNode(val);
                 int c = 0;
                SinglyListNode current = head;
                while (c != (index-1)) {  
                    current = current.next;
                    c++;
                }
                newNode.next = current.next;
                current.next = newNode;
                count++; 
            }
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= count) {
            return;
        }
        if(index == 0) {
            head = head.next;
            count--;
        }
        else {
            if(index == count) {
                SinglyListNode current = head;
                while(current.next != null) {  
                    current = current.next;
                }
                current.next = null;  
                count--;  // Node deleted...
            }
            else {
                int c = 0;
                SinglyListNode current = head;
                while(c != (index-1)) { 
                    c++;
                    current = current.next;
                }
                current.next = current.next.next;  
                count--;
            }   
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

