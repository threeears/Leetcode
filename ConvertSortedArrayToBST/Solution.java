// Given an array where elements are sorted in ascending order, 
//convert it to a height balanced BST.

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
    public TreeNode sortedArrayToBST(int[] num) {
        // median always stays in middle
        if(num.length==0) return null;
        if(num.length==1) return new TreeNode(num[0]);
        return helper(0,num.length-1, num);
    }
    TreeNode helper(int start, int end, int[] num){
        if(end-start==1){
            TreeNode leaf = new TreeNode(num[start]);
            leaf.left = null;
            leaf.right = new TreeNode(num[end]);
            return leaf;
        }
        else if(end==start){
            TreeNode leaf = new TreeNode(num[start]);
            leaf.left = null;
            leaf.right = null;
            return leaf;
        }
        int mid = start + (end-start)/2;
        TreeNode head = new TreeNode(num[mid]);
        head.left = helper(start, mid-1, num);
        head.right = helper(mid+1, end, num);
        return head;
    }

// from nine chapter, more concised way
     private TreeNode buildTree(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(num[(start + end) / 2]);
        node.left = buildTree(num, start, (start + end) / 2 - 1);
        node.right = buildTree(num, (start + end) / 2 + 1, end);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null) {
            return null;
        }
        return buildTree(num, 0, num.length - 1);
    }
}