// Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

// For example,
// Given:
// s1 = "aabcc",
// s2 = "dbbca",

// When s3 = "aadbbcbcac", return true.
// When s3 = "aadbbbaccc", return false.



public class Solution {
	public static void main(String[] args){
		Solution test = new Solution();
		System.out.println(test.isInterleave2("aa", "ab","aaba"));
		System.out.println(test.isInterleave("aa", "ab","aaba"));
	
	}
	///dp[i][j]=s1 i to s2 j all possible interleaving combinations
	//first position, pointer1=0|pointer2=0 two choices
	//my solution below
    public boolean isInterleave(String s1, String s2, String s3) {
    	
    	boolean check_1=false ;
    	boolean check_2=false;
    	if(s1.charAt(0)==s3.charAt(0)){
    		check_1= helper(1, 0,1,s1,s2,s3);
    	}
    	if( s2.charAt(0)==s3.charAt(0)){
    		check_2=helper(0,1,1,s1,s2,s3);
    	}
    	return check_1|check_2;
    }
    
    public boolean helper(int p1,int p2,int p3,String s1,String s2, String s3){
    	if(p1+p2==s3.length())
    		return true;
    	if(p1<s1.length() && s1.charAt(p1)==s3.charAt(p3)){
    		boolean check = helper(p1+1,p2,p3+1,s1,s2,s3);
    		if(check==true)
    			return true;
    	}
    	if(p2<s2.length() && s2.charAt(p2)==s3.charAt(p3)){
    		boolean check = helper(p1,p2+1,p3+1,s1,s2,s3);
    		if(check==true)
    			return true;
    	}
    	
    	return false;
    }
    
    // from NineChapter: two-dimension dp[i][j]: s1 to i, s2 to j is interleaved with S3[i+j]
    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        boolean [][] interleaved = new boolean[s1.length() + 1][s2.length() + 1];
        interleaved[0][0] = true;
        
        for (int i = 1; i <= s1.length(); i++) {
            if(s3.charAt(i - 1) == s1.charAt(i - 1) && interleaved[i - 1][0])
                interleaved[i][0] = true;
        }
        
        for (int j = 1; j <= s2.length(); j++) {
            if(s3.charAt(j - 1) == s2.charAt(j - 1) && interleaved[0][j - 1])
                interleaved[0][j] = true;
        }
        
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if(((s3.charAt(i + j - 1) == s1.charAt(i - 1) && interleaved[i - 1][j]))
                    || ((s3.charAt(i + j - 1)) == s2.charAt(j - 1) && interleaved[i][j - 1]))
                interleaved[i][j] = true;
            }
        }
        
        return interleaved[s1.length()][s2.length()];
    }
}