// Implement regular expression matching with support for '.' and '*'.

// '.' Matches any single character.
// '*' Matches zero or more of the preceding element.

// The matching should cover the entire input string (not partial).

// The function prototype should be:
// bool isMatch(const char *s, const char *p)

// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "a*") → true
// isMatch("aa", ".*") → true
// isMatch("ab", ".*") → true
// isMatch("aab", "c*a*b") → true


public class Solution {
	
    public boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        if(p.length()>0) dp[0][1] = false;
        for(int i = 0;i<p.length();i=i+2){
        	if(i+1<p.length() && p.charAt(i+1)=='*')
        		dp[0][i+2]=true;
        	else break;
        }
        for(int j = 0;j<p.length();j++)
             for(int i = 0;i<s.length();i++){
                 if( p.charAt(j)==s.charAt(i) || p.charAt(j)=='.'){
                     dp[i+1][j+1] = dp[i][j]==true?true:false;
                     
                 }
                 else if(p.charAt(j)!=s.charAt(i)){
                     if(p.charAt(j)=='*'){
                         // match with . and s.charAt(i-1)
                         if(s.charAt(i)==p.charAt(j-1) || p.charAt(j-1)=='.')
                         { // critical part
                        	 boolean temp = dp[i][j] || dp[i+1][j] || dp[i+1][j-1]||dp[i][j+1];
                        	 dp[i+1][j+1] = temp;
                         }
                         else
                        	 // not match, omit current *
                        	 dp[i+1][j+1] = dp[i+1][j-1]==true?true:false;
                     }
                 }
             }
       return dp[s.length()][p.length()];
     }
     // recursion, time consuming than mine
        public boolean isMatch2(String s, String p) {
        if (s==null || p==null) return false;
        int M = s.length(), N = p.length();
        if (M==0 && N==0)   return true;
        if (N==0)    return false;
        if (M==0)   return N>=2 && p.charAt(1)=='*' && isMatch(s, p.substring(2));
        if (s.charAt(0)==p.charAt(0) || p.charAt(0)=='.'){
            if (isMatch(s.substring(1), p.substring(1))) return true;
            if (N>=2 && p.charAt(1)=='*' && isMatch(s.substring(1),p))  return true;
        }
        return N>=2 && p.charAt(1)=='*' && isMatch(s, p.substring(2));
    }
}