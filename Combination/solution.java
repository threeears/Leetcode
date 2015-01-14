// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

// For example,
// If n = 4 and k = 2, a solution is:

// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> collection = new ArrayList<List<Integer>>();
        for(int i = 1;i<=n;i++){
            List<Integer> sub = new ArrayList<Integer>();
            sub.add(i);
            helper(i,collection,sub,n,k);// every starter differs
        }
        return collection;
    }
    public boolean helper(int pos, List<List<Integer>> collection, List<Integer> sub, int n, int k){
        if(sub.size()==k && collection.contains(sub)==false){
            List<Integer> temp = new ArrayList<Integer>(sub);
            collection.add(temp);
            return true;
        }
        while(pos<n){
            sub.add(pos+1);
            boolean check = helper(pos+1,collection,sub,n,k);
            sub.remove(sub.size()-1);//no matter success or not,no duplicates in subs
            pos++;
        }
        return false;
    }
}
