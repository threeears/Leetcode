package wildcardMatching;

public class Solution {
	public static void main(String[] args){
		Solution test = new Solution();
		
		System.out.println(test.isMatch3("aa","*"));
	}
	public boolean isMatch(String s, String p) {
        if(s.equals(p)) return true;
        if(p.length()==0) return false;
        if(p.equals("*")) return true;
        int i = 0;
        int j = 0;
        int prePosition_i=-1;
        int prePosition_j=-1;
        while(i<s.length()){
            if(j<p.length() && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')){
                i++;
                j++;
            }
           
            else if(j<p.length() && p.charAt(j)=='*'){
            	prePosition_i=i;
            	prePosition_j=j;
                j++;
            }
            else{
                if(prePosition_j!=-1){
                	i  = prePosition_i+1;
                	j = prePosition_j;
                	prePosition_i++;
                }
                else
                	return false;
            }
        }
      
        if(i==s.length() && j!=p.length())
        {
        	while(j<p.length() && p.charAt(j)=='*'){
        		j++;
        	}
        }
       return j==p.length();
      
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
    
    // my dp solution
    public boolean isMatch3(String s, String p){
        if(s.equals(p)) return true;
        if(s.length()==0) return p.equals("*")?true:false;
        if(p.length()==0) return false;
        int count =0;  
        for(int i=0;i<p.length();i++){  
            if(p.charAt(i)!='*')  
                count++;  //count the number of * if it is larger than length of s, then false
        }  
        if(count>s.length())  
            return false;  
    	String sn=" "+s;
    	String pn=" "+p;
    	boolean[][] dp=new boolean[sn.length()][pn.length()];
    	dp[0][0]=true;//empty match empty
    	dp[0][1]=pn.charAt(1)=='*'?true:false;//* can match empty string
    	dp[1][0]=s.length()==0?true:false;//if s is empty, empty string can match empty    
    	
    	for(int i = 0;i<sn.length();i++){
    		for(int j = 0;j<pn.length();j++){
    			if(i>=1 && j>=1 && dp[i-1][j-1]==true){
    				if(pn.charAt(j)=='?'|| pn.charAt(j)==sn.charAt(i)|| pn.charAt(j)=='*'){
    					dp[i][j]=true;
    					}
    				}
 
    			else if(j>=1 && dp[i][j-1]==true && pn.charAt(j)=='*'){
    					dp[i][j]=true;
    				}
    			else if(i>=1 && dp[i-1][j]==true && pn.charAt(j)=='*'){
    				dp[i][j]=true;
    			}
    			else{
    				if(i>1 || j>1)
    					dp[i][j]=false;
    			}
    		}
    	}
    	return dp[sn.length()-1][pn.length()-1];
    }
    
}
