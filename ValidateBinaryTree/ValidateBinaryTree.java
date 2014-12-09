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
    public boolean isValidBST(TreeNode root) {

    	if(root==null) return true;

    	if(root!=null && root.left==null && root.right==null) return true;

    	if(root.left!=null)
    	{// find out the minimnum element in subleftTree
    		if(findMax(root.left)<root.val && isValidBST(root.left)) return true;

       	}

       	if(root.right!=null)
       	{// find out the maximun element in subRightTree
       		if(findMin(root.right) > root.val && isValidBST(root.right)) return true;
       	}

       	return false;

    }
    public int findMin(TreeNode root){
    	if(root.left==null && root.right!=null)
    		return findMin(root.right);
    	if(root.right==null && root.left!=null)
    		return findMin(root.left);
    	if(root.left!=null && root.right!=null)
    		return Math.min(findMin(root.right), findMin(root.left));
    	if(root.left==null && root.right==null)
    		return root.val;

    }
    public int findMax(TreeNode root){
    	if(root.left==null && root.right!=null)
    		return findMax(root.right);
    	if(root.right==null && root.left!=null)
    		return findMax(root.left);
    	if(root.left!=null && root.right!=null)
    		return Math.max(findMin(root.right), findMin(root.left));
    	if(root.left==null && root.right==null)
    		return root.val;
    }
}