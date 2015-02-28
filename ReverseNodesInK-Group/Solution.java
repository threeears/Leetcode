// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

// If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

// You may not alter the values in the nodes, only nodes itself may be changed.

// Only constant memory is allowed.

// For example,
// Given this linked list: 1->2->3->4->5

// For k = 2, you should return: 2->1->4->3->5

// For k = 3, you should return: 3->2->1->4->5

  class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
   }
public class Solution {
    // my solution is a little waste in judging numbers ahead.
     public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pointer = dummy;
        while(pointer.next!=null){
            //1. check need to reverse of not
            if(checkReverse(pointer, k)==true){
                ListNode start = pointer.next;
                //reverse the next k element
                for(int i = 0;i<k-1;i++){
                    ListNode toSwap = start.next;
                    start.next = toSwap.next;
                    toSwap.next = pointer.next;
                    pointer.next = toSwap;
                }
                pointer = start;
            }
            else
                break;
        }
        return dummy.next;
    }
    boolean checkReverse(ListNode root, int k){
        ListNode faster= root;
        while( faster.next!=null && k>0){
            faster = faster.next;
            k--;
        }
        return k==0;
    }

//from nineChapter
      public ListNode reverseKGroup2(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(k == 0 || k == 1) return head;
        ListNode cur = head;
        int length = 0;
        while (cur != null){
            cur = cur.next;
            length++;
        }
        int multi = length / k;
        if(multi == 0) return head;
        ListNode preTail = null, curHead = null, curTail = null;
        ListNode preNode = null, nextNode = null;
        cur = head;
        for(int j = 0; j < multi; j++) {
            preNode = null;
            for(int i = 0; i < k; i++) {
                if(cur != null) {
                    nextNode = cur.next;
                    cur.next = preNode;
                    preNode = cur;
                }
                if(i == 0) curTail = cur;
                if(i == (k - 1)) curHead = cur;
                cur = nextNode;
            }
            if(preTail == null) head = curHead;
            else preTail.next = curHead;
            preTail = curTail;
        }
        curTail.next = cur;
        return head;
    }
}