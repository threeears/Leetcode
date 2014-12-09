// Given a binary tree, flatten it to a linked list in-place.

// For example,
// Given

//          1
//         / \
//        2   5
//       / \   \
//      3   4   6
// The flattened tree should look like:
//    1
//     \
//      2
//       \
//        3
//         \
//          4
//           \
//            5
//             \
//              6

/**
 * Definition for binary tree*/
  public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public class Solution {
      public void flatten(TreeNode root) {
         root =  helper(root);
      }
       public TreeNode helper(TreeNode parent){
         if(parent==null) return null;// leaf node
         TreeNode left = parent.left;
         TreeNode right = parent.right;

        if(left!=null){ // check left child first, 
          left = helper(left);
          parent.left=null;
          parent.right = left;
        }
        if(right!=null){// check right child then
          right = helper(right);
        }
        if(left!=null){// if left is not null, find last right of sub tree left, turn the pointer to right
          while( left.right!=null)
             left=left.right;
           left.right = right;
        }
         return parent;
       }
  }




