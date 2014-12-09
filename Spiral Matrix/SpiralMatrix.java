public class Solution {
	// time: O(m*n), space:O(m*n)
	// take care of special cases: null matrix, one element matrix, boundary calculation
	public List<Integer> spiralOrder(int[][] matrix) {
	   List<Integer> spList = new ArrayList();
	   if(matrix.length==0) return spList;

    	int row_max = matrix.length - 1;
    	int col_max = matrix[0].length - 1;
    	int start = 0;

    	// the order is:
    	while(col_max > start && row_max > start){
    		int i,j;

    		for( i = start; i<=col_max-1; i++){
    			spList.add(matrix[start][i]);
    		}
    		for( j = start; j<=row_max-1; j++){
    			spList.add(matrix[j][i]);
    		}
    		for(;i>start;i--){
    			spList.add(matrix[j][i]);
    		}
    		for(;j>start;j--){
    			spList.add(matrix[j][i]);
    		}
    		
    		start ++;
    		row_max--;
    		col_max--;
		}
    	if(start == row_max && start == col_max){
    		spList.add(matrix[start][start]);
    	}
    	if(start == row_max && start != col_max){
    		for(int i = start; i<=col_max;i++)
    		{
    			spList.add(matrix[start][i]);
    		}
    	}
    	if(start == col_max && start != row_max){
    		for(int j = start; j<=row_max;j++){
    			spList.add(matrix[j][start]);
    		}
    	}

    		//start:	 (0,0) 					(1,1) 		(2.2)..
    		// end: (0,col_max-1),		 (1, col_max-2), (2, col_max-3)..

    		//start: (0,col_max),		 (1, col_max-1), (2,col_max - 2)..
    		//end: (row_max -1,col_max)

    		//start: (row_max, col_max)
    		//end:	   (row_max, 1)

    		//start: 	(row_max,0)
    		//end:			(1,0)
  
        return spList;
    }

}