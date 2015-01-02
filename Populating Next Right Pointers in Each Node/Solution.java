// Given a binary tree

//     struct TreeLinkNode {
//       TreeLinkNode *left;
//       TreeLinkNode *right;
//       TreeLinkNode *next;
//     }
// Populate each next pointer to point to its next right node. If there is no next right node, 
//the next pointer should be set to NULL.

// Initially, all next pointers are set to NULL.

// Note:

// You may only use constant extra space.
// You may assume that it is a perfect binary tree (ie, all leaves are at the same level,
// and every parent has two children).
// For example,
// Given the following perfect binary tree,
//          1
//        /  \
//       2    3
//      / \  / \
//     4  5  6  7
// After calling your function, the tree should look like:
//          1 -> NULL
//        /  \
//       2 -> 3 -> NULL
//      / \  / \
//     4->5->6->7 -> NULL

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
     public void connect(TreeLinkNode root) {
      //BFS:
      Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
      if(root==null) return;
      q.add(root);

      while(q.isEmpty()==false)
       { int count = 0;
         int num = q.size();// mark the number of this level of children at this point!!

        while(count<num){
          TreeLinkNode front = q.poll();
          if(count==num-1) front.next=null;
          else front.next = q.peek();
          if(front.left!=null)// do not forget to check avaiblity
             q.add(front.left);
          if(front.right!=null)
             q.add(front.right);
          count++;
        }
        //children in the same level are in the queue
      }  
    }
// space O(1)
     public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode parent = root;
        TreeLinkNode next = parent.left;
        while (parent != null && next != null) {
            TreeLinkNode prev = null;
            while (parent != null) {
                if (prev == null) {
                    prev = parent.left;
                } else {
                    prev.next = parent.left;
                    prev = prev.next;
                }
                prev.next = parent.right;
                prev = prev.next;
                parent = parent.next;
            }
            parent = next;
            next = parent.left;
        }
    }
}