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

	//naive solution, find 1sum, 2sum, 3sum...Tsum
	// naive2: every possible elements: 2:2,4,6; 3:3,6; 6:6, 7:7
	// 2, 4, 6(2s),7


	public static void main(String[] args){
		Solution test = new Solution();
		int[] candidates={2,3,8,1};
		int target = 7;
		test.combinationSum(candidates, target);
	}
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    		List<Integer> list = new ArrayList<Integer>();
    		Arrays.sort(candidates);// important base!
    		System.out.println(findTarget(candidates,0,list,result ,0,target));
    	// start with sum zero
    	return result;
    }
// similar to DFS
   public List<List<Integer>> findTarget(int[] array, int base, List<Integer> group,
		   						List<List<Integer>> result, int sum,int target){
   			boolean flag = false;
	   		for(int i = base;i<array.length;i++){
   				if(sum + array[i]==target){
   					group.add(array[i]);
   					sum = sum + array[i];
   					flag = true;// find one!!
   				}
   				else if(sum + array[i]>target){
   					flag =false;// cannot find , but may find group still in this loop
   					// cannot return from here!!
   				}
   				else{
   					group.add(array[i]);
   					sum = sum + array[i];
   					if(findTarget(array,i,group,result,sum,target)==null)
   						sum = sum - array[i];// because newly added node does not work at all
   					else
   					{// newly added work worked, 2,2,returned, found one, no other are possible
   						group.remove(group.size()-1);// therefore, try 2,3 next
   						sum = sum-array[i];
   						
   					}
   				}
   				if(flag==true){// if found one group, create a new copy, not reference!!
   					List<Integer> addList = new ArrayList<Integer>();
   					for(int k = 0;k<group.size();k++)
   						addList.add(group.get(k));
   					result.add(addList);
   					group.remove(group.size()-1);// 2,2,3 works, remove 3, return to 2,2,(2-end)
   					return result;//if not return, next would be  2,2,4, not necessary
   				}
   			}
	   		if(flag==false)
			{	if(group.size()==0)
				return result;// first element is not working, all after is will not work also
	   			group.remove(group.size()-1);
	   			sum = sum - array[base];// this line can be removed
	   		}
	   		// the only case returns null is after for loop is done, no group has found
   			return null;
   			
   }










}