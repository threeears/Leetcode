// Two elements of a binary search tree (BST) are swapped by mistake.

// Recover the tree without changing its structure.

// Note:
// A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
// confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

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
    TreeNode A;
    TreeNode B;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
       helper(root);
       if(A!=null){
        int temp = A.val;
        A.val = B.val;
        B.val = temp;
       }
       
    }
    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        if(prev.val>=root.val){
            if(A==null)
               { A = prev;}
            B = root;
        }
        prev = root;
        helper(root.right); 
    }
}