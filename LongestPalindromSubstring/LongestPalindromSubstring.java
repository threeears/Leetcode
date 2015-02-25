/*Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, 
and there exists one unique longest palindromic substring.
*/
/*
 *
 1. how to check palindrom?
 palindrom string: 
 if(substring[start]=substring[end] && isPalindrom(start+1, end-1)
 return true;
 */
public class Solution {
     public String longestPalindrome(String s) {
	    	int count=0;
	    	int start=0;
	    	int end=0;
	    	boolean[][] check = new boolean[s.length()][s.length()];
	    	for(int i = s.length()-1;i>=0;i--){
	    		for(int j=i;j<=s.length()-1;j++){
	    			check[i][j]=isPalindrom(s,i,j,check);
	    			if(check[i][j]==true){
	    				if(j-i+1>count){
	    					count = j-i+1;
	    					start=i;
	    					end = j+1;
	    					//System.out.println(s.substring(start, end));
	    				}
	    			}
	    		}
	    	}

	    	return s.substring(start,end);        
	    }
	    public boolean isPalindrom(String s, int start, int end, boolean[][] check){

	    	//traverse through start to end, a little wasteful
	    	if(start==end)
	    		return true;
	    	if((end-start==1) && s.charAt(start)==s.charAt(end))
	    		return true;
	    	else if(s.charAt(start)==s.charAt(end) && check[start+1][end-1]==true)
	    		return true;
	    	else
	    		return false;
	    }	

// from JiuZhang, not checked yet!
	    public String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int length = s.length();    
        int max = 0;
        String result = "";
        for(int i = 1; i <= 2 * length - 1; i++){
            int count = 1;
            while(i - count >= 0 && i + count <= 2 * length  && get(s, i - count) == get(s, i + count)){
                count++;
            }
            count--; // there will be one extra count for the outbound #
            if(count > max) {
                result = s.substring((i - count) / 2, (i + count) / 2);
                max = count;
            }
        }
        
        return result;
    }
    
    private char get(String s, int i) {
        if(i % 2 == 0)
            return '#';
        else 
            return s.charAt(i / 2);
    }

     private int maxLength = 1;
    private int maxIndex = 0;
    public String longestPalindrome(String str) { //O(N^2), space O(1)
        int length = str.length();
        for (int i=0; i<length; i++) {
            // find longest odd palindrome with center i
            findPalindrome(str, length, i, 0);
            // find longest even palindrome with center i
            findPalindrome(str, length, i, 1);
        }
        return str.substring(maxIndex, maxIndex+maxLength);
    }

    private void findPalindrome(String str, int length, int i, int shift) {
      int left = i;
      int right= i+shift;
      while (left >= 0 && right < length && str.charAt(left) == str.charAt(right)) {
        if ((right - left + 1) > maxLength) {
          maxLength = right - left + 1;
          maxIndex = left;
        }
        left--;
        right++;
    }
   }

}

