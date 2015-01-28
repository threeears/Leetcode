import java.util.ArrayList;
import java.util.List;
// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

// For example:
// Given the below binary tree and sum = 22,
//               5
//              / \
//             4   8
//            /   / \
//           11  13  4
//          /  \    / \
//         7    2  5   1
// return
// [
//    [5,4,11,2],
//    [5,8,4,5]
// ]

 // Definition for binary tree
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class Solution {
	public static void main(String[] args){
		Solution test = new Solution();
		TreeNode ont = new TreeNode(-2);
		TreeNode two = new TreeNode(-3);
		ont.right = two;
		System.out.println(test.pathSum(ont,-5));
	}
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result  = new ArrayList<List<Integer>>();
        List<Integer> sub  = new ArrayList<Integer>();
        if(root==null)
            return result;
        sub.add(root.val);
        return helper(root,sum,result,sub,root.val);
    }
    public List<List<Integer>> 
    helper(TreeNode root, int sum, List<List<Integer>>result, List<Integer> sub, int count){
        if(root.left==null && root.right==null && count==sum){
            List<Integer> temp = new ArrayList<Integer>(sub);
            result.add(temp);
            return result;
        }
        else if(root==null)
            return result;
        if(root.left!=null){
        	 sub.add(root.left.val);
             helper(root.left,sum,result,sub,count+root.left.val);
             sub.remove(sub.size()-1);
        }
       if(root.right!=null){
    	   sub.add(root.right.val);
           helper(root.right,sum,result,sub,count+root.right.val);
           sub.remove(sub.size()-1);
       }        
        return result;
    }
}