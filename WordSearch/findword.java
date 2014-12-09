// Given a 2D board and a word, find if the word exists in the grid.

// The word can be constructed from letters of 
//sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. 
//The same letter cell may not be used more than once.

// For example,
// Given board =

// [
//   ["ABCE"],
//   ["SFCS"],
//   ["ADEE"]
// ]
// word = "ABCCED", -> returns true,
// word = "SEE", -> returns true,
// word = "ABCB", -> returns false.
class Coordinate{
	int x;
	int y;
	Coordinate(){
		x = 0;
		y = 0;
	}
}
public class findword {
	char[3][4] board;
	String to_be_mached;
	Coordinate place[];//put all first letter's position in the array
	int top=0;// the top place of the array place[]
	int[5][6] visited={0};

	findword{
		for(int i = 0; i < visited.length;i++){
			visited[0][i] = 1;
			visited[4][i] = 1;
		}
		for(int j = 0; j < visited[0].length;j++){
			visited[i][0] = 1;
			visited[i][5] = 1;
		
		}

		board[0]={A,B,C,E};
		board[1]={S,F,C,S};
		board[2]={A,D,E,E};



	}

	public Boolean to_find_word(int[][] board, String to_be_matched){
		Boolean	result = false;
		int point_to_string=0;
		int check=check_first_letter(board, to_be_matched[point_to_string]);//only first letters in stack
		if (check==0)
			return false;
		else{

			Boolean exist = check_neighbours(board,to_be_matched[point_to_string]);

			while(exist == false and top != 0 ){
				top --;
				point_to_string = 0;
				exist = check_neighbours(board,to_be_matched[point_to_string])
			}
			if (top == 0 && exist == false){
				return false;//all the path are not correct
			}

			while(exit == true && point_to_string <= to_be_matched.length()){
				point_to_string ++;
				exist = check_neighbours(board,to_be_matched[point_to_string]);
			}
			if(point_to_string == to_be_matched.length()){
				return true;
			}

		}
		

	}

	public int check_first_letter(int[][] board, char letter){
		for(int i = 0; i < board.length; i ++){
			for (int j = 0; j < board[i].length; j++){
				if(board[i][j] == letter){//get the first letter's position
					place[top].x = i;
					place[top].y = j;
					top ++;
				} 
			}
		}
		return top;
	}

	public Boolean check_neighbours(char[][] board, char given_char){
		int x = place[top].x;
		int y = place[top].y;
		int i=0;
		int j=0;
		int length = board.length;
		int height = board[0].length;

		visited[x][y]=1;

	

		if(visited[i-1][j]==0 && board[i-1][j]==given_char){
			place[top].x = i-1;
			place[top].y = j;
			return true;
		}
		if(visited[i][j-1]==0 && board[i][j-1]==given_char){
			place[top].x = i;
			place[top].y = j-1;
			return true;
		}
		if(visited[i][j+1]==0 && board[i][j+1]==given_char){
			place[top].x = i;
			place[top].y = j+1;
			return true;
		}
		if(visited[i+1][j]==0 && board[i+1][j]==given_char){
			place[top].x = i+1;
			place[top].y = j;
			return true;
		}

		return false;

	}


}













