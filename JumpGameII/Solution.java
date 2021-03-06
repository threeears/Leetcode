// Given an array of non-negative integers, 
//you are initially positioned at the first index of the array.

// Each element in the array represents your maximum jump length at that position.

// Your goal is to reach the last index in the minimum number of jumps.

// For example:
// Given array A = [2,3,1,1,4]

// The minimum number of jumps to reach the last index is 2. 
//(Jump 1 step from index 0 to 1, then 3 steps to the last index.)

public class Solution {
     public int jump(int[] A) {
        int reachable = 0;
        int previousReach = 0;
        int step = 0;
        int i = 0;
        
        for(i = 0;i<A.length && i <=reachable;i++){
        	if(i>previousReach){
        		step++;
        		previousReach=reachable;
        	}
        	reachable = Math.max(reachable, A[i]+i);
        }

        if(A.length-1<=previousReach)
        	return step;
        else
        	return 0;
    }

    // dp // Dynamic Programming
// time: O(n^2), TLE in Leetcode OJ; space: O(n^2)
    public int jump(int[] A) {
        if (A==null || A.length==0) return 0;
        int N = A.length;
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i=1; i<N; i++){
            int range = A[i];
            for (int j=1; j<=range && ((i+j)<N); j++){ 
                if (dp[i+j] == 0)   dp[i+j] = dp[i] + 1;
                else dp[i+j] = Math.min(dp[i+j], dp[i]+1);
            }
        }
        return dp[N];
    }

//  nineChapter solution
    public int jump2(int[] A) {
        int[] steps = new int[A.length];
        
        steps[0] = 0;
        for (int i = 1; i < A.length; i++) {
            steps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (steps[j] != Integer.MAX_VALUE && j + A[j] >= i) {
                    steps[i] = steps[j] + 1;
                    break;
                }
            }
        }
        
        return steps[A.length - 1];
    }

    
}