// Given a binary tree, determine if it is height-balanced.

// For this problem, a height-balanced binary tree is defined as a binary tree 
//in which the depth of the two subtrees of every node never differ by more than 1.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
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
	// please fully understand the problem before coding
    // idea, maintain the height and balance at the same time, firstly maintain height, once found not balance, return 
    // unbalanced forever
   public boolean isBalanced(TreeNode root) {
        if (root==null) return true;
        return getHeight(root) > -1;
    }
    public int getHeight(TreeNode node){
       if(node==null) return 0;
       int leftHeight = getHeight(node.left);
       if(leftHeight==-1) return -1;//optimized here, skip check right child
       int rightHeight = getHeight(node.right);
       if( rightHeight==-1) return -1;
       if(Math.abs(leftHeight-rightHeight)>1) return -1;
       return Math.max(leftHeight,rightHeight)+1;
    }
}