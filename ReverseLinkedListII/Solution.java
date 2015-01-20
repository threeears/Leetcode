// Reverse a linked list from position m to n. Do it in-place and in one-pass.

// For example:
// Given 1->2->3->4->5->NULL, m = 2 and n = 4,

// return 1->4->3->2->5->NULL.

// Note:
// Given m, n satisfy the following condition:
// 1 ≤ m ≤ n ≤ length of list.

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
	//my solution
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 0;
        if(m==n) return head;
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode p = start;
        while(p.next!=null){
            if(m<=count+1){
                //start insert p.next(the mth) in front of p;
                ListNode rptr = p.next;
                count++;// the mth do not move;
                while(rptr.next!=null && count+1<=n){
                  ListNode temp = rptr.next;
                  rptr.next = temp.next;
                  temp.next = p.next;
                  p.next = temp;
                  count++;
                }
                return start.next;
            }
            p = p.next;
            count++;
        }
        return null;
        
    }

    // from nineChapter
        public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        
        ListNode premNode = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode, postnNode = mNode.next;
        for (int i = m; i < n; i++) {
            if (postnNode == null) {
                return null;
            }
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }
        mNode.next = postnNode;
        premNode.next = nNode;
        
        return dummy.next;
    }
}