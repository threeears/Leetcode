// Given two binary trees, write a function to check if they are equal or not.

// Two binary trees are considered equal if they are structurally identical 
//and the nodes have the same value.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // second Round, more concised
     public boolean isSameTree(TreeNode p, TreeNode q) {
       if(q==null && p==null) return true;
       if(p!=null && q!=null && p.val==q.val)
        {
            return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}