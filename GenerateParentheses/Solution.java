// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// "((()))", "(()())", "(())()", "()(())", "()()()"



import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static void main(String[] args){
		Solution test = new Solution();
		
		System.out.println(test.generateParenthesis(3));
	}
    public List<String> generateParenthesis(int n) {
        //left number >= right number
        int left = n;
        int right = n;
        List<Character> subList = new ArrayList<Character>();
        List<String> result = new ArrayList<String>();
        subList.add('(');
        left--;
        helper(n,left, right, result, subList);
        return result;
    }
    public boolean helper(int n, int left, int right, List<String> result, List<Character> sub){
        if(sub.size()==2*n){
            //one string is done
            StringBuilder ans = new StringBuilder();
            for(int i = 0;i<sub.size();i++){
                ans.append(sub.get(i));
            }
            result.add(ans.toString());
            return true;
        }
        //if left<right, can put left or right
        if(left<=right && left > 0){
            sub.add('(');
            left--;
            helper(n,left, right, result, sub);
            left++;
            sub.remove(sub.size()-1);
        }
        if(left<right && right >0)
        {
            sub.add(')');
            right--;
            helper(n,left, right, result, sub);
            right++;
            sub.remove(sub.size()-1);
        }
        //if left==right, can only put left in
        return false;
    }
}