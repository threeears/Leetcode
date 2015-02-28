//Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
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
    public ListNode mergeKLists1(List<ListNode> lists) {
        // first solution divide and conqure
        // time complexity: T(K) = 2T(K/2)+O(n*K): K lists and maximun n length of each list, 
        // therefore: T(k) = nklog(k);
        // space complexity: 空间递归栈： log(k)?? 递归了log(k)次，每次O(1)
        if(lists.size()==0) return null;
        return mergeSort( lists, 0, lists.size()-1);
    }
    public ListNode mergeSort(List<ListNode> lists,int start, int end){
        if(end-start==1){
           return merge2Lists(lists.get(start),lists.get(end));
        }
        if(start==end) return lists.get(start);
        
        int mid = start + (end-start)/2;
        ListNode left = mergeSort(lists,start,mid);
        ListNode right = mergeSort(lists,mid+1,end);
        return merge2Lists(left,right);
    }
    public ListNode merge2Lists(ListNode A, ListNode B){
    	// time: O(m+n)
        ListNode header = new ListNode(-1);
        header.next = A;
        ListNode ptA = header;
        ListNode ptB = B;
        
        while(ptA.next!=null && ptB!=null){
            if(ptA.next.val<=ptB.val){
                ptA = ptA.next;
            }
            else{
                //insert ptB after ptA
                ListNode temp = ptB;
                ptB = ptB.next;// a step further
                temp.next = ptA.next;
                ptA.next = temp;
            }
        }
        if(ptA.next==null && ptB!=null){
            ptA.next = ptB;
        }
        return header.next;
    }
     

//Tao Ge
    // heap sort, 
// time: O(nlgk), space: O(k) (k is the number of lists, n is the number of nodes)
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            if (left == null) {
                return 1;
            } else if (right == null) {
                return -1;
            }
            return left.val - right.val;
        }
    };
    
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            ListNode head = heap.poll();
            tail.next = head;
            tail = head;
            if (head.next != null) {
                heap.add(head.next);
            }
        }
        return dummy.next;
    }




}