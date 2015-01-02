//Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


// A partially filled sudoku which is valid.

// Note:
// A valid Sudoku board (partially filled) is not necessarily solvable. 
//Only the filled cells need to be validated.


public class Solution {
    public boolean isValidSudoku(char[][] board) {
        
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


    // from nine chapter
      public boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[9];
        
        // row
        for(int i = 0; i<9; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j<9; j++){
                if(!process(visited, board[i][j]))
                    return false;
            }
        }
        
        //col
        for(int i = 0; i<9; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j<9; j++){
                if(!process(visited, board[j][i]))
                    return false;
            }
        }
        
        // sub matrix
        for(int i = 0; i<9; i+= 3){
            for(int j = 0; j<9; j+= 3){
                Arrays.fill(visited, false);
                for(int k = 0; k<9; k++){
                    if(!process(visited, board[i + k/3][ j + k%3]))
                    return false;                   
                }
            }
        }
        return true;
        
    }
    
    private boolean process(boolean[] visited, char digit){
        if(digit == '.'){
            return true;
        }
        
        int num = digit - '0';
        if ( num < 1 || num > 9 || visited[num-1]){
            return false;
        }
        
        visited[num-1] = true;
        return true;
    }

}