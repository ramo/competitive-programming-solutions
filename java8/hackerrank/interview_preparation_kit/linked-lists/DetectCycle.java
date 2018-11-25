/**
 *
 * https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=linked-lists
 */


// Note: For this problem in hackerrank editor we were shown only the below function and 
// for some reason rest of the stub code is not shown.


/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
    if (head == null) {
        return false;
    }
    
    // Take two pointers slow travels one node at a time
    // fast travels two node at a time
    // As per Floyd's algo for cycle detection this pointers will meet
    // if there exist a cycle.
    Node slow = head;
    Node fast = head;
    
    boolean result = false;
    while (slow != null && fast != null) {
        slow = slow.next;
        if (fast.next != null) {
            fast = fast.next.next;
        }
        if (slow == fast) {
            result = true;
            break;
        }
    }
    
    return result;
}