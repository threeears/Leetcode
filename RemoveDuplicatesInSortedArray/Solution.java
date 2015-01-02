// Given a sorted linked list, delete all duplicates such that each element appear only once.

// For example,
// Given 1->1->2, return 1->2.
// Given 1->1->2->3->3, return 1->2->3.

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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode pointer = head;
        ListNode prev=pointer;
        ListNode result = prev;
        while(pointer.next!=null){
            pointer = pointer.next;
            while(pointer!=null && pointer.val==prev.val){
                prev.next=pointer.next;
                pointer=pointer.next;
            }
            //at this point, prev one step behind pointer(might be null or not equal to prev)
            if(pointer!=null){
                prev=prev.next;
            }
            else
                break;
        }
        
        return result;
    }
}