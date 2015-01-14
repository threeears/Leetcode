
// Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

// For "(()", the longest valid parentheses substring is "()", which has length = 2.

// Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

import java.util.Stack;

public class Solution {
    public static void main(String[] args){
        Solution test = new Solution();
        System.out.println(test.longestValidParentheses2("()))()(())(())))()(()(())()((()()()))))()))((((()())()(())()))((())))((())())())((())()())(((((())(()((()))()()()))()()())())((()()(("));
        System.out.println(test.longestValidParentheses("()))()(())(())))()(()(())()((()()()))))()))((((()())()(())()))((())))((())())())((())()())(((((())(()((()))()()()))()()())())((()()(("));

    }
    //my solution O(n3) naive solution
    public int longestValidParentheses(String s) {
      if(s.length()<=1) return 0;
      int[]  dp = new int[s.length()];
      dp[0]=0;
      for(int i = 1;i<s.length();i++){
          for(int j=0;j<=i;j++){
              String sub = s.substring(j,i+1);
              if(isValid(sub)==true){
                 //dp[i]=dp[j-1]+i-j+1 when dp[j-1]!=dp[j-2], j-1是否是一个合理序列的结尾
                  if(j>=2 && dp[j-1]!=dp[j-2]){
                      dp[i]=Math.max(dp[j-1]+i-j+1, dp[i]);
                  }
                  else{
                      // if not a valid ending, then restart the calculation
                      dp[i] = Math.max(dp[i],i-j+1);
                  }
              }
              else{
                  if(j>=1)
                      dp[i]=Math.max(dp[j-1],dp[i]);
                  else
                      dp[i]=Math.max(0,dp[i]);
              }
          }
      }
      return dp[s.length()-1];
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
            if (c=='(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && is_valid(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean is_valid(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}')
                || (c1 == '[' && c2 == ']');
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