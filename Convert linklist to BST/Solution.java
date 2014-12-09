/**
 * Definition for singly-linked list.*/
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
 
/**
 * Definition for binary tree*/
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }
 
public class Solution {
	public static void main(String[] args){
		ListNode  one = new ListNode(3);
		ListNode two = new ListNode(5);
		ListNode three = new ListNode(8);
		ListNode four = new ListNode(9);
		ListNode five = new ListNode(4);
		ListNode six = new ListNode(5);
		
		one.next = two;
		two.next = three;
//		three.next = four;
//		four.next= five;
//		five.next = six;
		
		Solution test = new Solution();
		TreeNode result = test.sortedListToBST(one);
		System.out.println(result.val);

	}
    public TreeNode sortedListToBST(ListNode head) {

        // find the mid of the list to be as root
        // left are sub trees of left
        // right are sub trees of right
//1,2,3,4,5,6,7,8
//
        if(head ==null) return null;
        if(head.next==null){
        	TreeNode root = new TreeNode(head.val);
        	return root;
        }

	       ListNode pointer = head.next;// should be one step faster than mid because we want mid to be 
	       // the pointer left to the actual mid
	       ListNode mid = head;
	       while(pointer.next!=null && pointer.next.next!=null)
	       {
	       	pointer = pointer.next.next;
	       	mid = mid.next;
	       }// mid.next is root, mid is last of fist left, mid.next.next is the first of right
	      ListNode right = mid.next.next;
	      TreeNode root = new TreeNode(mid.next.val);//mid is root
	      root.right = sortedListToBST(right);
	      mid.next=null;
	      root.left = sortedListToBST(head);
	    return root;
    }
}


