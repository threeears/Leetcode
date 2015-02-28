// Given a linked list, remove the nth node from the end of list and return its head.

// For example,

//    Given linked list: 1->2->3->4->5, and n = 2.

//    After removing the second node from the end, the linked list becomes 1->2->3->5.
// Note:
// Given n will always be valid.
// Try to do this in one pass.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode faster = head;
    ListNode slower = head;
    while (n > 0 && faster != null) {
        faster = faster.next;
        n--;
    }
    // Check if has only node
    if (faster == null) return head.next; 

    while (faster.next != null) {
        faster = faster.next;
        slower = slower.next;
    }
    // Remove slower.next which is the nth form the end
    slower.next = slower.next.next;
    return head;
}
}