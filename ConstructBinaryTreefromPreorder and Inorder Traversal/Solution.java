// Given preorder and inorder traversal of a tree, construct the binary tree.

// Note:
// You may assume that duplicates do not exist in the tree.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//pre-order: root, left, right
//in-order: left, root, right
// same process as postorder, inorder construction, find root first, then from left to right
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int num = preorder.length;
		if(num==0) return null;

		TreeNode root = new TreeNode(preorder[0]);
		if(num==1) return root;
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0;i<num;i++){
			map.put(inorder[i],i);
		}    	

		int tmp = map.get(preorder[0]);//left first
		
		root.left = findTree(inorder, 0, tmp-1, preorder, 1,map);
		int leftChild = tmp-1+1;
		root.right = findTree(inorder, tmp+1, num-1, preorder,leftChild+1 ,map);
		
		return root;
    }

    public TreeNode findTree(int[] inorder, int start, int end, int[] preorder, 
    						int pointer, HashMap<Integer,Integer> map){
    	if(pointer<0)
    		return null;
    	if(start == end){
    		TreeNode tmp = new TreeNode(inorder[start]);
    		return tmp;
    	}
    	else if(start<end){
    		TreeNode root = new TreeNode(preorder[pointer]);
    		int tmp = map.get(root.val);
    		
    		root.left = findTree(inorder,start,tmp-1,preorder,pointer+1, map);
    		int leftChild = tmp-1-start+1;
			root.right = findTree(inorder,tmp+1, end, preorder, pointer+1+leftChild,map);
    		return root;
    	}
    	else{return null;}

    }
}