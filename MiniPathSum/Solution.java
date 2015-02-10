// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.


public class Solution {
    public int minPathSum(int[][] grid) {
        // top left: grid[0][0], bottom right: grid[m-1][n-1], m is the row, n is the collumn
        // time O(M*N) space O(m*n)
        if(grid.length==0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];// compress 

        dp[0][0] = grid[0][0];
        for(int i = 1;i<grid.length;i++)
            dp[i][0] =dp[i-1][0]+grid[i][0];
        for(int j = 1;j<grid[0].length;j++)
            dp[0][j] =dp[0][j-1]+grid[0][j];
            
        for(int i = 1;i<grid.length;i++)
            for(int j = 1;j<grid[0].length;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
            
        return dp[grid.length-1][grid[0].length-1];
    }
    // DP, O(n^2) time, O(n) space, not fully understood yet, refator array
    public int minPathSum2(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
         
        int[] res = new int[col];
        // init
        Arrays.fill(res, Integer.MAX_VALUE);
        res[0] = 0;
         
        // rest elements
        for(int i = 0; i < row; i++) {
            // init the 0th sum = old 0th element + the new 0th element
            // just init the 0th column every time dynamically
            res[0] = res[0] + grid[i][0];
             
            // loop through each element of each row
            for(int j = 1; j < col; j++) {
                res[j] = grid[i][j] + Math.min(res[j], res[j - 1]);
            }
        }
         
        return res[col - 1];
    }

}