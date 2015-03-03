// Given a collection of numbers, return all possible permutations.
// For example,
// [1,2,3] have the following permutations:
// [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

public class Solution {

  // Note: no duplicates

// A permutation is an ordered combination, order does matter in permutation.
// e.g. [1,1,2] and [1,2,1] is different
// while order does not matter in combination
// e.g. [1,1,2] and [1,2,1] are the same

// DFS
// From the definition of permutation, in each position, we can have all the different values
    public List<List<Integer>> permute(int[] num) {
       List<List<Integer>> result = new ArrayList<List<Integer>>();

       if(num==null || num.length==0)
       {
       		return result;
       }
       List<Integer> list = new ArrayList<Integer>();
       helper(result, list, num);
       return result;      
    }
     public void helper(List<List<Integer>> result, List<Integer> list, int[] num){
     	if(list.size()==num.length){
     		result.add(new ArrayList<Integer>(list));
     	}
     	
     	for(int i=0;i<num.length;i++){
     		if(list.contains(num[i]))
     			continue;
     		list.add(num[i]);
     		hel[er(result,list,num);
     		list.remove(list.size()-1);
     	}

     }
}