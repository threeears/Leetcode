public class Solution {
	// my answer also O(n^2) O(n^2)
   public int minCut(String s) {
        boolean[][] pal = new boolean[s.length()][s.length()];
        int[] cut = new int[s.length()+1];//the smallest number of palindromes of length i
        isPalindrome(s,pal);
        cut[0]=0;// string is empty
        for(int i = 1;i<=s.length();i++){
            cut[i]=i;//num of palindromes
            for(int j =i;j>=1;j--){
                if(pal[j-1][i-1]==true){
                    cut[i] = Math.min(cut[j-1]+1,cut[i]);
                }
            }
        }
        return cut[s.length()]-1;
    }
      private void isPalindrome(String s,boolean[][] pal) {
      	//O(n^2)
      for(int i = 0;i<s.length();i++){
          for(int j=0;j<=i;j++){
              if(i==j) 
                    pal[i][j]=true;
              else if(i-j+1<=3) 
                    pal[j][i]=s.charAt(j)==s.charAt(i)?true:false;// distance is 2 or 3
              else
                    pal[j][i]=pal[j+1][i-1] && s.charAt(j)==s.charAt(i);
            }
      }
    }

//  O(n^2) O(n^2), just combine my two steps together, check palindrome and find cut at the same time.
     public int minCut2 (String s){
	    	int[] distance=new int[s.length()];
	    	for(int i = 0;i< s.length();i++){
	    		distance[i]=s.length()-i-1;//max cut for each string from i to end
	    	}
	    	
	    	boolean[][] dp = new boolean[s.length()][s.length()];
	    	for(int i = s.length()-1; i>=0;i--)
	    	{
	    		for(int j = i; j<s.length();j++){
	    			if(i==j) dp[i][j]=true;
	    			else if(s.charAt(i)==s.charAt(j) && j-i+1<=3) 
	    				dp[i][j]=true;
	    			else if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true)
	    				dp[i][j]=true;
	    			
	    			if(dp[i][j]==true)
	    				if(j!=s.length()-1)
		    				distance[i]=Math.min(distance[i], 1+distance[j+1]);
	    				else
	    					distance[i]=0;
	    		}
	    	}
	    	
	    	return distance[0];
	    }
}