// You are given an n x n 2D matrix representing an image.

// Rotate the image by 90 degrees (clockwise).

// Follow up:
// Could you do this in-place?
//  画出来！！！脑子不够用！！

public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix.length==1) return ;
        for(int i = 0;i<matrix.length/2;i++){
            helper(matrix, i);
        }  
    }
    public void helper(int[][] matrix, int level){
        
        int start = level;
        int end = matrix.length-level-1;
        int length = end - start;
        for(int i = 0;i<length;i++){
            int temp = matrix[start][start+i];
            // exchange four values in order: (start, start), (start, end), (end, end),(end, start)
            matrix[start][start+i] = matrix[end-i][start];
            matrix[end-i][start] = matrix[end][end-i];
            matrix[end][end-i] = matrix[start+i][end];
            matrix[start+i][end] = temp;
        }
    }
}