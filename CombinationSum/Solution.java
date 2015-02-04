// Given a set of candidate numbers (C) and a target number (T), 
//find all unique combinations in C where the candidate numbers sums to T.

// The same repeated number may be chosen from C unlimited number of times.

// Note:
// All numbers (including target) will be positive integers.
// Elements in a combination (a1, a2, … , ak) must be in non-descending order. 
//(ie, a1 ≤ a2 ≤ … ≤ ak).
// The solution set must not contain duplicate combinations.
// For example, given candidate set 2,3,6,7 and target 7, 
// A solution set is: 
// [7] 
// [2, 2, 3] 
	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Map;
	import java.util.*;

public class Solution {

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (candidates==null || candidates.length==0)
            return res;
        Arrays.sort(candidates);
        dfs(candidates, 0, res, target, new ArrayList<Integer>());
        return res;
    }
    
    private void dfs(int[] candidates, int dep, ArrayList<ArrayList<Integer>> res, int target, ArrayList<Integer> r){
        if (target==0){
            res.add(new ArrayList<Integer>(r));
            return;
        }
        if (dep==candidates.length || target<0)
            return;
        for (int i=dep; i<candidates.length; i++){
            r.add(candidates[i]);
            dfs(candidates, i, res, target-candidates[i], r);
            r.remove(r.size()-1);
        }
    }

// DP version time complexity O(m*n)

public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
      if (candidates == null || candidates.length == 0)
         return new ArrayList<ArrayList<Integer>>();
      Arrays.sort(candidates);
      Map<Integer, ArrayList<ArrayList<Integer>>> dp = new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
      for (int i=0; i<=target; i++)
         dp.put(i, new ArrayList<ArrayList<Integer>>());
      dp.get(0).add(new ArrayList<Integer>());
      int N = candidates.length;
      for (int i = 0; i < N; i++) {
         for (int j = candidates[i]; j <= target; j++) {
            ArrayList<ArrayList<Integer>> lists = clone(dp.get(j - candidates[i]));
            for (ArrayList<Integer> list : lists)
               list.add(candidates[i]);
            dp.get(j).addAll(lists);
         }
      }
      return dp.get(target);
   }

   private ArrayList<ArrayList<Integer>> clone(ArrayList<ArrayList<Integer>> lists) {
      ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
      for (ArrayList<Integer> list : lists) {
         ArrayList<Integer> r = new ArrayList<Integer>(list);
         res.add(r);
      }
      return res;
   }




}