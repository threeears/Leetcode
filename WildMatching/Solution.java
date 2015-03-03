package wildcardMatching;

public class Solution {
	public static void main(String[] args){
		Solution test = new Solution();
		
		System.out.println(test.isMatch3("aa","*"));
	}
    public boolean isMatch2(String s, String p) {  
        int i = 0;  
        int j = 0;  
        int star = -1;  
        int mark = -1;  
        while (i < s.length()) {  
            if (j < p.length()  
                    && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {  
                ++i;  
                ++j;  
            } else if (j < p.length() && p.charAt(j) == '*') {  
                star = j++;  
                mark = i;  
            } else if (star != -1) {  
                j = star + 1;  
                i = ++mark;  
            } else {  
                return false;  
            }  
        }  
        while (j < p.length() && p.charAt(j) == '*') {  
            ++j;  
        }  
        return j == p.length();  
    }  
    // my second round DP solution , memory limit exceed, time and space O(n^2)
    public boolean isMatch(String s, String p){
              boolean[][] dp = new boolean[s.length()+1][p.length()+1];
              dp[0][0]=true;
              if(p.length()==0) return false;
              if(p.length()>0 && p.charAt(0)=='*'){
                  dp[0][1]=true;
              }
              for(int i = 0;i<s.length();i++)
                for(int j = 0;j<p.length();j++){
                    if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')
                    {
                        dp[i+1][j+1]=dp[i][j];
                    }
                    else if(p.charAt(j)=='*'){
                        dp[i+1][j+1]=dp[i][j]||dp[i+1][j]||dp[i][j+1];
                    }
                }
             return dp[s.length()][p.length()];
        }
    // my second solution
      public boolean isMatch(String s, String p){
         // second method, not dp, one time solution based on observation
         Stack<Integer> lastStar = new Stack<Integer>();
         if(s.length()==0 && p.length()==0) return true;
         if(p==null || p.length()==0) return false;

         int pre_star = -1;
         int pre_mark = 0;
         int i = 0;
         int j = 0;
         while(i<s.length()){// only check s, p does not need to 
             if(j<p.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')){
                 i++;
                 j++;
             }
             else if(j<p.length() && p.charAt(j)=='*'){
                 pre_star = j;
                 pre_mark = i;// match to i-1, next comparison i with pre_start+1
                 j++;
             }
             else{
                 if(pre_star!=-1){
                     j = pre_star+1;
                     i = pre_mark++;
                 }
                 else return false;
             }
         }
        
        while(j<p.length()){
         if(p.charAt(j)=='*') 
            j++;
         else
            break;
        }

         return j==p.length();
      }
}
