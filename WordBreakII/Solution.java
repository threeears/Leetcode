// Word Break II Total Accepted: 22308 Total Submissions: 132999 My Submissions Question Solution 
// Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

// Return all such possible sentences.

// For example, given
// s = "catsanddog",
// dict = ["cat", "cats", "and", "sand", "dog"].

// A solution is ["cats and dog", "cat sand dog"].

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	
    public List<String> wordBreak(String s, Set<String> dict) {
        int len = s.length();
        List<String> sol = new ArrayList<String>();
        if(dict.size()==0 || len==0) return sol;
        //check if there is a breakable solution, copy from wordbreakI, actually can be merged in a better way,
        //think about this later
    	boolean[] isBreak = new boolean[s.length()];

        for(int i = s.length()-1;i>=0;i--){
    		String sub2 = s.substring(i,s.length());
    		if(dict.contains(sub2)){
    			isBreak[i] = true;
    		}
    		else{
    			for(int j=i;j<s.length();j++){
    				String st2 = s.substring(i,j+1);
    				if(dict.contains(st2)){
    					isBreak[i] = isBreak[j+1];
    					if(isBreak[i]==true)
    						break;// once found , stop search other combinations
    				}
    			}
    		}
    	}
       if (isBreak[0]==true)
    	   findMatch(0,s,dict,"",sol);
        return sol;
        }
    
  int findMatch(int start, String s, Set<String> dict,String sub,List<String> sol){
        if(start>=s.length()){
        	String result = sub;
        	sol.add(result.substring(0,sub.length()-1));
        	return 1;
        }
        for(String foo:dict){
            int len = foo.length();
            if(start+len<=s.length() && s.substring(start,start+len).equals(foo)){
               findMatch(start+len, s, dict, sub+foo+" ",sol);
            }
        }
        return -1;
    }
//not implemented ninechapter's solution
    public ArrayList<String> wordBreak2(String s, Set<String> dict) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        return wordBreakHelper(s,dict,map);
    }

    public ArrayList<String> wordBreakHelper(String s, Set<String> dict, Map<String, ArrayList<String>> memo){
        if(memo.containsKey(s)) return memo.get(s);
        ArrayList<String> result = new ArrayList<String>();
        int n = s.length();
        if(n <= 0) return result;
        for(int len = 1; len <= n; ++len){
            String subfix = s.substring(0,len);
            if(dict.contains(subfix)){
                if(len == n){
                    result.add(subfix);
                }else{
                    String prefix = s.substring(len);
                    ArrayList<String> tmp = wordBreakHelper(prefix, dict, memo);
                    for(String item:tmp){
                        item = subfix + " " + item;
                        result.add(item);
                    }
                }
            }
        }
        memo.put(s, result);
        return result;
    }
}