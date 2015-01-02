
//Write a program to solve a Sudoku puzzle by filling the empty cells.

// Empty cells are indicated by the character '.'.

// You may assume that there will be only one unique solution.


// A sudoku puzzle...


// ...and its solution numbers marked in red.





public class Solution {
	//DFS + check validity
	public static void main(String[] args){
		Solution test = new Solution();
		
	}
	//only one unique solution
    public void solveSudoku(char[][] board) {
            solve(board);
        }

        public boolean solve(char[][] board) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++){
                    if(board[i][j] != '.'){
                        continue;
                    }//dfs
                    for(int k = 1; k <= 9; k++){
                        board[i][j] = (char) (k + '0');
                        if (isValid(board, i, j) && solve(board)){// the DFS part
                            return true;
                        }
                        board[i][j] = '.';
                    }
                    return false;
                }
            }
            return true;
        }
        
        public boolean isValid(char[][] board, int a, int b){// check current col, row and 3*3 grid
            Set<Character> contained = new HashSet<Character>();
            for(int j=0;j<9;j++){
                if(contained.contains(board[a][j])) return false;
                if(board[a][j]>'0' && board[a][j]<='9')
                    contained.add(board[a][j]);
            }
                
            
        
            contained = new HashSet<Character>();
            for(int j=0;j<9;j++){
                if (contained.contains(board[j][b])) {
                    return false;
                }
                if (board[j][b]>'0' && board[j][b]<='9') {
                    contained.add(board[j][b]);
                }
            }
            
        // how to find current grid , brilliant!
            contained = new HashSet<Character>();
            for (int m = 0; m < 3; m++) {
                for (int n = 0; n < 3; n++){
                    int x = a / 3 * 3 + m, y = b / 3 * 3 + n;
                    if (contained.contains(board[x][y])) {
                        return false;
                    }
                    if (board[x][y] > '0' && board[x][y] <= '9') {
                            contained.add(board[x][y]);
                    }
                } 
            }
        
            return true;
        }
}