// Given inorder and postorder traversal of a tree, construct the binary tree.

// Note:
// You may assume that duplicates do not exist in the tree.

/**
 * Definition for binary tree*/
import java.util.HashMap;
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 

// in-order: left, root, right
// post-order: left, right, root

public class Solution {
	public static void main(String[] args){
		int[] postorder = {4,5,2,6,7,3,1};
		int[] inorder = {4,2,5,1,6,3,7};
		Solution test = new Solution();
		//TreeNode result = test.buildTree(inorder, postorder);
		TreeNode result2 = test.buildTree2(inorder, postorder);

		//System.out.println(result.right.val);
		System.out.println(result2.right.val);
		
	}
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
		int num = postorder.length;
		if(num==0) return null;

		TreeNode root = new TreeNode(postorder[num-1]);
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0;i<num;i++){
			map.put(inorder[i],i);
		}    	

		int tmp = map.get(postorder[num-1]);//right first
		root.right = findTree(inorder, tmp+1, num-1, postorder, num-2,map);
		int rightChilds = num-1-tmp-1+1;
		root.left = findTree(inorder, 0, tmp-1, postorder, num-1-rightChilds-1,map);

		return root;
        
    }
    public TreeNode findTree(int[] inorder, int start, int end, int[] postorder, 
    						int pointer, HashMap<Integer,Integer> map){
    	if(pointer<0)
    		return null;
    	if(start == end){
    		TreeNode tmp = new TreeNode(inorder[start]);
    		return tmp;
    	}
    	else if(start<end){
    		TreeNode root = new TreeNode(postorder[pointer]);
    		int tmp = map.get(root.val);
    		root.right = findTree(inorder,tmp+1, end, postorder, pointer-1,map);
    		int rightChilds = end-tmp-1+1;
    		root.left = findTree(inorder,start,tmp-1,postorder,pointer-rightChilds-1, map);

    		return root;
    	}
    	else{return null;}

    }
    private int findPosition(int[] arr, int start, int end, int key) {
        int i;
        for (i = start; i <= end; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }


// solution 2, not explored
   private TreeNode myBuildTree(int[] inorder, int instart, int inend,
           int[] postorder, int poststart, int postend) {
       if (instart > inend) {
           return null;
       }

       TreeNode root = new TreeNode(postorder[postend]);
       int position = findPosition(inorder, instart, inend, postorder[postend]);

       root.left = myBuildTree(inorder, instart, position - 1,
               postorder, poststart, poststart + position - instart - 1);
       root.right = myBuildTree(inorder, position + 1, inend,
               postorder, poststart + position - instart, postend - 1);
       return root;
   }

   public TreeNode buildTree(int[] inorder, int[] postorder) {
       if (inorder.length != postorder.length) {
           return null;
       }
       return myBuildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
   }
}