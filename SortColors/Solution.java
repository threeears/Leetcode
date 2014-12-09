// Given an array with n objects colored red, white or blue, 
//sort them so that objects of the same color are adjacent, with the colors in the order red, 
//white and blue.

// Here, we will use the integers 0, 1, and 2 to represent the color red, white, 
//and blue respectively.

// Note:
// You are not suppose to use the library's sort function for this problem.

// click to show follow up.

// Follow up:
// A rather straight forward solution is a two-pass algorithm using counting sort.
// First, iterate the array counting number of 0's, 1's, and 2's, 
//then overwrite array with total number of 0's, then 1's and followed by 2's.

// Could you come up with an one-pass algorithm using only constant space?
//binary sort?two pointers
//2011020212

public class Solution {
	public static void main(String[] args){
		Solution test = new Solution();
		int[] A = {2,0,1,0,2,0,1,0};
		test.sortColors(A);
		for(int i = 0;i<A.length;i++){
			System.out.println(A[i]);
		}
	}
    //20102010
	    public void sortColors(int[] a) {
	        if(a == null || a.length <= 1)
	            return;
	        
	        int pl = 0;// starter at 1
	        int pr = a.length - 1;//starter at 2
	        int i = 0;
	        while(i <= pr){
	            if(a[i] == 0){
	                swap(a, pl, i);//assume pl is 1
	                pl++;
	                i++;
	            }else if(a[i] == 1){
	                i++;
	            }else{
	                swap(a, pr, i);
	                pr--;
	            }
	        }
	    }
	    
	    private void swap(int[] a, int i, int j){
	        int tmp = a[i];
	        a[i] = a[j];
	        a[j] = tmp;
	    }
	   
}