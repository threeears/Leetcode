// Given an absolute path for a file (Unix-style), simplify it.

// For example,
// path = "/home/", => "/home"
// path = "/a/./b/../../c/", => "/c"
// click to show corner cases.

// Corner Cases:
// Did you consider the case where path = "/../"?
// In this case, you should return "/".
// Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
// In this case, you should ignore redundant slashes and return "/home/foo".

import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.StringBuilder;
public class Solution {
	public static void main(String[] args){
		Solution test = new Solution();
		String path="/../a/../bg/lGyI/";
		System.out.println(test.simplifyPath(path));
	}

	// O(n), can reduce the other stack by using stringbuilder insert set off = zero!!
    public String simplifyPath(String path) {
    	
    	String[] parts = path.split("/");
    	Stack<String> stack = new Stack<String>();
    	Stack<String> st = new Stack<String>();
    	for(String tmp:parts){
    		if(tmp.equals("")){
    			continue;
    		}
    		else {
    			stack.push(tmp);
    			//System.out.println(tmp);
    		}
    	}
    	StringBuilder str = new StringBuilder();// could use str .insert(), insert from start, then save one stack 
    	int flag =0;
    	while(stack.isEmpty()==false){
    		String top = stack.pop();
    		if(top.equals("."))
			{
	
    				continue;
    		}
     		else if(top.equals("..")){
    				flag ++;
    		}
    		else{
    			if(flag>0 ){
    				flag--;
    			}
    			else{

    				st.push(top);
      			    st.push("/");

    			}		

    		}
    	}
    	if(st.size()==0)
    		st.add("/");
    	while(st.size()!=0)
    		str.append(st.pop());
    	return str.toString();
        
    }
}