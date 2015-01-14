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
        ListNode virtual = new ListNode(0);
        virtual.next=head;
        ListNode pointer = virtual;
        ListNode helper = virtual;
        
        int step=0;
        ListNode trial = pointer;
        int count = 0;
        while(trial.next!=null && count<=k){//it's a bit waste to try the numbers, one other solution is 
        //just try once, and get the inverse number.
            trial=trial.next;
            count++;
        }
        if(count>=k)
            step=0;
        else
            return virtual.next;
                        
        while(pointer.next!=null){
            step++;
            if(step<=k && step>=2){
                //insert pointer from virtual
                ListNode next = pointer.next.next;
                ListNode invert = pointer.next;
                pointer.next=next;
                invert.next=helper.next;
                helper.next=invert;
                if(step==k)
                {
                    helper=pointer;
                    trial = pointer;
                    count = 0;
                    while(trial.next!=null && count<=k){
                        trial=trial.next;
                        count++;
                    }
                    if(count>=k)
                    {
                        step=0;
                        continue;//do not need to go one step further
                    }
                    else
                        break;
                }
                else{
                    continue;
                }
                
            }
            pointer=pointer.next;//go one step further
        }
        return virtual.next;
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