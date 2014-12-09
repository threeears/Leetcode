//Merge k sorted linked lists and return it as one sorted list. 
//Analyze and describe its complexity.

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
    public ListNode mergeKLists(List<ListNode> lists) {
    	int size = lists.size();
    	ListNode head = new ListNode(0);
    	ListNode header = head;

    	for(int i = 0;i < size();i++){
    		ListNode pointer = lists.get(0);
    		while(pointer!=null){
    			heapAdd(header,pointer);
    			pointer = pointer.next;
    			header = header.next;
    		}
    	}
        
    }

    // build a heap, head is the smallest element, 2i is the left child, 2i+1 is right child
    public void heapAdd(ListNode header, ListNode pointer){//insert in the fromt
    	ListNode next=header.next;
    	header.next = pointer;
    	pointer.next = next;// insert from head
    	heapAdjust(header.next);
    	
    }
    public void heapAdjust(ListNode header){//
    	ListNode 
    }
}