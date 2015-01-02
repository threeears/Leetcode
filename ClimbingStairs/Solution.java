// You are climbing a stair case. It takes n steps to reach to the top.

// Each time you can either climb 1 or 2 steps.
// In how many distinct ways can you climb to the top?

public class Solution {
      public int climbStairs(int n) {
        if(n<=1) return n;
        int[] dp = new int[n];
        return helper(n,dp);
    }
    public int helper(int n,int[] dp){
       dp[1]=2;
       dp[0]=1;
    	for(int i = 2;i< n;i++){	
    		int count = 0;
    		if(i-1>=0)
    		{
    			//only one step possible
    			dp[i]=dp[i-1];//dp[i-1]+1
    		}
    		 if(i-2>=0){
    			dp[i]=dp[i-2]+dp[i-1];//dp[i-2]+2, dp[i-2]+1+1(dp[i-1]+1)
    			//each calculation goes only one step, do not think too much!
    		}
    		
    	} 	
    	return dp[n-1];
    }
// observation, only need last two number of steps.save much more space, like febnachi order!!
    public int climbStairs(int n) {
        if (n <= 1) {
            return n;
        }
        int last = 1, lastlast = 1;
        int now = 0;
        for (int i = 2; i <= n; i++) {
            now = last + lastlast;
            lastlast = last;
            last = now;
        }
        return now;
    }
}