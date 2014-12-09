// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction 
//(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

public class Solution {
public static void main(String[] args){
	Solution test = new Solution();
	int[] price={2,1,4};
	System.out.println(test.maxProfit2(price));
}
// when to buy and when to share, the difference is the profit
// use DP, memorize the best profit if buy on each day, then compare
    public int maxProfit(int[] prices) {
    	int days = prices.length;
    	int maxProfit = 0;
    	int[] record = new int[days];// record[i]: profit of buy at day i, sell at day j
    	for(int i = 0;i < days; i++)
    		{
    			record[i] = findMaxProfit(i,prices);
    			maxProfit = maxProfit<record[i]? record[i]:maxProfit;
    		}
            return maxProfit;
    }
    int findMaxProfit(int day, int[] prices){
    	int profit = 0;
    	for(int k = day; k<prices.length;k++){
    		profit = profit<prices[k]-prices[day]?prices[k]-prices[day]:profit;
    	}
    	return profit;
    }
  // brute force, O(n^2)

     public int maxProfit2(int[] prices) {
    	int days = prices.length;
    	if(days<=1) return 0;

		int start=0;
		int maxPrice = 0;
		int[] record = new int[days];

		for(int j = start+1;j<days;j++){
			if(prices[j]<prices[start]){
				start = j;
			}
			else{
				record[start] = prices[j]-prices[start];
				maxPrice = maxPrice<record[start]?record[start]:maxPrice;
			}
		}
         return maxPrice;
    }

    // O(n), key method is draw something on paper, do not think without wirtting down!!
    // if price after today is smaller than current starter, change starter to tommorrow 
    
}