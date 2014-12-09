// Given a list, rotate the list to the right by k places, where k is non-negative.

// For example:
// Given 1->2->3->4->5->NULL and k = 2,
// return 4->5->1->2->3->NULL.

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
    public ListNode rotateRight(ListNode head, int n) {
    	if(head==null) return head;
    	ListNode cycleStart=head;
    	int num = 0;
    	while(head!=null){
    		head=head.next;
    		num++;
    	}
    	header.next = cycleStart;


    	if(n!=0){
	    	for(int i=0;i<n;i++){
	    		cycleStart = cycleStart.next;
	    	}
   		 }
   		 
    	ListNode result = cycleStart.next;
    	cycleStart.next = null;

    	return result;
        
    }
}