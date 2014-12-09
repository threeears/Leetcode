// Find the contiguous subarray within an array (containing at least one number) 
// which has the largest product.

// For example, given the array [2,3,-2,4],
// the contiguous subarray [2,3] has the largest product = 6.

public class Solution {
    public int maxProduct2(int[] A) {
// waste space, timeO(n)
    	 public int maxProduct(int[] A) {

		int[] product_max = new int[A.length+1];// start from i to end, what is the maximum product
    	int[] product_min = new int[A.length+1];// multiply can be reversly larger then before
		int maxProduct = Integer.MIN_VALUE;
    	product_max[A.length] = 1;
    	product_min[A.length] = 1;
    	for(int i = A.length-1;i>=0;i--){
    		int case1_max =Math.max(A[i] * product_max[i+1], A[i] * product_min[i+1]) ;
    		int case1_min =Math.min(A[i] * product_max[i+1], A[i] * product_min[i+1]) ;
    		int case2 = A[i];
    		
    		product_max[i] = Math.max(case1_max,case2);
    		product_min[i] = Math.min(case1_min, case2);
    		maxProduct = maxProduct<product_max[i]?product_max[i]:maxProduct;
    	}
    	return maxProduct;
    }
    }

    public int maxProduct(int[] A) {
   assert A.length > 0;
   int max = A[0], min = A[0], maxAns = A[0];
   for (int i = 1; i < A.length; i++) {
      int mx = max, mn = min;
      max = Math.max(Math.max(A[i], mx * A[i]), mn * A[i]);
      min = Math.min(Math.min(A[i], mx * A[i]), mn * A[i]);
      maxAns = Math.max(max, maxAns);
   }
   return maxAns;
}
}