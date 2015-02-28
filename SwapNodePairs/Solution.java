// Given a linked list, swap every two adjacent nodes and return its head.

// For example,
// Given 1->2->3->4, you should return the list as 2->1->4->3.

// Your algorithm should use only constant space. 
//You may not modify the values in the list, only nodes itself can be changed

/**
 * Definition for singly-linked list.*/
 public class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
        val = x;
        next = null;
   }
 }
 
public class Solution {

    
    //solution two, use constant space
    // the pointer can be tricky, remember that pointer points to the address of the objects, they are
    // not the address themself, once the pointer change the object it points to, the previous objects 
    //still there! whether they will be garbaged collected depends on if there is some new pointer
    //points to it.
    public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode point = new ListNode(0);//because the head will be changed, so define a dummy header
        point.next = head;
        head = point;// point.next=head, point.next.next = head.next
        while(point.next != null && point.next.next != null) {
            ListNode tmp = point.next.next.next;//head.next.next
            point.next.next.next = point.next;//2->next==1
            point.next = point.next.next;//head->ext=2
            point.next.next.next = tmp;//1->next = tmp=previous 2->next
            point = point.next.next;//point=previous 2 =  now 1 position
        }
        return head.next;
    }
    // my solution , recurrsion cost O(1) space
   public ListNode swapPairs(ListNode head) {
      ListNode dummy = new ListNode(-1);
      dummy.next = head;
      ListNode pointer = dummy;
      return helper(dummy, pointer).next;
    }
    public ListNode helper(ListNode root, ListNode pointer){
        if(pointer!=null && pointer.next!=null && pointer.next.next!=null){
            ListNode toSwap = pointer.next.next;
            pointer.next.next = toSwap.next;
            toSwap.next = pointer.next;
            pointer.next = toSwap;
            pointer = pointer.next.next;
            helper(root,pointer);
        }
        return root;
    }
// Tao Ge Iterative one
    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null)
            return head;
        ListNode dum = new ListNode(0);
        dum.next = head;
        ListNode p = head, prev = dum;
        while (p!=null && p.next!=null){
            ListNode first = p, second = p.next, next = second.next;
            prev.next =second;
            second.next = first;
            first.next = next;
            prev = first;
            p = next;
        }
        return dum.next;
    }
}