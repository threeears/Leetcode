// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

// How many possible unique paths are there?

public class Solution {
	public static void main(String[] args){
		Solution test=new Solution();
		test.uniquePaths(23, 12);
        System.out.println(test.uniquePaths2(23,12));
        System.out.println(test.uniquePaths(23,12));

	}

	// not make use of memory, wasted O()??recurssion can pass time limit
    public int uniquePaths(int m, int n) {
        boolean[][] visited = new boolean[m][n];// if certain box is visited, mark true
        //start from board[0][0]
        if (m==1 || n==1) return 1;
        int count = 0;
        visited[0][0]=true;
        count = findPaths(0,0,m-1,n-1,visited, count);
        return count;

    }
    int findPaths(int start_x, int start_y, int end_x, int end_y, boolean[][] visited,int count){
    		if(start_x == end_x && start_y == end_y)	{
    			count ++;// find a path
    			return count;
    		}

    		else{
	    		if(start_x + 1< visited.length && visited[start_x+1][start_y]==false){
	    			visited[start_x+1][start_y] = true;
	    			count = findPaths(start_x+1, start_y, end_x, end_y, visited,count);
	    			visited[start_x+1][start_y] = false;
	    		}
	    		if(start_y + 1 < visited[0].length && visited[start_x][start_y + 1]==false){
	    			visited[start_x][start_y + 1] = true;
	    			count = findPaths(start_x, start_y + 1, end_x, end_y, visited,count);
	    			visited[start_x][start_y+1] = false;
	    		}
    		}
    	return count;
    }

    // O(n^2) iterative, simple question can find pattern !!
    public int uniquePaths2(int m, int n) {
        if (m<0||n<0){
            return 0;
        }
        if (m==0 || n==0 ){
            return 1;
        }
        
        int[] arr=new int[n];
        arr[0]=1;
        
        for (int i=0; i<m; i++){
            for (int j=1; j<n; j++){
                arr[j]=arr[j]+arr[j-1];
            }
        }
        
        return arr[n-1];
        
        
    }
}