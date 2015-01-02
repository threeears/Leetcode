// Say you have an array for which the ith element is the price of a given stock on day i.

// Design an algorithm to find the maximum profit. 
//You may complete as many transactions as you like 
//(ie, buy one and sell one share of the stock multiple times). 
//However, you may not engage in multiple transactions at the same time
// (ie, you must sell the stock before you buy again).

//greedy!
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length==0) return 0;
        int total = 0;
        int sum = 0;
        int start=prices[0];
        for(int i = 1;i<prices.length;i++)
        {
             if(prices[i]>=prices[i-1]){//greedy, as long as not increasing, restart to calculate sum
                 sum = Math.max(prices[i]-start,sum);
             }
             else{
                 start=prices[i];
                 total = total+sum;
                 sum = 0;
             }
        }
        if(sum!=0)//add the last sum profit
            total+=sum;
        
        return total;
    }
}