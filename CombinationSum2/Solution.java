// Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

// Each number in C may only be used once in the combination.

// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
// A solution set is: 
// [1, 7] 
// [1, 2, 5] 
// [2, 6] 
// [1, 1, 6] 

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (candidates==null || candidates.length==0)
            return res;
        Arrays.sort(candidates);
        dfs(candidates, 0, res, target, new ArrayList<Integer>());
        return res;
    }
    
    private void dfs(int[] candidates, int dep, ArrayList<ArrayList<Integer>> res, int target, ArrayList<Integer> r){
        if (target==0){
           // if(res.contains(r)==false)// list compare value, therefore can move duplicates, but it waste time.
                res.add(new ArrayList<Integer>(r));
            return;
        }
        if (dep==candidates.length || target<0)
            return;
        int prev = -1;// another way to remove duplicaton
        for (int i=dep; i<candidates.length; i++){
            if(candidates[i]>target){
                break;
            }
            if(prev != -1 && prev == candidates[i])
                continue;
            r.add(candidates[i]);
            dfs(candidates, i+1, res, target-candidates[i], r);
            r.remove(r.size()-1);
            prev = candidates[i];
        }
    }
}