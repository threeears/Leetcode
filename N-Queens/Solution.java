// Given an integer n, return all distinct solutions to the n-queens puzzle.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

// For example,
// There exist two distinct solutions to the 4-queens puzzle:

// [
//  [".Q..",  // Solution 1
//   "...Q",
//   "Q...",
//   "..Q."],

//  ["..Q.",  // Solution 2
//   "Q...",
//   "...Q",
//   ".Q.."]
// ]



public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> sol = new ArrayList<String[]>();
        int[] queens = new int[n];
        //stores the position of each queen queen[0]=1 means chessBoard[0][1]="Q", queen[i][0] means level i of chess
        //board have not placed any queen yet.
        
        helper(0,queens, sol);
        
        return sol;
    }
    public int helper(int level, int[] currentPlacement, List<String[]> sol){ 	
    	int n = currentPlacement.length;//n
    	if(level==n){
    		// find a valid solution to the problem
    		String[] res = new String[n];   		
    		for(int i = 0; i<n;i++){
    			char[] subString= new char[n];
    			for(int j=0;j<n;j++){
    				subString[j]='.';
    			}
    			subString[currentPlacement[i]-1]='Q';// currentPlace[i]:1...4
    			res[i]=new String(subString);//best way to turn a char array into a string!
    			System.out.println(res[i]);
    		}
    		sol.add(res);
    		return 1;
    	}
    	
    	for(int i=1; i<= n; i++){
			currentPlacement[level]=i;
    		if(isBlock(level, currentPlacement)==false){
    			int result = helper(level+1, currentPlacement, sol);
    			if(result==-1)// this is absolutely needed ! current can be right but it child can go wrong!!
    				currentPlacement[level]=0;
    		}
    		else{
    			currentPlacement[level]=0;
    		}
    	}
    	return -1;
    }
    public boolean isBlock(int level, int[] currentPlacement){// O(n)
    	//level is from 0 to n-1
    	for(int i = 0; i<level;i++){
    		// two constrains to check, one constrain(horizontally) has already ensured.
    		//constrain one: if in the same column?
    		if(currentPlacement[level]==currentPlacement[i])
    			return true;
    		//constrain two: in the diagonal line?
    		if(Math.abs(level-i) == Math.abs(currentPlacement[level]-currentPlacement[i]))//do not forget the positive and negative gradient 
    			return true;
    	}
    	return false;//not a block
    }

    //bit check validation  suduko check similar
    public ArrayList<String[]> solveNQueens(int n){
        ArrayList<String[]> res = new ArrayList<String[]>();
        finder( 0, 0, 0, 0, new long[n], res);
        return res;
   }
   
   public void finder(int x, long col, long lDiagonal, long rDiagonal, long[] rows, ArrayList<String[]> res){
        if (x == rows.length){
            String[] r = new String[rows.length];
            for (int i=0; i<rows.length; i++){
                r[i] = Long.toBinaryString(rows[i]).replace('0', '.').replace('1', 'Q');
                while (r[i].length() < rows.length) r[i] = '.' + r[i];  // add '.' to fill the missing 0s
            }
            res.add(r);
        }
        else{
            long avail = ~(col | lDiagonal | rDiagonal);
            for (int i=0; i<rows.length; i++){
                long pos = avail & (1<<i);
                if (pos > 0){
                    rows[x] = pos;
                    finder(x+1, (col | pos), ((lDiagonal | pos) << 1), ((rDiagonal | pos) >> 1), rows, res);
                }
            }
        }
}