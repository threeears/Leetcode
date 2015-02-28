//Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


// A partially filled sudoku which is valid.

// Note:
// A valid Sudoku board (partially filled) is not necessarily solvable. 
//Only the filled cells need to be validated.


public class Solution {
    public boolean isValidSudoku(char[][] board) {
        // a little waste to use HashSet, time O(n^2), space O(n)
        boolean check = false;
//check rows
    	for(int i = 0;i<board.length; i++){
    		check = checkLine(board[i]);
    		if(check==false)
    			return false;
    	}
//check columns    	
    	for(int j = 0;j<board.length;j++){ 		
    		char[] line = new char[board.length];    		
    		for(int i = 0; i<board.length;i++){
    			line[i]=board[i][j];
    		}
    		check = checkLine(line);
    		if(check==false)
    			return false;
    	}
    	
 //check grids
    	for(int i = 0; i<board.length; i=i+3){
    		for(int j = 0; j<board.length;j = j+3){
    			char[][] grid = new char[3][3];
    			for(int m=0;m<3;m++)
    				for(int n=0;n<3;n++){
    					grid[m][n]=board[i+m][j+n];
    				}
    			check = checkGrid(grid);
    			if(check==false)
    				return false;
    		}
    	}
    	return true;
    }
     public boolean checkLine(char[] row){
    	HashSet<Character> set = new HashSet<Character>();
    	for(int i = 0;i<row.length;i++){
    		if(row[i]=='.')
    			continue;
    		if(set.contains(row[i]))
    			return false;
    		else
    		{
    			set.add(row[i]);
    		}
    	}
    	return true;
    }
    
    public boolean checkGrid(char[][] grid){
    	HashSet<Character> set = new HashSet<Character>();       
    	for(int i = 0;i<3;i++){
    		for(int j=0; j<3; j++){
    			if(grid[i][j]=='.')
    				continue;
    			if(set.contains(grid[i][j]))
    				return false;
    			else{
    				set.add(grid[i][j]);
    			}
    		}
    	}
    	return true;
    }

// from AnnieKim, use bit vector to mark numbers, and combine the 3 for loops
// time: O(n^2); space: O(n)
     public boolean isValidSudoku(char[][] board) {
        if (board==null || board.length!=9 || board[0].length!=9)   return false;
        int n=9;
        int[] rows = new int[n];
        int[] cols = new int[n];
        int[] blocks = new int[n];
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                if (board[i][j] == '.') continue;
                int bit = 1<<(board[i][j]-'1');
                int x = (i/3)*3 + j/3;          // think how to convert a matrix to an array, i*width+j
                if ((rows[i]&bit)>0 || (cols[j]&bit)>0 || (blocks[x]&bit)>0)    return false;
                rows[i] |= bit;
                cols[j] |= bit;
                blocks[x] |= bit;
            }
        }
        return true;
    }
}

// check row, column, block seperately
// time: O(n^2); sapce: O(n^2)
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board==null || board.length!=9 || board[0].length!=9)   return false;
        boolean[][] rows = new boolean[9][9];
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                if (board[i][j]=='.')   continue;
                else if (!rows[i][board[i][j]-'1'])    rows[i][board[i][j]-'1']=true;
                else    return false;
            }
        }
        boolean[][] cols = new boolean[9][9];
        for (int j=0; j<9; j++){
            for (int i=0; i<9; i++){
                if (board[i][j]=='.')   continue;
                else if (!cols[j][board[i][j]-'1'])    cols[j][board[i][j]-'1'] = true;
                else    return false;
            }
        }
        boolean[][] blocks = new boolean[9][9]; 
        for (int i=0; i<9; i++){
            for (int j=0; j<9; j++){
                int x=(i/3)*3 + j/3;            // map each coordinates to corresponding block, each block has an array to mark the visited one
                if (board[i][j] == '.') continue;
                else if (!blocks[x][board[i][j]-'1'])    blocks[x][board[i][j]-'1'] = true;
                else    return false;
            }
        }
        return true;
    }

}