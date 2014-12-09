// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes 
//along the shortest path from the root node down to the nearest leaf node.
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//recursive how to compute complexity for recursive solution???
public class Solution {
    public int minDepth(TreeNode root) {

    	int minL = Integer.MAX_VALUE;
    	int minR = Integer.MAX_VALUE;
    	TreeNode traverse=root;

    	if(root==null) return 0;
    	else{

			if(traverse.left!=null)
				minL = minDepth(traverse.left) + 1;
			if(traverse.right!=null)
				minR = minDepth(traverse.right) + 1;
			if(traverse.left ==null && traverse.right ==null)
				return 1;
        }
        return Math.min(minL, minR);
    }
}

// iterative solution not explored yet!
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
 
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> counts = new LinkedList<Integer>();
 
        nodes.add(root);
        counts.add(1);
 
        while(!nodes.isEmpty()){
            TreeNode curr = nodes.remove();
            int count = counts.remove();
 
            if(curr.left != null){
                nodes.add(curr.left);
                counts.add(count+1);
            }
 
            if(curr.right != null){
                nodes.add(curr.right);
                counts.add(count+1);
            }
 
            if(curr.left == null && curr.right == null){
                return count;
            }
        }
 
        return 0;
    }
}