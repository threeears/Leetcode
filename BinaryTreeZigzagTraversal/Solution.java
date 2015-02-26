
// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

// For example:
// Given binary tree {3,9,20,#,#,15,7},
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its zigzag level order traversal as:
// [
//   [3],
//   [20,9],
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
    // my solution, use Collections.reverse(list), space O(n)less, time O(n) more
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root==null) return result;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int num = q.size();
            List<Integer> sub = new ArrayList<Integer>();
            while(num>0){
                TreeNode visit = q.poll();
                sub.add(visit.val);
                if(visit.left!=null)
                    q.add(visit.left);
                if(visit.right!=null)
                    q.add(visit.right);
                num--;
            }
            result.add(sub);
        }
        
        if(result.size()>1){
             for(int i = 1;i<result.size();i=i+2){
                 Collections.reverse(result.get(i));
            }
        }
       
        return result;
    }

    // nineChapter space O(n)more, time O(n)less
        public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> currLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        Stack<TreeNode> tmp;
        
        currLevel.push(root);
        boolean normalOrder = true;

        while (!currLevel.isEmpty()) {
            ArrayList<Integer> currLevelResult = new ArrayList<Integer>();

            while (!currLevel.isEmpty()) {
                TreeNode node = currLevel.pop();
                currLevelResult.add(node.val);

                if (normalOrder) {
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        nextLevel.push(node.right);
                    }
                    if (node.left != null) {
                        nextLevel.push(node.left);
                    }
                }
            }

            result.add(currLevelResult);
            tmp = currLevel;
            currLevel = nextLevel;
            nextLevel = tmp;
            normalOrder = !normalOrder;
        }

        return result;

    }
    // my second round solution, same as nineChapter's
         public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> A = new Stack<TreeNode>();
        Stack<TreeNode> B = new Stack<TreeNode>();
        Stack<TreeNode> parent = A;
        Stack<TreeNode> children = B;
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root==null) return res;
        A.push(root);
        boolean flag = true;//true is the normal order, from left to right
        while(!parent.isEmpty()){
            ArrayList<Integer> list = new ArrayList<Integer>();
            while(!parent.isEmpty()){
                // add children to stack B from left to right
                TreeNode current = parent.pop();
                list.add(current.val);
                if(flag==true){
                    if(current.left!=null) children.push(current.left);
                    if(current.right!=null) children.push(current.right);
                }
                else{
                    if(current.right!=null) children.push(current.right);
                    if(current.left!=null) children.push(current.left);
                }
                
             }
             res.add(list);
             Stack<TreeNode> temp = parent;
             parent = children;
             children = temp;
             flag = !flag;
        }
        
        return res;
    }
}