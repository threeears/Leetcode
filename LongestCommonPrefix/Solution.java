//Write a function to find the longest common prefix string amongst an array of strings.

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        else if (strs.length==1) return strs[0];// special cases to deal with
        
    	String prefix = strs[0];
    	for(int i = 1;i<strs.length;i++){
    		prefix = compare(prefix,strs[i]);
    	}

    	return prefix;
        
    }

    public String compare(String a, String b){
    	int i = 0;
    	int length = Math.min(a.length(),b.length());
    	if(length==0) return "";
    	while(i<length){
    		if(a.charAt(i)!=b.charAt(i))
    			break;
    		i++;
    	}
    	return a.substring(0,i);
    }
}