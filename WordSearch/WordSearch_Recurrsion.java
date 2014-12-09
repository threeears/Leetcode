public class Solution {
    public boolean exist(char[][] board, String word) {
        int pointer_to_word=0;
		boolean[][] visited = new boolean[board.length][board[0].length];

		for(int i = 0;i<visited.length;i++)
			for(int j=0;j<visited[0].length;j++)
				visited[i][j] = false;
			

		for(int i = 0; i < board.length; i++)
			for(int j=0; j< board[0].length; j++)
				    if(findChar(board, i, j, pointer_to_word,word,visited))
				        return true;
		return false;
     }

    
     public boolean findChar(char[][] board, int i, int j,int index,String word, boolean[][] visited){
            boolean flag=false;
			if(index<word.length() && word.charAt(index) != board[i][j]) return false;
			else {
			    index++;
				visited[i][j]=true;
				if(index == word.length()) return true;//index is from 0 to length-1
				else{
					if(i+1<=board.length-1 && visited[i+1][j]==false ){
    					if(findChar(board,i+1,j,index,word,visited))    return true;//down
					}

					if(j+1<=board[0].length-1 && visited[i][j+1]==false){
						if(findChar(board,i,j+1,index,word,visited))	return true;//right
	    			}

					if(j-1>=0 && visited[i][j-1]==false){
						if(findChar(board,i,j-1,index,word,visited))	return true;//left
					}
					if(i-1>=0 && visited[i-1][j]==false){
						if(findChar(board,i-1,j,index,word,visited)) 	return true;//up
					}
				}
			visited[i][j]=false;
			return false;
		}
	}
}