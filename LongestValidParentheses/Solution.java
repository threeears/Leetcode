
// Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

// For "(()", the longest valid parentheses substring is "()", which has length = 2.

// Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

import java.util.Stack;

public class Solution {
   // my secondRound solution, O(n), space O(n) with stack, union-find like solution
     public int longestValidParentheses(String s) {
         if(s.length()<2) return 0;
         int[] match = new int[s.length()];
         Stack<Integer> st  = new Stack<Integer>();//store the index of the current bracket
         for(int i = 0;i<s.length();i++){
             if(s.charAt(i)=='('){
                 st.push(i);//put in the index of the left bracket
             }
             else{
                 if(st.isEmpty())
                      continue;
                  else{
                      int j = i;
                      int currStart=0;
                      int currEnd=0;
                      while(j<s.length() && s.charAt(j)==')' && st.isEmpty()==false){// find the largest nest
                          currStart = st.pop();
                          currEnd = j;
                          j++;
                      }
                      if(i!=j) i = j-1;
                      match[currStart]=currEnd;
                  }
             }
         }
        int maxLen = 0;
        for(int i = 0;i<match.length;i++){      
           // System.out.println(match[i]);
            int k = i;
            if(k<match.length && match[k]!=0){
              while(k<match.length)
              {
                if(match[k]+1<match.length && match[match[k]+1]!=0)
                {match[i] = match[match[k]+1];
                maxLen = Math.max(maxLen, match[i]-i+1);
                k = match[k]+1;
                }
                else{
                  match[i]=match[k];
                  maxLen = Math.max(maxLen, match[i]-i+1);
                  break;
                  }
              }
              i=k;
            }
        }          
         return maxLen;
      }


    //ideal solution O(n)
    public int longestValidParentheses2(String s) {

        if (s == null) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int maxLen = 0;
        int accumulatedLen = 0;

        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    accumulatedLen = 0;
                } else {
                    int matchedPos = stack.pop();
                    int matchedLen = i - matchedPos + 1;

                    if (stack.isEmpty()) {
                        accumulatedLen += matchedLen;
                        matchedLen = accumulatedLen;
                    } else {
                        matchedLen = i - stack.peek();
                    }

                    maxLen = Math.max(maxLen, matchedLen);
                }
            }
        }

        return maxLen;
   }
}