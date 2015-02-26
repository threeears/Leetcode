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
        for(int i = 1;i<p.length();i=i+2){
            dp[0][i+1]=p.charAt(i)=='*'?true:false;
            if(dp[0][i+1]==false)
                break;
        }
        for(int i = 0;i<s.length();i++)
            for(int j = 0;j<p.length();j++){
                if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.'){
                    dp[i+1][j+1] = dp[i][j];
                }
                else if(p.charAt(j)=='*'){
                    if(p.charAt(j-1)==s.charAt(i) || p.charAt(j-1)=='.' ){
                        // critical point
                        dp[i+1][j+1]= dp[i][j]||dp[i+1][j-1]||dp[i][j+1];//match or match as empty
                    }
                    else{
                        dp[i+1][j+1] = dp[i+1][j-1];//match as empty
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