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
        ListNode end = head;
        ListNode remove = new ListNode(0);
        remove.next=head;
        ListNode result = remove;

        int i=1;
        while(i<n){
            end = end.next;
            i++;// do not forget!!
        }
        
        while(end.next!=null){
            end=end.next;
            remove = remove.next;
        }
        ListNode temp = remove.next.next;
        remove.next = temp;
        return result.next;
    }
}