// Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

// You have the following 3 operations permitted on a word:

// a) Insert a character
// b) Delete a character
// c) Replace a character




public class Solution {
    //time O(mn)
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp= new int[l1+1][l2+1];// add empty string at the beginning 
        //initialize
        for(int i = 0;i<l1+1;i++)
        	dp[i][0]=i;
        for(int j = 0;j<l2+1;j++)
        	dp[0][j]=j;
           
        for(int i=1;i<l1+1;i++)
        	for(int j=1;j<l2+1;j++)
        	{
	            if(word1.charAt(i-1)!=word2.charAt(j-1)){
	                int	replace = dp[i-1][j-1]+1;
	                int	delete = dp[i-1][j]+1;
	                int	insert = dp[i][j-1]+1;
	                dp[i][j]= Math.min(Math.min(replace, delete),insert);
	            }
	            else
	            {
	            		dp[i][j]=dp[i-1][j-1];
	            }
    
        	}
        return dp[l1][l2];
    }
    
}