// Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

// Calling next() will return the next smallest number in the BST.

// Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.

// Credits:
// Special thanks to @ts for adding this problem and creating all test cases.

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
	//my solution , in-order traversal
    TreeNode current;
    Queue<TreeNode> queue = new LinkedList<TreeNode>();
    
    public void fillQueue(TreeNode current){
        // inorder traversal fill with queue
        if(current==null) return;
        if(current.left==null && current.right == null) {
            queue.add(current);
            return;
        }
        fillQueue(current.left);
        queue.add(current);
        fillQueue(current.right);
        
    }

    public BSTIterator(TreeNode root) {
        current = root;
        fillQueue(current);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return queue.remove().val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */