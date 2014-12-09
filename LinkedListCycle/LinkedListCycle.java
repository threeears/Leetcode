// Given a linked list, determine if it has a cycle in it.

// Follow up:
// Can you solve it without using extra space?
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
    public class Solution {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> map=new HashMap<ListNode, Integer>();
        if(head==null) return false;
        
    	while(head.next!=null){
    		if(map.containsKey(head.next)){
    			return true;
    		}
    		else{
    		    map.put(head.next, head.val);
    		    head=head.next;
    		}
    	}

    	return false;
    }
}
 //O(n)

 public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
 
        if(head == null)
            return false;
 
        if(head.next == null)
            return false;
 
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
 
            if(slow == fast)
                return true;
        }
 
        return false;
    }
}
// idea is use fast and low pointer, when a cylce is located, faster one will catch the 
//slow one for sure
