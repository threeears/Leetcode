import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
	public static void main(String[] args){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		List<Integer> subList1 = new ArrayList<Integer>();
		subList1.add(2);
		List<Integer> subList2 = new ArrayList<Integer>();
		subList2.add(3);
		subList2.add(4);
		List<Integer> subList3 = new ArrayList<Integer>();
		subList3.add(6);
		subList3.add(3);
		subList3.add(7);
		
		list.add(subList1);
		list.add(subList2);
		list.add(subList3);
		Solution test = new Solution();
		
		System.out.println(test.minimumTotal(list));
		System.out.println(test.minimumTotal1(list));
		System.out.println(test.minimumTotal3(list));
		System.out.println(test.minimumTotal4(list));
		

	}
	// mysolution, use stack, binary search, cost timeO(nlgn)?		
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        Stack<Integer> path = new Stack<Integer>();
        path.push(0);
        int sum = 0;
        return subMini(triangle, 0, path,sum);
    }
    public int subMini(List<List<Integer>> triangle, int level, Stack<Integer> path,int sum){
        
        
        int parent = path.peek();
        sum += triangle.get(level).get(parent);// first level
        
        if(level == triangle.size()-1) {
            return sum;      
        }
        path.push(parent);// add again as child left
        int sum_left = subMini(triangle, level+1,path,sum);
        path.pop();// delete left child
        path.push(parent+1);// add again as right child
        int sum_right = subMini(triangle, level+1,path,sum);
        return sum  = sum_left<sum_right?sum_left:sum_right;
        
    }
    // use DP save computation of sub triangle, good solution! time: O(n)
    public int minimumTotal1(List<List<Integer>> triangle) {
        int rowNum = triangle.size();
        int[] dp = new int[rowNum];// mark the minimum size of subtriangle at start from col i,at certain level
        for (int i = 0; i < triangle.get(rowNum - 1).size(); i++) {
            dp[i] = triangle.get(rowNum - 1).get(i);// last line triangle size is themselves
        }
        for (int row = rowNum - 2; row >= 0; row--) {// for each layer, from bottom up!
            for (int col = 0; col <= row; col++) {
                dp[col] = Math.min(dp[col], dp[col + 1])
                        + triangle.get(row).get(col);
            }
        }
        return dp[0];
    }

    public int minimumTotal3(List<List<Integer>> triangle) {
        int rowNum = triangle.get(triangle.size() - 1).size();
        int colNum = triangle.size();
        int[][] dp = new int[rowNum][colNum];
        int i = 0;
        for (Integer n : triangle.get(colNum - 1)) {
            dp[rowNum - 1][i++] = n;
        }
        for (int row = rowNum - 2, m = 0; row >= 0; row--, m++) {
            for (int col = 0; col <= colNum - 2 - m; col++) {
                dp[row][col] = Math.min(dp[row + 1][col], dp[row + 1][col + 1])
                        + triangle.get(row).get(col);
            }
        }
        return dp[0][0];
    }
    //solution 4
    public int minimumTotal4(List<List<Integer>> triangle) {
        if(triangle.size() == 0)
            return 0;

        for (int i=triangle.size() - 2; i>=0; i--) {
            for (int j=0; j<=i; j++) {
                List<Integer> nextRow = triangle.get(i+1);
                int sum = Math.min(nextRow.get(j), nextRow.get(j+1)) + triangle.get(i).get(j);
                triangle.get(i).set(j, sum);
            }
        }
        return triangle.get(0).get(0);
    }
}