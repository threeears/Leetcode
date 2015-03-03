// Given a binary tree, determine if it is a valid binary search tree (BST).

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.

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
 
    //more efficient one
    // for left tree, we only care if all the  nodes are smaller than certain value
    // for right tree, we  onlu care if all the nodes are larger than certain value
    // take care of overflaw
    public boolean isValidBST(TreeNode root) {
      if(root==null)
        return true;
      return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public boolean helper(TreeNode root, long min, long max){
        if(root==null) return true;
        if(root.val < min || root.val > max){
            return false;
        }
        return helper(root.left, min, (long)root.val-1) && helper(root.right, (long)root.val+1, max);//ALLOW ONLY DISTINCT VALUES
    }

    // use in-order traversal, the order should be increasing
    
    int prev = Integer.MIN_VALUE;
    boolean firstNode=true;// deal with overflow, only needed once, for smallest node， which is also the first one
    public boolean isValidBST(TreeNode root){
        if(root==null) return true;     
        if(!isValidBST(root.left)) return false;
        if(!firstNode && root.val <= prev) return false;
        prev = root.val;
        firstNode = false;
        return isValidBST(root.right);
    }

}