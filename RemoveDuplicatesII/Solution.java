// Follow up for "Remove Duplicates":
// What if duplicates are allowed at most twice?

// For example,
// Given sorted array A = [1,1,1,2,2,3],

// Your function should return length = 5, and A is now [1,1,2,2,3].

public class Solution {
   public int removeDuplicates(int[] A) {
    	ArrayList<Integer> arr = new ArrayList<Integer>();
    	if(A.length<=2) return A.length;
    	int  count = A.length;
    	int i = 0;
    	while(i<A.length){
    		int j = i+1;
    		int flag=0;
    		arr.add(A[i]);
    		while(j<A.length && A[j]==A[i])
    		{   
    			if(flag<1){
    				arr.add(A[j]);
    			}
    			flag++;
    			j++;
    		}
    		i=j;
    	}
    	
    	for(i = 0; i<arr.size();i++){
    		A[i]=arr.get(i);
    	}
        return arr.size();
    }
}