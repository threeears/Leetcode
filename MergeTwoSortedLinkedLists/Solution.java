// Merge two sorted linked lists and return it as a new list. 
//The new list should be made by splicing together the nodes of the first two lists.

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode res = head;
        int i = 0;
        int j = 0;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                head.next=l1;
                l1=l1.next;
                i++;
            }
            else{
                head.next=l2;
                l2=l2.next;
                j++;
            }
            head=head.next;
        }
        if(l1==null){
            head.next=l2;
        }
        else{
            head.next=l1;
        }
        
        return res.next;
    }
}