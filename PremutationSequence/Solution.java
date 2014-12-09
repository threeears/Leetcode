// The set [1,2,3,…,n] contains a total of n! unique permutations.

// By listing and labeling all of the permutations in order,
// We get the following sequence (ie, for n = 3):

// "123"
// "132"
// "213"
// "231"
// "312"
// "321"
// Given n and k, return the kth permutation sequence.

// Note: Given n will be between 1 and 9 inclusive.
import java.util.ArrayList;
 public class Solution {
 	public static void main(String[] args){
 		Solution test = new Solution();
 		System.out.println(test.getPermutation2(3,4));
 	}

 	// my solution, time exceed, get all premutaions possible
    public String getPermutation(int n, int k) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	for(int i = 0;i<n;i++){
    		ArrayList<Integer> temp = new ArrayList<Integer>();
    		temp.add(i+1);
    		helper(result, n, temp);
    		temp.remove(temp.size()-1);
    	}

    	StringBuilder kth = new StringBuilder();

    	for(int i = 0;i<n;i++){
    		//kth.append(Integer.toString(result.get(k-1).get(i)));
    		// kth.append((char)'0'+(result.get(k-1).get(i)));
    		 kth.append((result.get(k-1).get(i)));
    		 // all could work, no matter a char, int or string

    	}
    	return kth.toString();
        
    }
    public void helper(ArrayList<ArrayList<Integer>> result, int n, ArrayList<Integer> list){
    	if(list.size()==n){
    		ArrayList<Integer> newlist = new ArrayList<Integer>(list);
    		// need to creat new list, parameter list is just a temp varible
    		result.add(newlist);
    	}
		else{
    		for(int i = 0;i<n;i++){
	    		if(list.contains(i+1)==false){
	    			list.add(i+1);
	    			helper(result,n,list);
	    			list.remove(list.size()-1);// this line is critical!!
	    		}
    		}
    	}   	
    }

    // better solution, only get the kth, find patterns!

 public String getPermutation2(int n, int k) {
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[n];

        k = k - 1;
        int factor = 1;
        for (int i = 1; i < n; i++) {
            factor *= i;
        }

        for (int i = 0; i < n; i++) {
            int index = k / factor;
            k = k % factor;
            for (int j = 0; j < n; j++) {
                if (used[j] == false) {
                    if (index == 0) {
                        used[j] = true;
                        sb.append((char) ('0' + j + 1));
                        break;
                    } else {
                        index--;
                    }
                }
            }
            if (i < n - 1) {
                factor = factor / (n - 1 - i);//n!/n....to find each factor
            }
        }

        return sb.toString();
    }
}