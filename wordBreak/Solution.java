// Given a string s and a dictionary of words dict, 
//determine if s can be segmented into a space-separated sequence of one or more dictionary words.

// For example, given
// s = "leetcode",
// dict = ["leet", "code"].

// Return true because "leetcode" can be segmented as "leet code".

import java.util.Set;
import java.util.HashSet;
public class Solution {
	public static void main(String[] args){
		Solution test = new Solution();
		Set<String> dict = new HashSet<String>();
		dict.add("a");
		dict.add("abc");
		dict.add("b");
		dict.add("cd");

		String s = "abcd";
		System.out.println(test.wordBreak(s, dict));
	}
public boolean wordBreak(String s, Set<String> dict) {
    	boolean[] isBreak = new boolean[s.length()];
    	
    	for(int i = s.length()-1;i>=0;i--){
    		String sub = s.substring(i,s.length());
    		if(dict.contains(sub)){
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
    	
      return isBreak[0];
    }
}