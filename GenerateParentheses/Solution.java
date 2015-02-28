// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// "((()))", "(()())", "(())()", "()(())", "()()()"



import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Tao Ge
    // Recursion
// Maintain two variables to track the number of left and right parenthesis so far
// prune the invalid string if r>l || r<0 || l<0
// time: O(2^(2n)); 
    pub ArrayList<String> res = new ArrayList<String>();
        if (n == 0)
            return res;
        finder(n, n, res, new String());
        return res;
    }
    
    public void finder(int l, int r, ArrayList<String> res, String s){
        if (l <0 || r <0 || r > l)  // r>l is also invalid
            return; 
        if (l == 0 && r == 0){
            res.add(s);
            return;
        }
        finder(l-1, r, n, res, s+"(");
        finder(l, r-1, n, res, s+")");
    }
    //my solution, To Ge's better than mine
     public List<String> generateParenthesis(int n) {
       return helper(n,n,new ArrayList<String>(), new StringBuilder());
    }
    public List<String>helper(int left, int right, List<String> res, StringBuilder str){
        if(left==0 && right==0){
            res.add(str.toString());
        }
        if(left<=right){
            if(left>0)
            //add left bracket
            {
                str.append('(');
                left--;
                helper(left, right, res, str);
                left++;
                str.deleteCharAt(str.length()-1);
            }
        }
        if(left<right){
            if(right>0)
            {
                str.append(')');
                right--;
                helper(left, right, res, str);
                right++;
                str.deleteCharAt(str.length()-1);
            }
        }
        
      return res;
    }
}