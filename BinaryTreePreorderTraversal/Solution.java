// Given a binary tree, return the preorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},
//    1
//     \
//      2
//     /
//    3
// return [1,2,3].

// Note: Recursive solution is trivial, could you do it iteratively?

/**
 *///Definition for binary tree

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;


//pre-oroder: root, left, right
// in-order: left, root, right
// post-order: left, right, root

// recurrsion

 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

public class Solution {
	public static void main(String[] args){
		Solution test = new Solution();
		TreeNode first = new TreeNode(1);
		TreeNode second = new TreeNode(2);

		first.left = second;
		test.inorderTraversal(first);
	}
     public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
        if(root==null) return list;
    	traversal(root, list);
    	return list;

    }
    void traversal(TreeNode root, List<Integer> list){
    	
    	list.add(root.val);

    	
    	if(root.left !=null)
    		traversal(root.left, list);

    	
    	if(root.right!=null)

    		traversal(root.right,list);
    }


// iterative using stack
    public List<Integer> preorderTraversal2(TreeNode root){
    	List<Integer> list = new ArrayList<Integer>();

    	if(root==null) return list;
    	Stack<TreeNode> sk = new Stack<TreeNode>();
    	sk.push(root);
    	
    	while(sk.isEmpty()==false){
    	    TreeNode top = sk.pop();
    		list.add(top.val);
    		if(top.right!=null){
    			sk.push(top.right);
    		}
    		if(top.left!=null){
    			sk.push(top.left);
    		}
    	}
    	
    	return list;
    }


// key point, reverse store, use another stack to mark visited nodes in case of infiniate loop
// actually, we could avoid duplictes by only add more left if right child exists, 
     public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();

    	if(root==null) return list;
    	Stack<TreeNode> sk = new Stack<TreeNode>();
    	Stack<TreeNode> visited= new Stack<TreeNode>();// or Hashset , might be faster
    	sk.push(root);
    	while(sk.isEmpty()==false){
    		
    		if(visited.contains(sk.peek()))// if the node is fully expended(visited), then it could add to path
			{	list.add(sk.peek().val);
					sk.pop();
			}
    		else{
		    		TreeNode top = sk.pop();
		    		visited.push(top);
		    		
		    		if(top.right!=null){
		    			sk.push(top.right);
		    		}
		    		sk.push(top);
		
		    		if(top.left!=null){
		    			sk.push(top.left);
		    		}
    		}
    	}
    	return list;
    } 
// in order avoid duplicates
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null)   return res;
        Stack<TreeNode> st = new Stack<TreeNode>();
        while (root != null){
            st.push(root);
            root = root.left;
        }
        while (!st.isEmpty()){
            TreeNode curr = st.pop();
            res.add(curr.val);
            curr = curr.right;
            while (curr!=null){
                st.push(curr);
                curr = curr.left;
            }
        }
        return res;
    }
// in order traversal with recursion
     public List<Integer> inorderTraversal(TreeNode root) {
      List<Integer> res = new ArrayList<Integer>();
      return traverse(root, res);
    } 
    private List<Integer> traverse(TreeNode root, List<Integer> res){
        if(root==null) return res;
        if(root.left==null && root.right==null){
            res.add(root.val);
            return res;
        }
        traverse(root.left, res);
        res.add(root.val);
        traverse(root.right,res);
        return res;
    }

// post order, same principle as in-order
public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> list = new ArrayList<Integer>();

    	if(root==null) return list;
    	Stack<TreeNode> sk = new Stack<TreeNode>();
    	Stack<TreeNode> visited= new Stack<TreeNode>();
    	sk.push(root);
    	while(sk.isEmpty()==false){
    		
    		if(visited.contains(sk.peek()))
			{	list.add(sk.peek().val);
					sk.pop();
			}
    		else{
		    		TreeNode top = sk.pop();
		    		visited.push(top);
		      		sk.push(top);

		    		if(top.right!=null){
		    			sk.push(top.right);
		    		}
		    		if(top.left!=null){
		    			sk.push(top.left);
		    		}

    		}
    	}
    	return list;  
    }

    // recursion
     public List<Integer> postorderTraversal(TreeNode root) {
      List<Integer> res = new ArrayList<Integer>();
      return helper(root, res);
    }
    private List<Integer> helper(TreeNode root, List<Integer> res){
        if(root==null) return res;
        helper(root.left,res);
        helper(root.right,res);
        res.add(root.val);
        return res;
    }
}