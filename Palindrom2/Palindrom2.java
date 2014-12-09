public class Solution {
    public int minCut(String s) {

    	int size  = s.length();
    	boolean isPalindrom[][] = new boolean[size][size];
    	int minCut[][] = new int[size][size];

		if(checkPalindrom(0, size-1, s, isPalindrom)==true)
        return 0;

    	/*initialize*/
    	for(int i = 0; i < size; i++)
    		for(int j = 0; j < size; j++)
    			if(i==j || checkPalindrom(i,j,s,isPalindrom)==true)
    				minCut[i][j] = 0;
    			else minCut[i][j] = size + 1;//give a max interger which cannot be the number of minCut

    	/*compute minCut for every string*/
    	return computeMinCut(0, size-1, s, isPalindrom,minCut);
    	
    	}

    	
   public int computeMinCut(int i, int j, String s, boolean[][] checkPalindrom, int[][] minCut){//compute mincut from i to j
		if(minCut[i][j]==0) return 0;
		for(int pointer=0; pointer < s.length(); pointer++){
		 	if(checkPalindrom[i][pointer]==true){
		      minCut[i][j] = Math.min(1+computeMinCut(pointer+1,j,s,checkPalindrom,minCut),minCut[i][j]);
		    	}   
		 }

		return minCut[i][j];
	}

    public boolean checkPalindrom(int i, int j, String s, boolean[][] sP){
    	boolean temp = false;

    	if(i == j)  temp = true;
    	
    	else if((j-i+1==2) && (s.charAt(i)==s.charAt(j))) temp = true;

    	else if((j-i+1 >2) && (s.charAt(i)==s.charAt(j)) && (checkPalindrom(i+1,j-1,s,sP)==true)) temp = true;

    	sP[i][j] = temp;
    	return temp;

    }

// final answer!! O(n^2) O(n^2)
     public int minCut3 (String s){
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