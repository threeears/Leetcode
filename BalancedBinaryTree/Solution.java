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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        if(helperHeight(root)==-1)
            return false;
        else
            return true;
    }
    public int helperHeight(TreeNode root){
    	// please note: to judge balance and height simultaneously, subleft and subright may both 
    	//balanced but not balance to their root
        if(root.left==null && root.right==null) return 1;
        int heigt_left=0;
        int heigt_right=0;
        if(root.left!=null){
            heigt_left = helperHeight(root.left);  
            if(heigt_left==-1)
                return -1;
         }
        if(root.right!=null){
            heigt_right = helperHeight(root.right);  
            if(heigt_right==-1)
                return -1;
        }
        if(Math.abs(heigt_left-heigt_right)<=1)
            return Math.max(heigt_left, heigt_right)+1;
        else return -1 ;
    }
}