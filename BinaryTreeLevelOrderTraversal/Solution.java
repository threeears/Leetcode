// Given a binary tree, return the level order traversal of its nodes' values. 
//(ie, from left to right, level by level).

// For example:
// Given binary tree {3,9,20,#,#,15,7},
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new  LinkedList<TreeNode>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
       
        q.add(root);
        while(q.isEmpty()==false){
            int currentSize = q.size();
            List<Integer> sub = new ArrayList<Integer>();
            for(int i = 0;i<currentSize;i++){
                TreeNode node = q.poll();
                sub.add(node.val);
                if(node.left!=null)
                    q.add(node.left);
                if(node.right!=null)
                    q.add(node.right);
            }
            result.add(sub);
        }
        List<List<Integer>> reverseResult = new ArrayList<List<Integer>>();
        for(int i=0;i<result.size();i++){
            reverseResult.add(result.get(result.size()-1-i));
        }
        return reverseResult;
    }
}