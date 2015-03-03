// Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

// For example,
// Given n = 3, your program should return all 5 unique BST's shown below.

//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3
// confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    // my second round solution , recursion, each time add bst(1,k), bst(k+1,n) as left and right children
     public ArrayList<TreeNode> generateTrees(int n) {
      ArrayList<TreeNode> res =new ArrayList<TreeNode>();
      if(n<=0){
          res.add(null);// this is weird, how do I know why return this?
          return res;
      } 
      return generateTrees(1,n);
    }
    private ArrayList<TreeNode> generateTrees(int start, int end){
        ArrayList<TreeNode> res =new ArrayList<TreeNode>();
        if(start>end) {res.add(null); return res;}//at least one element appears
        if(start==end){
            TreeNode single = new TreeNode(start);
            res.add(single);
            return res;
        }
        for(int i = start; i<=end;i++){
            ArrayList<TreeNode> leftChildren = generateTrees(start,i-1);
            ArrayList<TreeNode> rightChildren = generateTrees(i+1, end);
            // N left, M k altogether M*N groups of solution
            for(int j = 0;j<leftChildren.size();j++){
                for(int k = 0;k<rightChildren.size();k++){
                    TreeNode root = new TreeNode(i);
                    root.left = leftChildren.get(j);
                    root.right = rightChildren.get(k);
                    res.add(root);
                }
            }
        }
        return res;
    }

    // dp from TaoGee, not explored
    // Dynamic Programming
// Maintain a table, dp[i] stores the trees build from array [1..i]
// Each time, for the left subtree, we can use dp[i-1] directly, yet for the right subtree, we need to build
// trees from the array[i+1,j], which is actually array[1...i-j]+ j
    public ArrayList<TreeNode> generateTrees(int n) {
        Map<Integer, ArrayList<TreeNode>> dp = new HashMap<Integer, ArrayList<TreeNode>>();
        dp.put(0, new ArrayList<TreeNode>()); dp.get(0).add(null);
        if (n<=0)   return dp.get(0);
        dp.put(1, new ArrayList<TreeNode>()); dp.get(1).add(new TreeNode(1));
        for (int i=2; i<=n; i++){
            dp.put(i, new ArrayList<TreeNode>());
            for (int j=1; j<=i; j++){
                for (TreeNode left : dp.get(j-1)){
                    for (TreeNode right : dp.get(i-j)){
                        TreeNode root = new TreeNode(j);
                        root.left = left;
                        root.right = genNode(right, j);     // if right subtree, need to add increment to ndoe val
                        dp.get(i).add(root);
                    }
                }
            }
        }
        return dp.get(n);
    }
    // generate right subtree nodes using DFS
    public TreeNode genNode(TreeNode n, int inc){
        if (n==null)    return null;
        TreeNode res = new TreeNode(n.val+inc);
        res.left = genNode(n.left, inc);
        res.right = genNode(n.right, inc);
        return res;
    }   
}