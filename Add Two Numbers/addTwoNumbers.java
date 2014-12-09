/*You are given two linked lists representing two non-negative numbers. 
*The digits are stored in reverse order and each of their nodes contain a single digit. 
*Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/

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

//O(l1+l2),spacd O(l1+l2);
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	List<ListNode> result=new ArrayList<ListNode>();
    	ListNode p1 = l1;
    	ListNode p2 = l2;
    	int flag = 0;
        while(p1!=null || p2!=null){
        	int value = 0;
        	if(p1!=null && p2 !=null){
	        	value= (p1.val + p2.val+flag)<10?(p1.val + p2.val)+flag:(p1.val + p2.val-10+flag);
	        	flag = (p1.val + p2.val)+flag<10?0:1;
	        	p1=p1.next;
	        	p2=p2.next;
        	}
        	else if(p1!=null && p2==null){
	        	value= (p1.val +flag)<10?(p1.val )+flag:(p1.val -10+flag);
	        	flag = (p1.val )+flag<10?0:1;
	        	p1=p1.next;
        	}
        	else if(p1==null && p2!=null){
        		value= (p2.val +flag)<10?(p2.val )+flag:(p2.val -10+flag);
	        	flag = (p2.val )+flag<10?0:1;
	        	p2=p2.next;
        	}
        		
//        	System.out.println("flag: "+flag);
//        	System.out.println("value:" + value);
        	ListNode temp = new ListNode(value);
        	result.add(temp);
        	if(result.size()>=2)
        		result.get(result.size()-2).next = result.get(result.size()-1);

        	
        }
        
       
       if(flag==1){
        	ListNode last = new ListNode(1);
        	result.add(last);
        	if(result.size()>=2)
        	{
          	  result.get(result.size()-2).next = result.get(result.size()-1);
        	}
        }
        return result.get(0);
    }

// By jiuzhang, not examined yet.
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
            
        ListNode head = new ListNode(0);
        ListNode point = head;
        int carry = 0;
        while(l1 != null && l2!=null){
            int sum = carry + l1.val + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }
        
        while(l1 != null) {
            int sum =  carry + l1.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l1 = l1.next;
            point = point.next;
        }
        
        while(l2 != null) {
            int sum =  carry + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l2 = l2.next;
            point = point.next;
        }
        
        if (carry != 0) {
            point.next = new ListNode(carry);
        }
        return head.next;
    }
}