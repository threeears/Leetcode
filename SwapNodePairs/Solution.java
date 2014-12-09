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
	public static void main(Stirng[] args){
		Solution test = new Solution();
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(3);
		ListNode four = new ListNode(4);

		one.next = two;
		two.next = three;
		three.next = four;

		test.swapPairs(ListNode head);
			
		}
	}
	//solution one, recurrsive takes space O(n)
    public ListNode swapPairs(ListNode head) {
    	// swap 1 and 2:
    	//1.next=2.next
    	//2->next = 1
    	if(head==null || head.next==null) return head;

    	ListNode pointer1;
    	pointer1 = head;
    	ListNode pointerNext = head.next;
    	swap(pointer1, pointerNext);
    	if(pointer1.next!=null)
    		swapPairs(pointer1.next);
    	return pointerNext;
        
    }
    public void swap(ListNode pointer1, Listnode pointer2){
    	pointer1.next = pointer2.next;
    	pointer2.next = pointer1;
    }
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
}
}