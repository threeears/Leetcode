// Given a binary tree, check whether it is a mirror of itself 
//(ie, symmetric around its center).

// For example, this binary tree is symmetric:

//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
// But the following is not:
//     1
//    / \
//   2   2
//    \   \
//    3    3
// OJ's Binary Tree Serialization:
// The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

// Here's an example:
//    1
//   / \
//  2   3
//     /
//    4
//     \
//      5
// The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//recursion 
public class Solution {
	// second round recursive one
     public boolean isSymmetric(TreeNode root){
		if(root==null) return true;
        return helper(root.left, root.right);
	}
	private boolean helper(TreeNode p, TreeNode q){
	    if(q==null && p==null) return true;
        if(p!=null && q!=null && p.val==q.val)
        {
            return helper(p.left,q.right) && helper(p.right, q.left);
        }
        return false;
	}
}

//iterative using Queue FirstInFirstOut, O(n), can also use FirstInLastOut with Stack, basically no difference
public class Solution{
	public boolean isSymmetric(TreeNode root){
		if(root==null) return true;
		if(root.left==null && root.right==null) return true;
		else if (root.left==null && root.right!=null || root.right==null && root.left!=null) return false;
		Queue<TreeNode> qL = new LinkedList<TreeNode>();
		Queue<TreeNode> qR = new LinkedList<TreeNode>();
		
		qL.add(root.left);
		qR.add(root.right);
		
		while(qL.size()!=0 && qR.size()!=0){
			TreeNode topLeft = qL.remove();
			TreeNode topRight = qR.remove();
			
			if(topLeft.val==topRight.val){
				if(topLeft.left ==null &&  topRight.right!=null || topLeft.left!=null && topRight.right==null){
					return false;
				}
				else{
					if(topLeft.left != null && topRight.right !=null)
					{
							qL.add(topLeft.left);
							qR.add(topRight.right);
					}
				}
				if(topLeft.right ==null &&  topRight.left!=null || topLeft.right!=null && topRight.left==null){
					return false;
				}
				else{
					if(topLeft.right != null && topRight.left !=null)
					{
							qL.add(topLeft.right);
							qR.add(topRight.left);
					}
				}				
			}
			else
				return false;			
		}	
		return true;
	}

	// AnnieKim, better iteration, more elegant, but has duplicate comparisons (in fact, only need to compare the half of one level)
// time: O(n); space: O(b^(d-1)), b is branching factor, d is the maximum depth of the tree
    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        Queue<TreeNode> qu = new LinkedList<TreeNode>();
        qu.add(root.left);
        qu.add(root.right);
        while (!qu.isEmpty()){      // compare one pair each time
            TreeNode t1 = qu.poll();
            TreeNode t2 = qu.poll();
            if (t1==null && t2==null)  continue;
            if (t1==null || t2==null || t1.val != t2.val)   return false;
            qu.add(t1.left);
            qu.add(t2.right);
            qu.add(t1.right);
            qu.add(t2.left);
        }
        return true;
    
}










