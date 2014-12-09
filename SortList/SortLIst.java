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
		ListNode head = new ListNode(2);
		ListNode first = new ListNode(1);
		
		head.next = first;
		ListNode result = test.sortList(head);
		System.out.println(result.val);
		while(result.next!=null){
			System.out.println(result.next.val);
			result = result.next;
		}
		
	}
    public ListNode sortList(ListNode head) {
    	ListNode copy = head;
    	if(head==null || head.next==null) return head;

        int num = 0;
        while(head!=null){
        	num++;
        	head=head.next;
        }

        ListNode left=copy;
        ListNode right;
        for(int i = 0;i<num/2-1;i++){  	
        	left=left.next;
        }
        ListNode mid = left.next;// copy on reference, once, left changed, copy is changed also
        
        
        right = sortList(mid);//
        left.next = null;
        left = sortList(copy);//

        head = Merge(left, right);
        
        return head;
    }

   public  ListNode Merge(ListNode left, ListNode right){
   		ListNode dummy = new ListNode(0);
    	ListNode header = left;


    	if(left.val>right.val){
    		header=right;
    		right=right.next;
    	}
    	else left = left.next;
   		dummy.next = header;

    	while(left!=null && right!=null){
    		if(left.val < right.val){
    			header.next = left;
    			left = left.next;
    		}
    		else {
    			header.next = right;
    			right = right.next;
    		}
    		header = header.next;
    	
    	}

    	if(left==null && right!=null){
    		header.next=right;
    	}
    	if(left!=null && right==null){
    		header.next = left;
    	}
        
    	return dummy.next;
    }

	    private ListNode findMiddle(ListNode head) {
	        ListNode slow = head, fast = head.next;
	        while (fast != null && fast.next != null) {
	            fast = fast.next.next;
	            slow = slow.next;
	        }
	        return slow;
	    }    

	    private ListNode merge2(ListNode head1, ListNode head2) {
	        ListNode dummy = new ListNode(0);
	        ListNode tail = dummy;
	        while (head1 != null && head2 != null) {
	            if (head1.val < head2.val) {
	                tail.next = head1;
	                head1 = head1.next;
	            } else {
	                tail.next = head2;
	                head2 = head2.next;
	            }
	            tail = tail.next;
	        }
	        if (head1 != null) {
	            tail.next = head1;
	        } else {
	            tail.next = head2;
	        }

	        return dummy.next;
	    }

	    public ListNode sortList2(ListNode head) {
	        if (head == null || head.next == null) {
	            return head;
	        }

	        ListNode mid = findMiddle(head);

	        ListNode right = sortList(mid.next);
	        mid.next = null;
	        ListNode left = sortList(head);

	        return merge2(left, right);
	    }
	}


