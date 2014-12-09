// Given a linked list and a value x, 
//partition it such that all nodes less than x come before nodes greater than or equal to x.

// You should preserve the original relative order of the nodes in each of the two partitions.

// For example,
// Given 1->4->3->2->5->2 and x = 3,
// return 1->2->2->4->3->5.
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
/**
 */

   class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
 
public class Solution {
	public static void main(String[] args){
		Solution test = new Solution();
		ListNode head = new ListNode(1);
		ListNode one = new ListNode(4);

		ListNode two = new ListNode(3);
		ListNode three = new ListNode(2);
		ListNode four = new ListNode(5);
		ListNode five = new ListNode(2);

		head.next = one;
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;

		head = test.partition(head, 3);
		while(head!=null){
			System.out.println(head.val);
			head = head.next;
		}
	}

	// my strategy: create two new lists, one stores smaller, the other stores larger, and 
	// combine them together as a whole
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(0);
        ListNode larger = new ListNode(0);
        ListNode pointer1 = smaller;
        ListNode pointer2 = larger;
        
        if(head==null) return head;

        while(head!=null){
        	if(head.val<x){
        		ListNode temp = new ListNode(head.val);
        		add(temp, smaller);
        		smaller = smaller.next;
        	}
        	else{
        		ListNode temp = new ListNode(head.val);
        		add(temp,larger);
        		larger = larger.next;
        	}
        	head = head.next;
        }
        smaller.next = pointer2.next;
        return pointer1.next;
    }
    public void add(ListNode node, ListNode list){
    	list.next = node;
    	list.next.next = null;
    }
    	

    	// better ,save space compared to mine, same principle 
    	 public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy, right = rightDummy;
        
        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = head;
            } else {
                right.next = head;
                right = head;
            }
            head = head.next;
        }
        
        right.next = null;
        left.next = rightDummy.next;
        return leftDummy.next;
    }	
}